package com.buri.functional_thinking.chapter2;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * 2.3 공통된 빌딩 블록
 * 각기 이름은 다르지만, 함수형 언어 및 프레임워크 어디에나 존재하는 유용한 작업들을 하는 유용한 작업들을 알아본다.
 */
@Slf4j
public class NumberClassifierTest {

	//2.3.1 필터
	// 자바 8 에서의 필터 작업
	// Stream을 종료한 뒤 값으로 만드는 것과 같은 다른 작업과 연계할 수 있도록 IntStream을 리턴한다.
	//factorsOf()의 리턴 값은 자연수의 목록이 아니라 아직 값으로 전환되지 않은 스트림이다.
	public static IntStream factorsOf(int number) {
		return range(1, number+1)
				.filter(potential -> number % potential == 0);
	}


	//2.3.2 맵
	//맵 연산은 컬렉션의 각 요소에 같은 함수를 적용하여 새로운 컬렉션으로 만든다.


	//2.3.3 폴드/리듀스
	//셋째로 자주 사용하는 함수는 많이 사용하는 언어들 사이에서도 이름이 다양하고 약간씩 의미도 다르다.
	//foldLeft나 reduce는 캐터모피즘(카테고리 이론의 개념으로 목록을 접어서 다른 형태로 만드는 연산을 총칭)이라는 목록 조작 개념의 특별한 변형이다.


}
