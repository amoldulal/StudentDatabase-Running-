package com.dilraj.studentinfosystems.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dilraj.studentinfosystems.dto.student;
import com.dilraj.studentinfosystems.service.StudentService;
import com.dilraj.studentinfosystems.service.studentServiceImpl;
import com.dilraj.studentinfosystems.util.ImageUtil;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENT_LIST_PAGE = "studentDetails.jsp";
	private static final String STUDENT_NEW_PAGE = "studentForm.jsp";
	StudentService studentservice = new studentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equals("student_list")) {
			request.setAttribute("students", studentservice.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;
		} else if (action.equals("student_new")) {
			forward = STUDENT_NEW_PAGE;
		} else if (action.equals("student_edit")) {
			int id = Integer.parseInt(request.getParameter("studentId"));
			request.setAttribute("student", studentservice.getStudentInfoById(id));
			forward = STUDENT_NEW_PAGE;
		} else if (action.equals("student_delete")) {
			int id = Integer.parseInt(request.getParameter("studentId"));
			studentservice.deleteStudentInfo(id);
			request.setAttribute("students", studentservice.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		student students = new student();
		students.setStudentName(request.getParameter("sname"));
		students.setCollegeName(request.getParameter("cname"));
		students.setEmail(request.getParameter("email"));
		students.setRoll(Integer.parseInt(request.getParameter("roll")));
		students.setDepartments(request.getParameter("department"));
		students.setGender(request.getParameter("gender"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date dob = dateFormat.parse(request.getParameter("dob"));
			students.setDob(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] subjects = request.getParameterValues("subject");
		
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		students.setSubject(subject);
		String studentId = request.getParameter("id");
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(imageUrl + fileName, part);
		} else {
			imageUrl = studentservice.getImageUrl(Integer.parseInt(studentId));
		}

		students.setImageurl(imageUrl);

		if (studentId == null || studentId.isEmpty()) {
			studentservice.saveStudentInfo(students);
		} else {
			students.setId(Integer.parseInt(studentId));
			studentservice.updateStudentInfo(students);
		}
		RequestDispatcher rd = request.getRequestDispatcher(STUDENT_LIST_PAGE);
		request.setAttribute("students", studentservice.getAllStudentInfo());
		rd.forward(request, response);

	}

}
