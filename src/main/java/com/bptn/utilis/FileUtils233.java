package com.bptn.utilis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils233 {

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

		
	// System.out.println(home);

	static void isFileExist(Path p) {
		
		System.out.println(Files.exists(p));
		
	}

	static void isFileExistsWithExceptionHandling(Path p) {

		Scanner scanner;
		try {
			scanner = new Scanner(new File(p.toUri()));
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();
				logger.debug(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(p);

	}

	static void createFileIfNotExist(Path p2) throws IOException {

			if (!Files.exists(p2)) {
			Files.createFile(p2);
		}

		System.out.println(Files.exists(p2));
	}

	static void readFile(Path p) {
			if (Files.exists(p)) {
			Scanner scanner;
			try {
				scanner = new Scanner(new File(p.toUri()));
				while (scanner.hasNextLine()) {
					String str = scanner.nextLine();
					System.out.println("Data available in file : {}" + str);
					logger.debug(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	static void deleteFile(Path p) throws IOException {
		
		System.out.println("Check if a file exists in " + " folder: hello.txt, " + Files.exists(p));

		Files.deleteIfExists(p);

		System.out.println("Check if a file exists in " + " folder: hello.txt, " + Files.exists(p));

	}
	
	static void writeFile(Path p) throws IOException {
		/*
		 * Path p = Paths.get(home + "writefile.txt"); if(Files.exists(p)){ FileWriter
		 * writer = new FileWriter(new File(p.toUri()));
		 * writer.write("Writing some text into this file"); writer.close();
		 * 
		 */
		
		if (!Files.exists(p)) {
			Files.createFile(p);
		}

		try (FileWriter writer = new FileWriter(new File(p.toUri()))) {

			for (int i = 0; i < 10; i++) {
				writer.write("I love Coding\n");
			}

			System.out.println("File Written Successfully");
		}
	}
	
	static void updateFile(Path p) {
		
		String p1 = p.toString();

		File file = new File(p1);
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			fr.write("Updated the file\n");
			logger.debug(" updated successfully!! ");
			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	
	public static void main(String[] args) throws IOException {
		
		String home = System.getProperty("user.home");
		
		Path p = Paths.get(home + "/test.txt");
		
		deleteFile(p);
		createFileIfNotExist(p);
		isFileExist(p);
		writeFile(p);
		isFileExistsWithExceptionHandling(p);
		updateFile(p);
		readFile(p);
		
		
		

	}
}
