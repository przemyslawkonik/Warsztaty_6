<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="jspf/head_config.jspf" %>
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="jspf/header.jspf" %>
 <%@ include file="jspf/main_menu.jspf" %>
 <c:forEach var="m" items="${messages}">
  <p>
  From  
  <a href="${pageContext.request.contextPath}/users/${m.sender.id}">${m.sender.username}</a>
  To 
  <a href="${pageContext.request.contextPath}/users/${m.receiver.id}">${m.receiver.username}</a>
  send on ${m.created}:
 </p>
 <p>${m.text}</p><hr>
 </c:forEach>
 <%@ include file="jspf/footer.jspf" %>
</body>
</html>