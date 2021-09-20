<%@ page contentType="text/html;charset=UTF-8" language="java" %> <html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--WEB-INF/ 있는 자원들은 외부에서 호출해도 그냥 호출되지 않는다.--%>
<%--항상 컨트롤러(서블릿)을 거쳐서 내부에서 포워드를 해야 호출된다.--%>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
