package com.test.main;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO
{

	public String sel(@Param("id") String id);

}