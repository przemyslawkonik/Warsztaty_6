<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="../jspf/fragment/header.jspf" %>
 <%@ include file="../jspf/fragment/main_menu.jspf" %>
 <p>User profile: ${user.username}</p>
 <p>
  <c:if test="${sessionScope.user!=null}">
   <c:choose>
    <c:when test="${sessionScope.user.id==user.id}">
     <a href="${pageContext.request.contextPath}/messages/${user.id}">Messages</a>
    </c:when>
    <c:otherwise>
     <a href="${pageContext.request.contextPath}/messages/send/${user.id}">Send message</a>
    </c:otherwise>
   </c:choose>
  </c:if>
 </p>
 <p align="center">Tweet's history</p>
 <%@ include file="../jspf/tweet/tweet_list_with_comments.jspf" %> 
 <%@ include file="../jspf/fragment/footer.jspf" %>
</body>
</html>