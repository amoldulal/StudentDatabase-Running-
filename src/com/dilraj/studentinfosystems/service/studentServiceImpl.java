package com.dilraj.studentinfosystems.service;

import java.util.List;

import com.dilraj.studentinfosystems.dao.StudentDao;
import com.dilraj.studentinfosystems.dao.studentDaoImpl;
import com.dilraj.studentinfosystems.dto.student;

public class studentServiceImpl implements StudentService {
	StudentDao studentDao = new studentDaoImpl();

	@Override
	public void saveStudentInfo(student student) {
		studentDao.saveStudentInfo(student);
	}

	@Override
	public void updateStudentInfo(student student) {
		// TODO Auto-generated method stub
		studentDao.updateStudentInfo(student);
	}

	@Override
	public void deleteStudentInfo(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteStudentInfo(id);
	}

	@Override
	public List<student> getAllStudentInfo() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudentInfo();
	}

	@Override
	public student getStudentInfoById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentInfoById(id);
	}

	@Override
	public String getImageUrl(int id) {
		// TODO Auto-generated method stub
		return studentDao.getImageUrl(id);
	}
}