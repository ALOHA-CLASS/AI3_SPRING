package com.aloha.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger 
					= LoggerFactory.getLogger(LoggingAspect.class);

	/*
	 * 어드바이스 유형 
	 * - Around
	 * - Before
	 * - After
	 * - AfterReturning
	 * - AfterThowing
	*/
	/*
	 * 포인트컷 표현요소
	 * - 지시자 : execution
	 * - 반환값
	 * - 패키지
	 * - 클래스
	 * - 메소드
	 * - 인수
	*/
	// execution( 접근제한자 반환타입 패키지.클래스.메서드(파라미터) )
	@Before("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void before(JoinPoint jp) {
		// jp.getSignature() : 타겟 메소드의 시그니처 정보(반환타입, 패키지.클래스.메소드) 반환
		// jp.getArgs()		 : 타겟 메소드의 매개변수를 반환
		logger.info("==================================================");
		logger.info("[@Before] ########################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()));
		// 파라미터 출력
		printParam(jp);
		logger.info("==================================================");
	}
	
	/**
	 * 파라미터 출력
	 * @param jp
	 */
	public void printParam(JoinPoint jp) {
		Signature signature = jp.getSignature();
		// 타겟 메소드의 파라미터 이름 가져오기
		String[] parameterNames = ((MethodSignature) signature).getParameterNames();
		// 타겟 메소드의 인수 가져오기
		Object[] args = jp.getArgs();
		// 파라미터 이름과 값을 출력
		if( parameterNames != null ) 
			for (int i = 0; i < parameterNames.length; i++) {
				String paramName = parameterNames[i];
				Object paramValue = args[i];
				logger.info("파라미터명 : " + paramName +  ", 값 : " + paramValue);
			}
		
	}
	
}

















