package dev.service.cloud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.service.cloud.model.User;
import dev.service.cloud.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private final UserService service;

	public LoginController() {
		this.service = new UserService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		System.out.println(userId + " " + password);
		
		try {
			User user = service.login(userId, password);
			
			session.setAttribute("user", user);
			response.sendRedirect("/quiz");
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
	}

}
