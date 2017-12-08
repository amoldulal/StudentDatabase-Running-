package com.dilraj.studentinfosystems.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dilraj.studentinfosystems.service.StudentService;
import com.dilraj.studentinfosystems.service.studentServiceImpl;

/**
 * Servlet implementation class ImageDisplayController
 */
@WebServlet("/ImageDisplayController")
public class ImageDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_BUFFER_SIZE = 1024;
	StudentService studentService = new studentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studenId = request.getParameter("studentId");
		String filePath = studentService.getImageUrl(Integer.parseInt(studenId));

		File file = new File(filePath);
		String contentType = getServletContext().getMimeType(file.getName());
		if (contentType == null) {
			contentType = "application/octet-stream";

		}
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

		byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			int length;
			while ((length = in.read(bytes)) > 0) {
				out.write(bytes, 0, length);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}

	}
}
