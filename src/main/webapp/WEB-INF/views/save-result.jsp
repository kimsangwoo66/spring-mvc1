<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <%--   <%= %> 이태그는 자바코드를 출력할수있는 태그이다. --%>
<%--${} 는 프로버티 접근법--%>
        <li>id=${member.id}</li>
        <li>username=${member.username}</li>
<%--        <li>id=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>
        <li>age=${member.age}</li>

<%--    <li>username=<%=member.getUsername()%></li>--%>
<%--    <li>age=<%=member.getAge()%></li>--%>

</ul>
<a href="/index.html">메인</a>
</body>
</html>
