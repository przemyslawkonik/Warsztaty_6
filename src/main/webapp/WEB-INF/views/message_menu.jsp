<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="jspf/fragment/header.jspf" %>
 <%@ include file="jspf/fragment/main_menu.jspf" %>
 <a href="${pageContext.request.contextPath}/messages/received/${id}">Received</a>
 <a href="${pageContext.request.contextPath}/messages/sended/${id}">Send</a>
 <%@ include file="jspf/fragment/footer.jspf" %>
</body>
</html>