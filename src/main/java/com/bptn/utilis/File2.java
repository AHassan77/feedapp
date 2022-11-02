package com.bptn.utilis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


public class File2 {
	
	public static void main(String[] args) throws IOException   {
		// Accessing home directory		
		/*String home = System.getProperty("user.home");
		
		//Check if File exist		
		Path p = Paths.get(home);
		System.out.println(Files.exists(p));
		
		// Check if file does not exist		
		Path p1 = Paths.get(home + "/test.txt");
		System.out.println(Files.notExists(p1));		
		
		//System.out.println(Files.isReadable(p));
		
		Create a File		
		String fileName = "Myfile_" + .txt";
		Path p2 = Paths.get(home + "/" + fileName);
		if(!Files.exists(p2)) {
			Files.createFile(p2);
		}
		
		System.out.println(Files.exists(p2));
		
		// Create a Directory
		String dirName = "myDir_" + UUID.randomUUID().toString();
		Path p3 = Paths.get(home + "/" + dirName);
		if(!Files.exists(p3)) {
		
	}
		System.out.println(Files.exists(p3));
		System.out.println(Files.isRegularFile(p3));
		System.out.println(Files.isDirectory(p3));
		
		// Deleting a File
		
		Path p4 = Paths.get(home + "/test.txt");
		System.out.println("Yes" + Files.exists(p4));
		Files.delete(p4);
		System.out.println("NO" + Files.exists(p4));
		/
		 * 
		 */
	    Path path = Paths.get("C:File.txt");
		      //create file
		      try {
		         Path createdFilePath = Files.createFile(path);
		         System.out.println("Created a file at : "+createdFilePath);
		      } 
		      catch (IOException e) {
		         e.printStackTrace();
		      }
		   }
}
		
	
