package dev.service.cloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.service.cloud.model.Quiz;
import dev.service.cloud.service.QuizService;

@WebServlet("/check")
public class CheckController extends HttpServlet {
	private final QuizService service;

	public CheckController() {
		service = new QuizService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int answer = Integer.parseInt(request.getParameter("answer"));
		System.out.println(answer);
		HttpSession session = request.getSession();
		
		List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");
		int quizNum = (int) session.getAttribute("quizNum");
		
		
		Quiz quiz = quizzes.get(quizNum);
		
		if(service.isCorrectAnswer(quiz, answer)) {
			if(++quizNum == quizzes.size()) {
				response.sendRedirect("success.html");
			}else {
				session.setAttribute("quizNum", quizNum);
				response.sendRedirect("quiz.jsp");
			}
		}else {
			response.sendRedirect("wrong.html");
		}
	}

}
