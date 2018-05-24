package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextFileFactory {
	public static ArrayList<String> readFile (String path) {
		ArrayList<String> list = new ArrayList<>();
		try(FileInputStream fis = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)){
		
		String line = br.readLine();
		while(line!=null) {
			list.add(line);
			line = br.readLine();
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
