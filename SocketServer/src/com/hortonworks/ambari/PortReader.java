package com.hortonworks.ambari;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PortReader {
	
	ArrayList<String> lst = new ArrayList<String>();
	int count = 0;
    
	public PortReader(Path file){
		
		Charset charset = Charset.forName("US-ASCII");
		try {
             BufferedReader reader = Files.newBufferedReader(file, charset);
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        lst.add(line);
		        count ++;
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

	public ArrayList<String> getPortList(){
		
		return lst;
	}
	
	 public int getCount(){
		 
		 return count;
	 }


}
