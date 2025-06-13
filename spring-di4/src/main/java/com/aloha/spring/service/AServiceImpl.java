package com.aloha.spring.service;

import org.springframework.stereotype.Service;

@Service	// 서비스 빈으로 등록
			// 빈이름 지정하지 않으면, "AServiceImpl" 으로 빈이름 지정됨
public class AServiceImpl implements MyService {

	@Override
	public void test() {
		System.out.println("AServiceImpl...");
	}

}
