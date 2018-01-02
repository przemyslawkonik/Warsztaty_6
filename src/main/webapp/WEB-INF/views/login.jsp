<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="jspf/fragment/header.jspf" %>
 <%@ include file="jspf/fragment/main_menu.jspf" %> 
 <p>${errorMsg}</p>
 <form:form method="post" modelAttribute="loginData">
  <p><form:input path="email" placeholder="email"/></p>
  <p><form:input path="password" type="password" placeholder="password"/></p>
  <p><input type="submit" value="Log in"/></p>
 </form:form> 
 <%@ include file="jspf/fragment/footer.jspf" %>
</body>
</html>