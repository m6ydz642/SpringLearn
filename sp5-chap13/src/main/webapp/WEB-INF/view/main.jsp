<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����ȭ��</title>
</head>
<body>
<c:if test="${empty authInfo }">
	<p>ȯ���մϴ�</p>
		<p> <a href="<c:url value='/register/step1'/> ">ȸ�������ϱ�</a>
		<p> <a href="<c:url value='/login'/> ">�α���</a>
		</p>
</c:if>

<c:if test="${!empty authInfo }">
<p>${authInfo.name }�� ȯ���մϴ�</p>
<p>
	<a href="<c:url value="/edit/changePassword"/>">��й�ȣ ����</a>
	<a href="<c:url value="/logout"/> ">�α׾ƿ�</a>
</p>
</c:if>
		
</body>
</html>