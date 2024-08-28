<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession, java.util.List, dev.service.cloud.model.Quiz, dev.service.cloud.model.QuizOption" %>
<%
 //   HttpSession session = request.getSession();
    int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");

    // 현재 문제와 선택지 가져오기 (예: 문제 내용과 답변 선택지)
    List<Quiz> quizList = (List) request.getAttribute("quizList");
%>
<html>
<body>
    <h2>문제 <%= currentQuestionIndex + 1 %></h2>
    <p><%= quizList.get(currentQuestionIndex).getContent() %></p>


</body>
</html>