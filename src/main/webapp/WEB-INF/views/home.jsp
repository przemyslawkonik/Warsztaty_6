<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
 <c:if test="${sessionScope.user!=null}">
  <form:form method="post" modelAttribute="tweet">
  <p><form:textarea path="text" placeholder="insert text..."/></p><form:errors path="text"></form:errors>
  <p><input type="submit" value="Add tweet"/></p>
  </form:form>
 </c:if> 
 <%@ include file="jspf/tweetList.jspf" %>
 <%@ include file="jspf/footer.jspf" %>
</body>
</html>