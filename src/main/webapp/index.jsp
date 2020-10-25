<html>
<body>
<div>
    <jsp:useBean id="obj"
                 class="by.grodno.pvt.site.webappsample.OurTestJavaBean">
        <jsp:setProperty name="obj" property="value" value="VALUE"/>
    </jsp:useBean>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="fragments/header.jsp" %>

    <a href="http://localhost:8080/webappsample/hello">Bla bla</a>
    <br/>
    <a href="http://localhost:8080/webappsample/hello2">Bla bla2</a>
    <br/>
    <%=new java.util.Date()%>
    <br/>
    <%="Request data:" + request.getQueryString()%>
    <br/>
    <%
        String queryData = request.getQueryString();
        out.println("Request data:" + queryData);
    %>
    <br/>
    <br/>
    <br/>

    <jsp:getProperty property="value" name="obj"/>

    <br/>
    <br/>


    <c:out value="${requestScope.data.value}"/>

    <c:set var="salary" scope="session" value="${100 * sessionScope.counter}"/>

    <c:out value="${sessionScope.salary}"/>
</div>


</body>
</html>
