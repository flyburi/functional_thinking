package com.buri.functional_thinking.chapter2;

import java.util.List;
import java.util.stream.Collectors;

public class TheCompanyProcess {

	//for문을 이용한 명령형 처리
	public String cleanNames(List<String> listOfNames) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < listOfNames.size(); i++) {
			if (listOfNames.get(i).length() > 1) {
				result.append(capitalizeFirstLetter(listOfNames.get(i))).append(",");
			}
		}
		return result.substring(0, result.length() - 1);
	}

	//함수형 처리
	//고계함수에 매개변수로 주어지는 함수(고계함수)를 이용.
	public String cleanNamesLambda(List<String> names) {
		if (names == null) return "";

		return names.stream()
				.filter(name -> name != null)
				.filter(name -> name.length() > 1)
				.map(name -> capitalizeFirstLetter(name))
				.collect(Collectors.joining(","));
	}

	private String capitalizeFirstLetter(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
	}
}
