<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>

<%   //비즈니스 로직을 처리하는 부분

    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    //get 방식의 쿼리 스트림에서 꺼내든 post방식의 form 이든 request.getParameter 로 보낼 수 있다.
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

%>
<%--퍼센트 꺽세 표시가 없는 곳에서는 그냥 전부다 http response에 담기는 것이다.--%>

<%--순수하게 뷰를 렌더링 하는 부분--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--   <%= %> 이태그는 자바코드를 출력할수있는 태그이다. --%>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>

</ul>
<a href="/index.html">메인</a>
</body>
</html>
