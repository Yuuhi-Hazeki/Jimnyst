<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jimnyst</title>
</head>
<body>
<h1>カスタム一覧</h1>
		<c:forEach var="data" items="${dataList}">
    <div>
   		<hr>
        <c:choose>
            <c:when test="${not empty data.imgPass}">
                <img src="${data.imgPass}" alt="customImage">
            </c:when>
            <c:otherwise>
                Not Image forund...
            </c:otherwise>
        </c:choose>
    </div>

    <div><c:out value="${data.title}" /></div>
    <div>---Suspension System---</div>
    <div><c:out value="${data.customSus}" /></div>
    <div>---Body---</div>
    <div><c:out value="${data.customBody}" /></div>
    <div>---Engine System---</div>
    <div><c:out value="${data.customEngine}" /></div>
</c:forEach>
<a href="main">TOPへ</a>
</body>
</html>