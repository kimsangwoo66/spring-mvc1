<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl을 사용하려면 필수로 선언해줘야 한다.--%>
<%--jstl은 jsp가 제공하는 특별한 태그들을 사용할 수있게 해준다. ex) 루프--%>
<%--즉 view에 특화--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
<%--members는 MvcMemberListServlet 에서 request.setAttribute() 의 members 에서 가져온다.--%>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
