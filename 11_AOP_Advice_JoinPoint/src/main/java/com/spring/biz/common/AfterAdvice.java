package com.spring.biz.common;

public class AfterAdvice {
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.AfterAdvice]"
				+ "비즈니스 로직 수행 후 로그(언제나, 무조건)");
	}
}
