package com.dilraj.studentinfosystems.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dilraj.studentinfosystems.dto.student;
import com.dilraj.studentinfosystems.util.Dbutil;

public class studentDaoImpl implements StudentDao{

	private PreparedStatement ps = null;

	@Override
	public void saveStudentInfo(student student) {
		String sql = "insert into student_details(student_name, college_name, email, gender, subject, departments, roll, dob,image_url)values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getSubject());
			ps.setString(6, student.getDepartments());
			ps.setInt(7, student.getRoll());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setString(9,student.getImageurl());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudentInfo(student student) {
		String sql = "update student_details set student_name=?, college_name=?, email=?, gender=?, subject=?, departments=?, roll=?, dob=?,image_url=? where id=?";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getSubject());
			ps.setString(6, student.getDepartments());
			ps.setInt(7, student.getRoll());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setString(9,student.getImageurl());
			ps.setInt(10, student.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudentInfo(int id) {
		String sql = "delete from student_details where id = ?";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<student> getAllStudentInfo() {
		List<student> studentList = new ArrayList<>();
		String sql = "select * from student_details";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student students = new student();
				students.setId(rs.getInt("id"));
				students.setStudentName(rs.getString("student_name"));
				students.setCollegeName(rs.getString("college_name"));
				students.setEmail(rs.getString("email"));
				students.setGender(rs.getString("gender"));
				students.setSubject(rs.getString("subject"));
				students.setDepartments(rs.getString("departments"));
				students.setRoll(rs.getInt("roll"));
				students.setDob(rs.getDate("dob"));
				studentList.add(students);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public student getStudentInfoById(int id) {
		student students = new student();
		String sql = "select * from student_details where id=?";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				students.setId(rs.getInt("id"));
				students.setStudentName(rs.getString("student_name"));
				students.setCollegeName(rs.getString("college_name"));
				students.setEmail(rs.getString("email"));
				students.setGender(rs.getString("gender"));
				students.setSubject(rs.getString("subject"));
				students.setDepartments(rs.getString("departments"));
				students.setRoll(rs.getInt("roll"));
				students.setDob(rs.getDate("dob"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public String getImageUrl(int id) {
		String sql= "select image_url from student_details where id=?";
		String imageUrl="";
		try {
			ps = Dbutil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageUrl;
	}

}
