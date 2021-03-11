package com.test.main;

import org.springframework.beans.factory.annotation.Autowired;

public class Test
{

	
	public static void main(String[] args)
	{
		MemberService memberService = new MemberService();
		int num = memberService.getCoins_test();
		System.out.println(num);
	}

}
