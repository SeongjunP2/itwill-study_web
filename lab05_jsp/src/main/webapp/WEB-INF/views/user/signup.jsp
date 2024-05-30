<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Lab 05</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous" />
</head>
<body>
    <!-- TODO: 회원 가입 양식(form) -->
    <div class="container-fluid">
        <c:set var="pageTitle" value="Sign Up" scope="page" />
        <%@ include file="../fragments/header.jspf" %>
        
        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>회원가입</h2>
                </div>
                <div class="card-body">
                    <form method="post" action="${signUpPage}">
                        <div class="mt-2"> <!-- 값을 입력하는 텍스트 입력칸 사이에 공백(margin) 부여하는 부트스트랩 클래스 -->
                            <input class="form-control" type="text" name="userid" placeholder="아이디" required autofocus />
                        </div>
                        <div class="mt-2">
                            <input class="form-control" type="password" name="password" placeholder="비밀번호" required />
                        </div>
                        <div class="mt-2">
                            <input class="form-control" type="text" name="email" placeholder="이메일" required />
                        </div>
                        <div class="mt-2">
                            <input class="form-control btn btn-outline-success" type="submit" value="회원가입" />
                        </div>
                    </form>
                </div>
            </div>
        </main>
        
        <!-- <form>
            <input type="text" placeholder="제목"><br>
            <input type="text" placeholder="내용"><br>
            <input type="text" placeholder="작성자"><br>
            <button>저장</button>
        </form> -->
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>