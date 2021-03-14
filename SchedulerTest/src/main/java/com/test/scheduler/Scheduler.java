package com.test.scheduler;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.test.main.MemberService;
import com.test.main.UserDTO;
import com.test.sms.Send;

@Component
public class Scheduler
{

	@Autowired
	private MemberService memberService;

	/**
	 * 주중 매일 아침 8시 50분에 출근 후 QR 체크하라고 알림을 주는 프로그램
	 */

	//@Scheduled(cron = "0 50 8 * * 1-5")
	@Scheduled(cron = "0 41 16 * * 0-6")
	public void scheduler()
	{
		ArrayList<UserDTO> list = memberService.getUsers();
		
		for(UserDTO user : list)
		{
			System.out.println(user.getName());
		}
		
		//submitSms();
	}
	/*
	 * 21.03.03 오류 내용 서버에 프로그램 구동중에 문자 발송이 안됌 원인 : getCoins() 메소드와 매핑된 쿼리에서 type이 0인
	 * 값이 없음 nvl로 처리 -> NVL해도 아무것도 안나옴 테스트0값 넣음
	 */
	// 크론 표현식 : https://aljjabaegi.tistory.com/400
	// 참고 블로그 : https://m.blog.naver.com/deeperain/221609802306

	public void submitSms2(String tel, String onoff, String id)
	{
		// 보낼 전화번호와 문자열 입력
		String cal = getCal();
		String str = cal + "\nCOVID-19 QR 체크를 확인하세요.";

		// 잔액 체크
		int total_money = memberService.getCoins_test();
		//int total = memberService.getCoins(1);
		//int sub = memberService.getCoins(0);

		if (total_money < 20)
			return;
		System.out.println("현재 잔액 : " + (total_money));

		// 20원 차감 -> 데이터베이스에 기록
		memberService.smsSubmit();
		System.out.println("OK");

		// 문자 발송, Send 클래스 에서 send 메소드 설정 가능
		int after = (total_money - 20);
		String money = String.format("%,d", after);
		str += "\n[문자 발송 후 잔액 : " + money + "원]";
		//Send.send(tel, str);
		System.out.println("발송 후 잔액 : " + (after));
	}
	
	public void submitSms()
	{
		// 보낼 전화번호와 문자열 입력
		String tel = "01099659257";
		String cal = getCal();
		String str = cal + "\nCOVID-19 QR 체크를 확인하세요.";

		// 잔액 체크
		int total_money = memberService.getCoins_test();
		//int total = memberService.getCoins(1);
		//int sub = memberService.getCoins(0);

		if (total_money < 20)
			return;
		System.out.println("현재 잔액 : " + (total_money));

		// 20원 차감 -> 데이터베이스에 기록
		memberService.smsSubmit();
		System.out.println("OK");

		// 문자 발송, Send 클래스 에서 send 메소드 설정 가능
		int after = (total_money - 20);
		String money = String.format("%,d", after);
		str += "\n[문자 발송 후 잔액 : " + money + "원]";
		Send.send(tel, str);
		System.out.println("발송 후 잔액 : " + (after));
	}

	public String getCal()
	{
		String result = "";

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		result = year + "년 " + month + "월 " + day + "일 " + getDayOfWeek(dayOfWeek) + "요일";

		System.out.println(result);

		return result;
	}

	public String getDayOfWeek(int day)
	{
		String korDayOfWeek = "";
		switch (day)
		{
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