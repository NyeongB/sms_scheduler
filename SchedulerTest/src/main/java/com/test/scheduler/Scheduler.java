package com.test.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.test.sms.Send;

@Component
public class Scheduler
{
	/**
	 * 주중 매일 아침 8시 50분에 출근 후 QR 체크하라고 알림을 주는 프로그램
	 */

	@Scheduled(cron = "0 50 8 * * 2-6")
	public void autoUpdate()
	{
		// 보낼 전화번호와 문자열 입력
		String tel = "01099659257";
		String str = "COVID-19 QR 체크를 확인하세요.";

		// static send 클래스 에서 send 메소드 설정 가능
		Send.send(tel, str);
		
	}
	// 크론 표현식 : https://aljjabaegi.tistory.com/400
	// 참고 블로그 : https://m.blog.naver.com/deeperain/221609802306

	

}