package com.aloha.spring.service;

import org.springframework.stereotype.Service;

// 서비스 빈으로 등록
// 빈등록어노테이션("빈이름")
// * 빈이름을 지정하지 않으면 클래스이름을 기본으로 지정
// * "빈이름"을 지정하면, 의존성 주입 시,
//   @Qualifier("빈이름") 으로 빈을 특정하여 주입할 수 있다.
@Service("C")
public class CServiceImpl implements MyService {

	@Override
	public void test() {
		System.out.println("CServiceImpl...");
	}

}
