<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/22/16
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<c:set var="pageTitle" scope="request" value="${param.title}"/>
<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation" class="active"><a href="index.jsp">Home</a></li>
                <li role="presentation"><a href="about.jsp">About</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">Welcome to StaShit</h3>
    </div>

    <div class="jumbotron">
        <h1>StaShit</h1>
        <p class="lead">Helping you with your storage needs.</p>
        <p><a class="btn btn-lg btn-success" href="signUp.jsp" role="button">Sign up today</a></p>
        <p><a href="loginForm.jsp">or login here</a></p>
    </div>
    <img src="images/StaShit_med.png" class="img-responsive" alt="Image">
    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Make Money</h4>
            <p>Put your the extra storage space in your garage, attic, or basement to work!</p>

        </div>

        <div class="col-lg-6">

            <h4>Need Storage?</h4>
            <p>Find storage options for a reasonable cost.</p>
            <p><a href="allusers">User Test Page</a> </p>

        </div>


    </div>



    <%@include file="footer.jsp"%>

</div> <!-- /container -->


</body>
</html>
