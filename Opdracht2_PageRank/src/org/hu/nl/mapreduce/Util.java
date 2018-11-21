package org.hu.nl.mapreduce;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Util {
	public static int countLines(String fileName) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(fileName));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
	
	public static void addDanglingNodes(String fileName){
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			FileWriter writer = new FileWriter(fileName, true);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> keys = new ArrayList<>();
			List<String> values = new ArrayList<>();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] lineValues = line.split("\\s+");
				keys.add(lineValues[0]);
				for(int i = 1; i < lineValues.length; i++){
					if(!values.contains(lineValues[i])){
						values.add(lineValues[i]);
					}
				}
			}
			for(String value : values){
				if(!keys.contains(value)){	
					writer.write(value+"\n");
				}
			}
			fileReader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String writeInitialPageRank(int numNodes, String fileName, String tempDir){
		String outFile = tempDir+"/nodes.text";
		createDir(tempDir);
		
		BigDecimal pageRank = new BigDecimal("1").divide(new BigDecimal(""+numNodes), 60, RoundingMode.HALF_UP);
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			FileWriter writer = new FileWriter(outFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				writer.write(pageRank+":"+line +"\n");
			}
			fileReader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outFile;
	}
	
	public static File getHadoopResult(String dirName){
		File dir = new File(dirName);
		File[] foundFiles = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith("part");
		    }
		});
		return foundFiles[0];
	}
	
	public static String arrayToString(String[] array, char separator){
		String result = "";
		for(int i = 0; i < array.length; i++){
			result += array[i] + separator;
		}
		try{
			result = result.substring(0, result.lastIndexOf(separator));
		}catch(StringIndexOutOfBoundsException e){
			// ignore, means there are no adjacent nodes
		}		
		return result;
	}
	
	public static void createDir(String dirName){
		File dir = new File(dirName);
		if(!dir.exists()){
			dir.mkdir();
		}
	}
	
	public static void deleteDir(File file) throws IOException{
    	if(file.isDirectory()){
    		if(file.list().length==0){
    		   file.delete();
    		}else{
        	   String files[] = file.list();
        	   for (String temp : files) {
        	      File fileDelete = new File(file, temp);
        	     deleteDir(fileDelete);
        	   }
        	   if(file.list().length==0){
           	     file.delete();
        	   }
    		}
    	}else{
    		file.delete();
    	}
	}
	
	public static BigDecimal countAllResults(String fileName){
		BigDecimal result = new BigDecimal("0");
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] values = line.split("\\s+")[0].split(":");
				result = result.add(new BigDecimal(values[0]));
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
