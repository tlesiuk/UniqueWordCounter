package com.home.task;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		if (args.length > 0) {
			// read arguments

			String filename = args[0];
			Integer amountWordsOutput = Integer.valueOf(args[1]);

			// read file
			WordParser parser = new WordParser();
			Map<Object, Integer> words  = parser.fetchWords(TextFileReader.readFile(filename));

			printWords(words, amountWordsOutput);
			return;
		}

		System.out.println("No arguments provided");
	}

	public static void printWords(Map<Object, Integer> words, Integer amount) {
		int count = 0;
		for (Object name: words.keySet()){

			if(count >= amount)
				break;
			
            String key =name.toString();
            String value = words.get(name).toString();  
			
            System.out.println(key + "=" + value);
			count++;

		}

	}
}
