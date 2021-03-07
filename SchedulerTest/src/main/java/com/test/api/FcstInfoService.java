package com.test.api;

import java.util.Calendar;

public class FcstInfoService
{
	/*
	http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst?serviceKey=batOxu2zOyHnSUTDuoPzx1S%2F8EG2uDrqERR%2BrW61OXcpca5btcpEx2ScsBKNpzlErdGE3Cqa9bG2Tiy1Iz46%2Bg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&base_date=20210307&base_time=1200&nx=55&ny=127
	*/
	
	
	// 매일 날짜를 요청하기위한 날짜 출력 메소드
	public String getDay() {
		
		String result="";
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		result = "" + year + month + day;
		
		return result;
		
	}
}
