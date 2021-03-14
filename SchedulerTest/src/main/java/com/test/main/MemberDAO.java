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

	public int getTotal(String id);

	public void smsSubmit2(String id);

	public void setOff(String id);

	public void setOn(String id);

	public String getType(String id);

}