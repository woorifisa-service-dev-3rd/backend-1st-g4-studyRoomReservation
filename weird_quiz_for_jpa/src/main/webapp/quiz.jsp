<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>Weird Quiz</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
    <%
    // 세션에서 quizNum과 quizzes 리스트 가져오기
    Integer quizNum = (Integer) session.getAttribute("quizNum");
    List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");

    // quizzes 리스트가 비어 있거나 null인 경우 처리
    if (quizzes == null || quizzes.isEmpty()) {
        out.println("<p>퀴즈 데이터가 없습니다. 관리자에게 문의하세요.</p>");
    } else if (quizNum == null || quizNum < 0 || quizNum >= quizzes.size()) {
        out.println("<p>잘못된 퀴즈 번호입니다. 관리자에게 문의하세요.</p>");
    } else {
        // 현재 문제 가져오기
        Quiz quiz = quizzes.get(quizNum);
    %>

    <h2>
        문제 <%=quizNum+1%>. <%=quiz.getContent()%>
    </h2>
    
    <form action="check" method="post">
        <c:forEach items="<%=quiz.getOptions()%>" var="option">
            <input type="radio" name="answer" value="${option.id}" /> 
            ${option.content}<br />
        </c:forEach>
        <input type="submit" value="제출" />
    </form>

    <%
    }
    %>
</body>
</html>
