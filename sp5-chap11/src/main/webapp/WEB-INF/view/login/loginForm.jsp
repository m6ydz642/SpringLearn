<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ������</title>
</head>
<body>
	<form:form modelAttribute="login">
		<p>
			<label for="loginType">�α��� Ÿ��</label>
			<form:select path="loginType" items="${loginTypes}"> </form:select>
		</p>
	</form:form>
</body>
</html>