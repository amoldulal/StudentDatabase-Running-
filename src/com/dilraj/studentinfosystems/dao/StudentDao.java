package com.dilraj.studentinfosystems.dao;

import java.util.List;

import com.dilraj.studentinfosystems.dto.student;

public interface StudentDao {
	public void saveStudentInfo(student student);
	
	public void updateStudentInfo(student student);
	
	public void deleteStudentInfo(int id);
	
	public List<student> getAllStudentInfo();
	
	public student getStudentInfoById(int id);
	
	public String getImageUrl(int id);
	
}
