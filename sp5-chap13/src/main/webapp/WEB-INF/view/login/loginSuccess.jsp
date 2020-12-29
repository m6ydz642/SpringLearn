<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<p>
		<spring:message code="login.done"/>
	</p>

<p>
	<a href="<c:url value='/main'/> ">
		[<spring:message code="go.main"/>]
	</a>
</p>
</body>
</html>