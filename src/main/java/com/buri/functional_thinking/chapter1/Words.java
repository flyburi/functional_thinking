package com.buri.functional_thinking.chapter1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {

	private Set<String> NON_WORDS = new HashSet<String>() {
		{
			add(",");
		}
	};

	public Map freq(String words) {
		TreeMap<String, Integer> wordMap = new TreeMap<>();

		Matcher m = Pattern.compile("\\w+").matcher(words);

		while (m.find()) {
			String word = m.group().toLowerCase();
			if (!NON_WORDS.contains(word)) {
				if (wordMap.get(word) == null) {
					wordMap.put(word, 1);
				} else {
					wordMap.put(word, wordMap.get(word) + 1);
				}
			}
		}

		return wordMap;
	}

	public Map freqLambda(String words) {
		TreeMap<String, Integer> wordMap = new TreeMap<>();

		regexForList(words, "\\w+").stream()
				.map(w -> w.toLowerCase())
				.filter(w -> !NON_WORDS.contains(w))
				.forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
		return wordMap;
	}

	private List<String> regexForList(String words, String regex) {
		List wordList = new ArrayList();
		Matcher m = Pattern.compile(regex).matcher(words);
		while (m.find()) {
			wordList.add(m.group());
		}

		return wordList;
	}

}
