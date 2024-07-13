<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jimnyst</title>
</head>
<body>
車両画像
  <c:if test="${not empty imagePaths}">
        <ul>
            <c:forEach var="imagePath" items="${imagePaths}">
                <li><img src="${imagePath}" alt="Uploaded Image" style="max-width:200px;"/></li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty imagePaths}">
        <p>No images found.</p>
    </c:if>

</body>
</html>