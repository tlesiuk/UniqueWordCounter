package com.home.task.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.home.task.TextFileReader;
import com.home.task.WordParser;

public class WordParserTest {

	@Test
	public void testWordParser() {
		String filename = "test1.txt";

		// read file
		WordParser parser = new WordParser();
		Map<Object, Integer> words = parser.fetchWords(TextFileReader.readFile(filename));
		
		assertEquals(1, words.get("cat").intValue());
		assertEquals(1, words.get("dog").intValue());
		assertEquals(1, words.get("ice").intValue());
		assertEquals(2, words.get("hello").intValue());
	}
	
	@Test
	public void testWordParser2() {
		String filename = "test2.txt";

		// read file
		WordParser parser = new WordParser();
		Map<Object, Integer> words = parser.fetchWords(TextFileReader.readFile(filename));
		
		assertEquals(2, words.get("cat").intValue());
		assertEquals(1, words.get("dog").intValue());
		assertEquals(2, words.get("hello").intValue());
	}
}
