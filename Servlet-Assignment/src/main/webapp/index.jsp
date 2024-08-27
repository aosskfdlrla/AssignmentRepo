<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>까짓거 대충 로그인 하쇼</h1>
<form action="/login" method="post">
    <label>ID : </label><input type="text" name="id">
    <br>
    <label>PW : </label><input type="number" name="pw">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>