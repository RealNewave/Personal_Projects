package org.hu.nl.mapreduce;

import java.io.File;
import java.math.BigDecimal;

import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;
import org.hu.nl.mapreduce.inputdata.StructureTrainingData;
import org.hu.nl.mapreduce.outputdata.StructureOutputData;
import org.hu.nl.mapreduce.pagerank.PageRank;

public class Main {
	private static final Logger LOG = Logger.getLogger(PageRank.class);
	
	public static void main(String[] args) throws Exception{
		String inputFile = args[0];
		String outputFile = args[1];
		String sortedOutFile = args[2];
		String structuredInDir = "structuredInput";
		int exitCode = 0;
		
		exitCode = structureTrainingData(inputFile, structuredInDir);
		exitCode = executePageRank(structuredInDir+"/"+Util.getHadoopResult(structuredInDir).getName(), outputFile);		
		
		// order output by pageRank
		exitCode = structureOutputData(outputFile+"/"+Util.getHadoopResult(outputFile).getName(), sortedOutFile);
		LOG.info("\tSummed pagerank (should be 1): \t" + Util.countAllResults(outputFile+"/"+Util.getHadoopResult(sortedOutFile).getName()).toString());
		
		Util.deleteDir(new File(structuredInDir));
		System.exit(exitCode);
	}
	
	public static int structureTrainingData(String inputFile, String outputFile) throws Exception{
		int exitCode = 0;
		String[] mrArgs = new String[2];
		mrArgs[0] = inputFile;
		mrArgs[1] = outputFile;
		
		exitCode = ToolRunner.run(new StructureTrainingData(), mrArgs);
		return exitCode;
	}
	
	public static int executePageRank(String inputFile, String outputFile) throws Exception{
		int exitCode = 0;
		String tempDir = "tmp";
		int numberOfIterations = 10;
		
		Util.addDanglingNodes(inputFile);
		int numNodes = Util.countLines(inputFile);
		inputFile = Util.writeInitialPageRank(numNodes, inputFile, tempDir);

		for(int i = 1; i <= numberOfIterations; i++){
			String tempOut = (i < numberOfIterations) ? tempDir + "/iteration" + i : outputFile;
			
			String[] mrArgs = new String[2];
			mrArgs[0] = inputFile;
			mrArgs[1] = tempOut;
		
			exitCode = ToolRunner.run(new PageRank(), mrArgs);
			
			inputFile = tempOut;
		}
		
		//Util.deleteDir(new File(tempDir));
		return exitCode;
	}
	
	public static int structureOutputData(String inputFile, String outputFile) throws Exception{
		int exitCode = 0;
		
		String[] mrArgs = new String[2];
		mrArgs[0] = inputFile;
		mrArgs[1] = outputFile;
		
		exitCode = ToolRunner.run(new StructureOutputData(), mrArgs);
		
		return exitCode;
	}
}
