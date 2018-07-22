package com.buri.functional_thinking.chapter1;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * Chapter 1. 왜
 * 예제 : 텍스트 파일을 읽고, 가장 많이 사용된 단어들을 찾고, 그 단어들과 빈도를 정렬된 목록으로 출력하라.
 */

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
