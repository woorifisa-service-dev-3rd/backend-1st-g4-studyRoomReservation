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
### 회원가입 및 로그인
<p>
  <ul>
    <li>회원가입 기능</li>
    <li>이미 존재하는 아이디일 경우 다시 입력 요청하는 예외처리</li>
  </ul>
  <img src="https://github.com/user-attachments/assets/95ebeeec-df31-402f-8b48-19b953bdb620" alt="회원가입" width="600" height="400"/>
</p>
<p>
  <ul>
    <li>로그인 기능</li>
    <li>아이디 및 비밀번호 입력 오류 시 다시 입력 요청하는 예외처리</li>
  </ul>
  <img src="https://github.com/user-attachments/assets/8b9c8382-480b-44c2-9647-e11ef229b44d" alt="로그인" width="600" height="400"/>
</p>

### 게임 방법 및 게임 시작
<p>
  <ul>
    <li>게임 방법 확인</li>
    <li>게임 시작 → 10문제를 모두 맞춰 게임에서 성공하거나 사용자가 그만하길 원할 때까지 계속 게임 진행</li>
  </ul>
  <img src="https://github.com/user-attachments/assets/5edf4b81-c6a4-475f-99ec-a81768c0dda4" alt="게임 방법 및 게임 시작" width="600" height="400"/>
</p>

### 기록 조회
<p>
  <ul>
    <li>게임 시도 횟수에 따른 성공률 조회</li>
    <li>문제 푼 횟수에 따른 정답률 조회</li>
  </ul>
  <img src="https://github.com/user-attachments/assets/a2865650-1587-437b-a08d-24124f50a13b" alt="기록 조회" width="600" height="400"/>
</p>

### 로그아웃 및 종료
<p>
  <ul>
    <li>로그아웃하여 다른 아이디로 로그인 가능</li>
    <li>프로그램 종료</li>
  </ul>
  <img src="https://github.com/user-attachments/assets/87bde563-0e87-4aa9-b2f0-cbff601cee9e" alt="로그아웃 및 종료" width="600" height="400"/>
</p>
