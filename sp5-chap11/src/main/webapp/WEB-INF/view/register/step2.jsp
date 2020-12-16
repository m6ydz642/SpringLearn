<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--  form이라는 태그 이름으로 지정해서 사용함 
스프링 MVC에서 제공하는 커스텀 태그임 -->
<!DOCTYPE html>
<html>
<head>
    <title>회원정보 입력</title>
</head>
<body>
    <form:form action="step3" modelAttribute="registerRequest">
    <p>
        <label>이메일:<br>
<%--         <input type="text" name="email" id="email" value="${registerRequest.email}"> --%>
        	<form:input path="email"/>
        </label>									<!-- 
         						value="${registerRequest.email}"
         						는 정보를 잘못 입력 했을경우를 대비해 다시	
        						뒤로 돌아갈때  불러온 값 로드, 정보가 없으면 빈값으로 대체
        						-->
    </p>
    <p>
        <label>이름:<br>
        <%-- <input type="text" name="name" id="name" value="${registerRequest.name}"> --%>
		 <form:input path="name"/>
		 
        </label>
    </p>
    <p>
        <label>비밀번호:<br>
        <!-- <input type="password" name="password" id="password"> -->
        	<form:password path="password"/>
        </label>
    </p>
    <p>
        <label>비밀번호 확인:<br>
       <!--  <input type="password" name="confirmPassword" id="confirmPassword"> -->
       	<form:password path="confirmPassword"/> 
        </label>
    </p>
    <input type="submit" value="가입 완료">
    </form:form>

<%--
    <form action="step3" method="post">
    <p>
        <label>이메일:<br>
        <input type="text" name="email" id="email" value="${registerRequest.email}">
        </label>
    </p>
    <p>
        <label>이름:<br>
        <input type="text" name="name" id="name" value="${registerRequest.name}">
        </label>
    </p>
    <p>
        <label>비밀번호:<br>
        <input type="password" name="password" id="password">
        </label>
    </p>
    <p>
        <label>비밀번호 확인:<br>
        <input type="password" name="confirmPassword" id="confirmPassword">
        </label>
    </p>
    <input type="submit" value="가입 완료">
    </form>
 --%>
</body>
</html>