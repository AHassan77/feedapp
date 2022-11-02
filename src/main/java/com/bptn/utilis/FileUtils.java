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

public class FileUtils {

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	static String home = System.getProperty("user.home");
	
	static Path p = Paths.get(home + "/test.txt");
	
	// System.out.println(home);

	static void isFileExist() {

		System.out.println(home);

		Path p = Paths.get(home + "/test.txt");

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

	static void createFileIfNotExist() throws IOException {

		String fileName = "MyFile" + UUID.randomUUID().toString() + ".txt";
		Path p2 = Paths.get(home + "/" + fileName);
		if (!Files.exists(p2)) {
			Files.createFile(p2);
		}

		System.out.println(Files.exists(p2));
	}

	static void readFile() {
		Path p = Paths.get(home + "/hello.txt");
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

	static void deleteFile() throws IOException {
		p = Paths.get(home + "/" + "file.txt");

		if (!Files.exists(p)) {
			Files.createFile(p);
		}

		System.out.println("Check if a file exists in " + home + " folder: hello.txt, " + Files.exists(p));

		Files.deleteIfExists(p);

		System.out.println("Check if a file exists in " + home + " folder: hello.txt, " + Files.exists(p));

	}
	
	static void writeFile() throws IOException {
		/*
		 * Path p = Paths.get(home + "writefile.txt"); if(Files.exists(p)){ FileWriter
		 * writer = new FileWriter(new File(p.toUri()));
		 * writer.write("Writing some text into this file"); writer.close();
		 * 
		 */
		p = Paths.get(home + "/writefile.txt");

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
	
	static void updateFile() {
		
	}
	
	public static void main(String[] args) throws IOException {
		
		

		//isFileExist();
		isFileExistsWithExceptionHandling(p);
		//createFileIfNotExist();
		//readFile();
		//deleteFile();
		//writeFile();

	}
}
