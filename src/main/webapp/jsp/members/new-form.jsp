<%--이렇게 jsp를 만들면 내부에서 서블릿으로 다 변경된다.--%>
<%--jsp는 꼭 이태그를 선언해 줘야한다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--form에서는 name의 value 값이 action 경로로 들어간다.--%>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age:      <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
