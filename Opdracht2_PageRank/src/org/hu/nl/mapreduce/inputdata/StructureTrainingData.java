package org.hu.nl.mapreduce.inputdata;

import java.io.IOException;

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
import org.apache.log4j.Logger;

public class StructureTrainingData extends Configured implements Tool{
	private static final Logger LOG = Logger.getLogger(StructureTrainingData.class);

	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf(), "structuretrainingdata");	
		job.setJarByClass(this.getClass());
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static class Map extends Mapper<LongWritable, Text, Text, Text> {
		public void map(LongWritable offset, Text lineText, Context context) throws IOException, InterruptedException{
			String line = lineText.toString();
			String[] values = line.split("\\s+");
			String key = values[0];
			String value = values[1];
			context.write(new Text(key), new Text(value));
		}
	}
		
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		@Override
		public void reduce(Text word, Iterable<Text> values, Context context) throws IOException, InterruptedException{
			String valueResult = "";
			for( Text value : values){
				valueResult += " " + value.toString();
			}
			context.write(word,  new Text(valueResult));
		}
	}
}
