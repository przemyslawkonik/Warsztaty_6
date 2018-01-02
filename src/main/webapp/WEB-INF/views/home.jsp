<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="jspf/fragment/header.jspf" %>
 <%@ include file="jspf/fragment/main_menu.jspf" %>
 <%@ include file="jspf/tweet/add_tweet.jspf" %>
 <c:forEach var="tweet" items="${tweets}"><hr>
  <%@ include file="jspf/tweet/tweet.jspf" %>
  <div align="center">
   <%@ include file="jspf/comment/comment_list.jspf" %>
   <%@ include file="jspf/comment/add_comment.jspf" %>
  </div>
 </c:forEach><hr>
 <%@ include file="jspf/fragment/footer.jspf" %>
</body>
</html>