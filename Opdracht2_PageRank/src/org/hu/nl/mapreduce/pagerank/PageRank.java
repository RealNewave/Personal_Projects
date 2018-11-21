package org.hu.nl.mapreduce.pagerank;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.hu.nl.mapreduce.Util;

public class PageRank extends Configured implements Tool{
	private static final String nodeIndicator = "-";
	private static final char arraySeparator = ' ';
	private static final String nodeRankSeparator = ":";
	private static BigDecimal danglingPageRank;
	private static int totalNodeCount = 0; 
	
	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf(), "pagerank");	
		job.setJarByClass(this.getClass());

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		danglingPageRank = new BigDecimal("0");
		totalNodeCount = 0;
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static class Map extends Mapper<LongWritable, Text, Text, Text> {
		public void map(LongWritable offset, Text line, Context context) throws IOException, InterruptedException{
				String[] values = line.toString().split("\\s+");
				
				String[] currentNode = values[0].split(nodeRankSeparator);
				BigDecimal nodePageRank = new BigDecimal(currentNode[0]);
				String nodeName = currentNode[1];
				
				String[] adjacentNodes = Arrays.copyOfRange(values, 1, values.length);
				BigDecimal adjacentPageRank = new BigDecimal("0");
				
				if(adjacentNodes.length > 0){
					adjacentPageRank = nodePageRank.divide(new BigDecimal(adjacentNodes.length), 60, RoundingMode.HALF_UP);	
				}else{
					danglingPageRank = danglingPageRank.add(nodePageRank);
				}

				context.write(new Text(nodeName), new Text(nodeIndicator+Util.arrayToString(adjacentNodes, arraySeparator)));
				totalNodeCount++;
				
				for(int i = 0; i < adjacentNodes.length; i++){
					context.write(new Text(adjacentNodes[i]), new Text(""+adjacentPageRank));
				}
		}
	}
		
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		BigDecimal danglingRankPerNode = danglingPageRank.divide(new BigDecimal(totalNodeCount), 60, RoundingMode.HALF_UP);
		
		@Override
		public void reduce(Text nodeName, Iterable<Text> values, Context context) throws IOException, InterruptedException{
			Text adjacentNodes = new Text();
			BigDecimal pageRank = new BigDecimal(danglingRankPerNode.toString());	
			
			for(Text value : values){
				if(value.toString().startsWith(nodeIndicator)){
					adjacentNodes = new Text(value.toString().replace(nodeIndicator, ""));
				}else{
					pageRank = pageRank.add(new BigDecimal(value.toString()));
				}
			}
			
			context.write(new Text(pageRank+nodeRankSeparator+nodeName.toString()),  adjacentNodes);
		}
	}	

}
