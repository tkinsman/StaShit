<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 12/2/16
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">

<% pageContext.setAttribute("title", "Location Details"); %>

    <%@include file="head.jsp"%>

    <div class="container">

        <%@include file="navBar.jsp"%>

        <body>

            <%@include file="locationView_body.jsp"%>

        </body>

        <%@include file="footer.jsp"%>

    </div>

</html>