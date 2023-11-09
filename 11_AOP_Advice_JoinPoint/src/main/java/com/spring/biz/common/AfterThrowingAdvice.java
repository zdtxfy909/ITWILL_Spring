package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
//	public void exceptionLog() {
//		System.out.println("[후처리-AfterThrowingAdvice.exceptionLog]"
//				+ "비즈니스 로직 수행중 예외발생시 로그");
//	}
	
	// execeptObj : 스프링 설정 파일에 설정 추가
	public void exceptionLog(JoinPoint jp, Exception execeptObj) {
		
		if (execeptObj instanceof IllegalArgumentException) {
			System.out.println(">>> 부적합한 값이 전달되었습니다.");
		} else if (execeptObj instanceof NumberFormatException) {
			System.out.println(">>> 숫자형식이 아닙니다.");
		} else if (execeptObj instanceof Exception) {
			System.out.println(">>> 예외가 발생했습니다.");
		} 
		
		System.out.println("[후처리-예외발생] 예외메세지 - " + execeptObj.getMessage());
	}
}
