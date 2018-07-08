package com.buri.functional_thinking.chapter1;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class WordsTest {

	private static String words = "java, scala, kotlin, swift, java, scala, swift, java";

	@Test
	public void freq() {
		Words word = new Words();
		Map<String, Integer> map = word.freq(words);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			log.info("Key : " + entry.getKey() + " , Count : " + entry.getValue());
		}
	}

	@Test
	public void freqLambda() {
		Words word = new Words();
		Map<String, Integer> map = word.freqLambda(words);
		map.forEach((k, v) -> log.info("Key : " + k + " , Count : " + v));

	}
}
