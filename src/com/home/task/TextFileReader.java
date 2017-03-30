package com.home.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileReader {

	public static List<String> readFile(String filename) {
		List<String> lines = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(
				Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {

			//put lines into list
			lines = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return lines;
	}
}
