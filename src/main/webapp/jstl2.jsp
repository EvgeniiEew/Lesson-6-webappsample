<%@page import="by.grodno.pvt.site.webappsample.service.User" %>
<%@page import="by.grodno.pvt.site.webappsample.JstlServlet4Edit" %>

<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
    <%--   <c:set var="${number}" scope="session"/>--%>

    <%--   <c:forEach var="${number}" begin="${number}" end="${number + 1}">--%>
    <%@ include file="fragments/header.jsp" %>
    <c:set var="currUser" scope="request"
           value="${requestScope.user}"/>

    <c:if test="${currUser == null}">
        <form action="user" method="POST">
            First Name: <input type="text" name="firstName">
            <br/>
            Last Name: <input type="text" name="lastName"/>
            <br/>
            BirthDate: <input type="text" name="birthdate"/>
            <br/>
            <input type="radio" id="createMale" name="male" value="true">
            <label for="createMale">Male</label><br>
            <input type="radio" id="createFemale" name="male" value="false">
            <label for="createFemale">Female</label><br>

            <input type="submit" value="Submit"/>
        </form>
    </c:if>

    <c:if test="${currUser != null}">
        <form action="edit" method="POST">
            First Name: <input type="text" name="firstName" value="${currUser.firstName}">
            <br/>
            Last Name: <input type="text" name="lastName" value="${currUser.lastName}"/>
            <br/>
            BirthDate: <input type="text" name="birthdate" value=" <%
                            Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
                            out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                        %>"/>
            <br/>
            <label for="editFemale">Male</label>
            <input type="radio" id="editMale" name="male" value="true" ${currUser.male ? 'checked' :''}>
            <br>
            <label for="editFemale">Female</label>
            <input type="radio" id="editFemale" name="male" value="false" ${currUser.male ? '' :'checked'}>
            <br>
            <input type="submit" value="Submit"/>
        </form>
    </c:if>

    <%--   </c:forEach>--%>
    <!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
</body>
</html>

