package com.home.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordParser {

	public Map<Object, Integer> fetchWords(List<String> lines) {
		Map<Object, Integer> words = new HashMap<Object, Integer>();
		
		// remove all empty words
		lines.removeIf(item -> item == null || "".equals(item));
		
		Stream<String> stream = lines.stream();

		words = stream
			       .flatMap(s -> Stream.of(s.split("\\s|\\,|\\.")))

			       .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum)); 
		
		// remove whitespaces from map during parsing
		words = words.entrySet().stream()
				 .filter(map -> !map.getKey().toString().isEmpty())
	                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		return words;
						
	}
}
