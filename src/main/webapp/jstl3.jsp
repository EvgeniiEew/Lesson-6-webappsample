<%@page import="by.grodno.pvt.site.webappsample.service.User" %>
<%@page import="by.grodno.pvt.site.webappsample.service.Department" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@ page import="by.grodno.pvt.site.webappsample.service.UserDep" %>
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
    <c:if test="${requestScope.userDeps != null}">

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">IdUser</th>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Salary</th>
            <th scope="col">Birthdate</th>
            <th scope="col">Sex</th>
            <th scope="col">Deptnumber</th>
            <th scope="col">IdDept</th>
            <th scope="col">NameDept</th>
        </tr>
        </thead>
        <c:forEach var="i" begin="0" end="${fn:length(requestScope.userDeps)-1}">
        <c:set var="currUserDept" scope="request"
               value="${requestScope.userDeps[i]}"/>

        <tr>
            <td scope="row">${requestScope.currUserDept.id}</td>
            <td>${requestScope.currUserDept.firstName}</td>
            <td>${requestScope.currUserDept.lastName}</td>
            <td>${requestScope.currUserDept.salary}</td>
            <td>
                <%
                    Date userBirth = ((UserDep) request.getAttribute("currUserDept")).getBirthdate();
                    if (userBirth != null) {
                        out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                    }
                %>
            </td>
            <td><c:choose>
                <c:when test="${requestScope.currUserDept.male}">Male</c:when>
                <c:otherwise>Female</c:otherwise>
            </c:choose></td>
            <td scope="row">${requestScope.currUserDept.depNumber}</td>
            <td>${requestScope.currUserDept.idDept}</td>
            <td>${requestScope.currUserDept.nameDept}</td>
            </c:forEach>
        </tr>
    </table>
    </c:if>

