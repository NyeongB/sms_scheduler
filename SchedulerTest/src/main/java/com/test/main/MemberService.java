package com.test.main;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service	
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public String sel(String id) {
		return memberDAO.sel(id);
	}
	
	public int getCoins(int type)
	{
		return memberDAO.getCoins(type);
	}
	
	public void smsSubmit() {
		memberDAO.smsSubmit();
	}
	
	public void smsSubmit2(String id) {
		memberDAO.smsSubmit2(id);
	}

	public int getCoins_test()
	{
		return memberDAO.getCoins_test();
		// TODO Auto-generated method stub
		
	}

	public ArrayList<UserDTO> getUsers()
	{
		// TODO Auto-generated method stub
		return memberDAO.getUsers();
	}

	public int getTotal(String id)
	{
		// TODO Auto-generated method stub
		return memberDAO.getTotal(id);
	}
	
}
