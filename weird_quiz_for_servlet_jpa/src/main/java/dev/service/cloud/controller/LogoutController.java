package dev.service.cloud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.service.cloud.model.User;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		if(session.isNew() || user != null) {
			PrintWriter out = response.getWriter();
			out.print("아직 로그인하지 않았습니다.<br/>");
			out.print("<a href=\"./\">홈으로...</a>");
			out.close();
		}else {
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		}
		
	}

}
