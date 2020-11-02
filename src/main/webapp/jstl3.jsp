<%@page import="by.grodno.pvt.site.webappsample.service.User" %>
<%@page import="by.grodno.pvt.site.webappsample.service.Department" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ include file="fragments/header.jsp" %>
    <br/>
    <c:if test="${requestScope.users != null}">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Birthdate</th>
            <th scope="col">Sex</th>
            <th scope="col">Salary</th>
            <th scope="col">Deptnumber</th>
            <th scope="col">Dept</th>
        </tr>
        </thead>
        <c:forEach var="i" begin="0" end="${fn:length(requestScope.users)-1}">
            <c:set var="currUser" scope="request"
                   value="${requestScope.users[i]}"/>

            <tr>
            <td scope="row">${requestScope.currUser.id}</td>
            <td>${requestScope.currUser.firstName}</td>
            <td>${requestScope.currUser.lastName}</td>
            <td>
                <%
                    Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
                    if (userBirth != null) {
                        out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                    }
                %>
            </td>
            <td><c:choose>
                <c:when test="${requestScope.currUser.male}">Male</c:when>
                <c:otherwise>Female</c:otherwise>
            </c:choose></td>

            <td>${requestScope.currUser.salary}</td>
                <td scope="row">${requestScope.departments[0].depNumber}</td>
                <td>${requestScope.departments[0].nameDept}</td>

<%--                <c:forEach var="i" begin="0" end="${fn:length(requestScope.departments)-1}"> <c:set var="currDepartament"--%>
<%--                                                                                                scope="request"--%>
<%--                                                                                                value="${requestScope.departments[i]}"/>--%></td>
                 </c:forEach>
            </tr>
<%--        </c:forEach>--%>
    </table>
    </c:if>

