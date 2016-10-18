<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/24/16
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>Content Title Here</p>


<%@include file="head.jsp"%>
<html>

<%@include file="header.jsp"%>

<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <div>
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>

            </tr>
            <c:forEach var="user" items="${allusers}">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.userName}" /></td>
                    <td><c:out value="${user.password}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>



</body>

<%@include file="footer.jsp"%>

</html>