<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="member.register"/></title>
				<!-- message������ label.properties�� member.register�� ȸ�������̶�� ���
				�Ǿ� �־ �� ���� �ʾƵ� �� -->
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<p>��� ����</p>
	<form action="step2" method="post">
		<label>
			<input type="checkbox" name="agree" value="true">
			<spring:message code="term.agree"/>
		</label>
			<input type="submit" value="<spring:message code="next.btn"/>"/>	
	</form>
</body>
</html>