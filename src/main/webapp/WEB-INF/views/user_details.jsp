<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="jspf/head_config.jspf" %>
<title>Warsztaty 6</title>
</head>
<body>
 <%@ include file="jspf/header.jspf" %>
 <%@ include file="jspf/main_menu.jspf" %>
 <p>User: ${user.username}</p> 
 <%@ include file="jspf/tweet_list.jspf" %> 
 <%@ include file="jspf/footer.jspf" %>
</body>
</html>