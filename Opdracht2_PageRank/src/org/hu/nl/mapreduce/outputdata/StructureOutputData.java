package org.hu.nl.mapreduce.outputdata;

import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.log4j.Logger;

public class StructureOutputData extends Configured implements Tool{
	private static final Logger LOG = Logger.getLogger(StructureOutputData.class);

	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf(), "structureoutputdata");	
		job.setJarByClass(this.getClass());
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(Map.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static class Map extends Mapper<LongWritable, Text, Text, Text> {	
		public void map(LongWritable offset, Text lineText, Context context) throws IOException, InterruptedException{
			String line = lineText.toString();
			String[] values = line.split("\\s+")[0].split(":");
			Text key = new Text(values[0]);
			String value = values[1];
			context.write(new Text(key), new Text(value));
		}
	}
}
