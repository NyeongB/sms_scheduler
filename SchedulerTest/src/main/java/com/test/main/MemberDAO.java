package com.test.main;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	public Collection<SubjectDTO> check(@Param("studentId")String id);
	public Collection<ScoreDTO> score(@Param("studentId")String id, @Param("regYear")String year, @Param("regSemester")String semester);
	public Collection<ScoreDTO> scoreAll(@Param("studentId")String id);
	public Integer delete(@Param("registerCode")String register_code);
	
}