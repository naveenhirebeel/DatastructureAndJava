package com.java8;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6_FileHandling {

	public static void main(String[] args) {
		String fileName = "C:/Folders/Training/Java8/Lambda/src/all/student.txt";
		
		//---------------------
		//Using Buffered reader
		try(BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			List<String> list = br.lines().collect(Collectors.toList());
			list.forEach(str -> System.out.println(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//------------------------------------------
		//Using Stream
		/*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out :: println);
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		
		
		
	}
	
}
