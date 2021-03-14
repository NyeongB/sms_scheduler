package com.test.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO
{

	public String sel(@Param("id") String id);

	public int getCoins(@Param("id")int type);

	public void smsSubmit();

	public int getCoins_test();

	public ArrayList<UserDTO> getUsers();

}