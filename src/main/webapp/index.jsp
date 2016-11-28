<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/22/16
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.

  This is the landing page for the StaShit Applicaiton. One can login or signup for a new account from this page.
--%>

<%--Might switch to this style of template system--%>
<%--<c:set var="pageTitle" scope="request" value="${param.title}"/>--%>

<!DOCTYPE html>

<html lang="en">

    <% pageContext.setAttribute("title", "StaShit Home"); %>
    <%@include file="head.jsp"%>

    <div class="container">

        <body>

            <%@include file="index_body.jsp"%>

        </body>

        <%@include file="footer.jsp"%>

    </div>

</html>
