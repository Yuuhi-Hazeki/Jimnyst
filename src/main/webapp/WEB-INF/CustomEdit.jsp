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
	<h1>Jimnyst</h1>
	<h2>Edit Page</h2>
	<hr>
	<form action="CustomListEditController" method="post">                                              
	<input type="hidden" name="id" value="${data.id}">
		カスタム名/型 <br>
		<textarea rows="2" cols="40" name="title" ><c:out value="${data.title}" escapeXml="false"/></textarea>
		<p>足回り、サスペンション系</p>
		<textarea rows="10" cols="80" name="custom_sus"><c:out value="${data.customSus}" escapeXml="false"/></textarea>
		<p>外装系</p>
		<textarea rows="10" cols="80" name="custom_body" ><c:out value="${data.customBody}" escapeXml="false"/></textarea>
		<p>エンジン、スープアップ系</p>
		<textarea rows="10" cols="80" name="custom_engine" ><c:out value="${data.customEngine}" escapeXml="false"/></textarea>
		<br> <input type="submit" value="内容の変更">
	</form>
	<br>
<a href="CustomListController">Listへ</a>
</body>
</html>