<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/28/16
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%-- TODO add form here for logging in --%>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>