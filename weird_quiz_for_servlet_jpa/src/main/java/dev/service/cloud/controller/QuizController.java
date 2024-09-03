package dev.service.cloud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.service.cloud.model.Quiz;
import dev.service.cloud.model.User;
import dev.service.cloud.service.QuizService;

@WebServlet("/quiz")
public class QuizController extends HttpServlet {
	private final QuizService service;

	public QuizController() {
		service = new QuizService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (session.isNew() || user == null) {
			PrintWriter out = response.getWriter();
			out.print("로그인하세요<br/>");
			out.print("<a href=\"./\">홈으로...</a>");
			out.close();
			return;
		}

		List<Quiz> quizzes = service.selectQuizzes();

		for (Quiz quiz : quizzes) {
			quiz.getOptions();
		}

		session.setAttribute("quizzes", quizzes);
		session.setAttribute("quizNum", 0);

		RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
		dispatcher.forward(request, response);
	}
}
