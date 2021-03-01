package com.test.main;

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
	
}
