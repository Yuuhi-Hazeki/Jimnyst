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
	<h2>Custom List</h2>
		<c:forEach var="data" items="${dataList}">
    <div>
   		<hr>
        <c:choose>
            <c:when test="${not empty data.imgPass}">
                <img src="${data.imgPass}" alt="customImage" width="30%" height="30%">
            </c:when>
            <c:otherwise>
                No Image
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
    <br>
    <form action="CustomListEditController" method="Get" style="text-align:right"> 
    	<input type="hidden" name="edtId" value="${data.id}" style="text-align:right">
    	<input id="edt_btn" type="submit" value="カスタム車両の編集" style="text-align:right">
   	</form>
   	<br>
    <form action="CustomListController" method="post" style="text-align:right"> 
    	<input type="hidden" name="delId" value="${data.id}" style="text-align:right">
    	<input id="del_btn" type="submit" value="カスタム車両の削除" style="text-align:right">
   	</form>
   	
   	<c:forEach var="cmtdata" items="${comtList}">
   	 <c:choose>
            <c:when test="${not empty cmtdata.coment}">
               <c:out value="${cmtdata.coment}"/>
            </c:when>
            <c:otherwise>
                コメントはありません。
            </c:otherwise>
        </c:choose>
   	</c:forEach>
   	<form action="ListComentContoroller" method="post">
   	<input type="hidden" name="comentid" value="${data.id}">
   	<textarea rows="2%" cols="50%" name="coment"></textarea>
   	<input type="submit" value="コメント">
   	</form>
	</c:forEach>
<a href="main">TOPへ</a>

<!--edit_area-->
<script>del_btn.onclick=function(){return confirm("カスタム車両を削除してもよろしいですか？")};</script>
<!--/edit_area-->
</body>
</html>