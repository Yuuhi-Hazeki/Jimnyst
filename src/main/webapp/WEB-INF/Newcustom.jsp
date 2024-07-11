<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jimnyst</title>
</head>
<body>
	<h1>Jimnyst</h1>
	車両画像選択
	<br>
	<form action="/upload"method="post" enctype="multipart/form-data">
		<p><input type="file" accept="image/*" name="custom_img"></p>
		カスタム名
		<br>
		<input type="text" name="title">
		<p>足回り、サスペンション系</p>
		<textarea rows="5" cols="80" name="custom_sus"></textarea>
		<p> 外装系</p>
		<textarea rows="5" cols="80" name="custom_body"></textarea>
		<p>エンジン、スープアップ系</p>
		<textarea rows="5" cols="80" name="custom_engine"></textarea>
		<br>
		<button type="submit">保存</button>
		<br>
	</form>
	<br>
	<a href="Main">TOPへ</a>
</body>
</html>