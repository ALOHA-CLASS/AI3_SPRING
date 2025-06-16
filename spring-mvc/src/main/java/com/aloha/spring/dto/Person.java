package com.aloha.spring.dto;

import java.util.List;

import lombok.Data;

/**
 * 기본 생성자 
 * 매개변수 생성자
 * getter, setter
 * toString
 */
@Data			
public class Person {
	private String name;
	private int age;
	
	// 요청 파라미터의 이름과 
	// 컨트롤러 메소드의 파라미터 이름이 같으면, 객체 안의 변수에 자동 바인딩
	// private String[] hobby;		
	private List<String> hobby;		
}








