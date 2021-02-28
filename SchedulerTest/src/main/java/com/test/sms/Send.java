package com.test.sms;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

// 휴대폰 인증을 위한 클래스
public class Send
{
	public static void send(String tel)
	{
		// coolsms api 설정
		String api_key = "NCSK3SWNJNK7KFNX";
		String api_secret = "ASIQZOSSE7DOROFR4TZ1SOPX1ILC7UFR";
		Message coolsms = new Message(api_key, api_secret);
		
		
		// 문자 메세지 설정
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", tel); // 수신번호
		params.put("from", "01099659257"); // 발신번호
		params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
		params.put("text", "COVID-19 QR 체크를 확인하세요. "); // 문자내용
		params.put("app_version", "JAVA SDK v1.2"); // application name and version

		try
		{
			// Json 형태로 보내기
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
			
		} catch (CoolsmsException e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		
		
	}
}
