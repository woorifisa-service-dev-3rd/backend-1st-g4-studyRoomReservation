# G4 - Weird Quiz
<br>

## 💡 프로젝트 소개
콘솔 게임 프로젝트입니다.<br>
### 😱 게임 소개
당신은 끝없이 펼쳐진 문제들에 갇히고 말았습니다.<br>
문제를 잘 살피며 10번 문제까지 완료하세요.<br>
단 하나의 이상한 점도 놓치지 마세요.<br>
이상한 점을 발견하면 즉시 오답을 선택하세요.<br>
이상한 점이 없으면 정답을 선택하세요.<br>
10번 문제까지 도달하여 모든 문제를 완료하세요.<br>

<br>

## 👨‍💻 팀원 소개

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Kong-E">
        <img src="https://github.com/Kong-E.png" alt="공소연" width="150" height="150"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/SeungAh-Yoo99">
        <img src="https://github.com/SeungAh-Yoo99.png" alt="유승아" width="150" height="150"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/doyi0107">
        <img src="https://github.com/doyi0107.png" alt="이도이" width="150" height="150"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/dpdms529">
        <img src="https://github.com/dpdms529.png" alt="조예은" width="150" height="150"/>
      </a>
    </td>
  </tr>
   <tr>
    <td align="center">
      <a href="https://github.com/Kong-E">
        <b>공소연</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/SeungAh-Yoo99">
        <b>유승아</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/doyi0107">
        <b>이도이</b>
      </a>
    </td>
     <td align="center">
      <a href="https://github.com/dpdms529">
        <b>조예은</b>
      </a>
    </td>
  </tr>
</table>

<br>

## ⚙️ 프로그램 실행하기
### DB 설정
1. <code>sql/DDL.sql</code> 실행으로 DB, Table 생성
2. <code>sql/data.sql</code> 실행으로 더미 데이터 생성
### 실행 파일 다운
<code>WeirdQuiz.jar</code> 파일 다운
### DB 연결을 위한 설정 파일 생성
<code>WeirdQuiz.jar</code>와 같은 경로에 <code>jdbc.properties</code> 파일 생성 후 아래의 정보 입력<br>
<code>{ }</code>에 본인의 데이터베이스 정보 입력
```
USER_NAME={데이터베이스 Username}
PASSWORD={비밀번호}
DB_URL=jdbc:mysql://localhost:3306/
DATABASE=weird_quiz
```
### 실행
<code>WeirdQuiz.jar</code> 파일 경로에서 cmd 실행 후, 다음 명령어 실행
```
java -jar WeirdQuiz.jar jdbc.properties
```

<br>

## 💻 실행 예시
