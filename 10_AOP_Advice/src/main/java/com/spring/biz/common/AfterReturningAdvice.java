package com.spring.biz.common;

import javax.sound.midi.VoiceStatus;

public class AfterReturningAdvice {
	public void afterReturnLog() {
		System.out.println("[후처리-AfterReturningAdvice.afterReturnLog]"
				+ "비즈니스 로직 수행 후 로그(정상실행시)");
	}
}
