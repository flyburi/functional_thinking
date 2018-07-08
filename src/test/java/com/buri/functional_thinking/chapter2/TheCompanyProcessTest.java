package com.buri.functional_thinking.chapter2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Chapter 2. 전환
 * 예제 : 어떤 이름 목록에서, 한 글자로 된 이름을 제외한 모든 이름의 첫글자를 대문자화해서 쉼표로 연결한 문자열을 구하자.
 */
@Slf4j
public class TheCompanyProcessTest {

	private static final List<String> companies = new ArrayList<>(Arrays.asList("google", "netflix", "amazone", "c"));

	@Test
	public void cleanNames() {
		TheCompanyProcess process = new TheCompanyProcess();
		String result = process.cleanNames(companies);
		assertEquals("result", "Google,Netflix,Amazone", result);
	}

	@Test
	public void cleanNamesLambda() {
		TheCompanyProcess process = new TheCompanyProcess();
		String result = process.cleanNamesLambda(companies);
		assertEquals("result", "Google,Netflix,Amazone", result);
	}


}
