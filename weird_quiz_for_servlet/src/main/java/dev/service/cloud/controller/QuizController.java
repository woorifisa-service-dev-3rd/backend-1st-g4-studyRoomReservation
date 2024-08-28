package dev.service.cloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.service.cloud.dao.QuizDAO;
import dev.service.cloud.model.Quiz;
import dev.service.cloud.service.QuizService;


@WebServlet("/quiz")
public class QuizController extends HttpServlet{

	private final QuizDAO quizDAO;
	private final QuizService quizService; 

	
	public QuizController(){	
		this.quizService = new QuizService();
		this.quizDAO = new QuizDAO();
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
//		int score = (int) session.getAttribute("score");
//
//		// 사용자의 답변을 받아 검토[.
//		String userAnswer = request.getParameter("answer");
//		boolean isCorrect = quizService.isCorrectAnswer( quiz, userAnswer);
//		if (isCorrect) {
//			score++;
//		}
//		session.setAttribute("score", score);
//
//		// 다음 문제로 이동 (마지막 문제일 경우 결과로 이동)
//		currentQuestionIndex++;
//		if (currentQuestionIndex >= totalQuestions) {
//			request.getRequestDispatcher("/result.jsp").forward(request, response);
//		} else {
//			session.setAttribute("currentQuestionIndex", currentQuestionIndex);
//			request.getRequestDispatcher("/quiz.jsp").forward(request, response);
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		List<Quiz> quiz = quizDAO.findTop10OrderByRandom();

		// 요청 객체에 quizList라는 이름의 키값으로 quiz 데이터를 저장
		request.setAttribute("quizList", quiz);

		// jsp페이지로 전달 -> forword
		session.setAttribute("currentQuestionIndex", 0);
		request.getRequestDispatcher("/quiz.jsp").forward(request, response);
	}



	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

			
		
	}
}
