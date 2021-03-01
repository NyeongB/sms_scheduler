package com.test.scheduler;

import java.util.Calendar;

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
		String cal = getCal();
		String str = cal + "\nCOVID-19 QR 체크를 확인하세요." +"\n감사합니다.";

		// static send 클래스 에서 send 메소드 설정 가능
		Send.send(tel, str);
		
	}
	// 크론 표현식 : https://aljjabaegi.tistory.com/400
	// 참고 블로그 : https://m.blog.naver.com/deeperain/221609802306

	
	public String getCal()
	{
		String result = "";
		
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		
		result = year + "년 " + month + "월 " + day +"일 " + getDayOfWeek(dayOfWeek) + "요일";
		
		System.out.println(result);
		
		return result;
	}
	
	public String getDayOfWeek(int day)
	{
		String korDayOfWeek = "";
		switch (day) {
		    case 1:
		        korDayOfWeek = "일";
		        break;
		    case 2:
		        korDayOfWeek = "월";
		        break;
		    case 3:
		        korDayOfWeek = "화";
		        break;
		    case 4:
		        korDayOfWeek = "수";
		        break;
		    case 5:
		        korDayOfWeek = "목";
		        break;
		    case 6:
		        korDayOfWeek = "금";
		        break;
		    case 7:
		        korDayOfWeek = "토";
		        break;
		}
		
		return korDayOfWeek;
	}

}