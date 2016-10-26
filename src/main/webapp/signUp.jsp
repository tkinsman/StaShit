<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 9/29/16
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SignUp</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="stylesheets/signup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>


<div class="container">

    <div class="starter-template">
        <h1>Sign Up</h1>
        <p class="lead">DO IT.<br> Squirrel wants it.</p>
    </div>

    <form action="" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <legend>Register</legend>
        </div>
        <div class="col-sm-12">
            <div class="row">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" placeholder="Enter Username Here.." class="form-control">
                </div>
                <div class="col-sm-6 form-group">
                    <label>First Name</label>
                    <input type="text" placeholder="Enter First Name Here.." class="form-control">
                </div>
                <div class="col-sm-6 form-group">
                    <label>Last Name</label>
                    <input type="text" placeholder="Enter Last Name Here.." class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>Address</label>
                <textarea placeholder="Enter Address Here.." rows="3" class="form-control"></textarea>
            </div>
            <div class="row">
                <div class="col-sm-4 form-group">
                    <label>City</label>
                    <input type="text" placeholder="Enter City Name Here.." class="form-control">
                </div>
                <div class="col-sm-4 form-group">
                    <label>State</label>
                    <input type="text" placeholder="Enter State Name Here.." class="form-control">
                </div>
                <div class="col-sm-4 form-group">
                    <label>Zip</label>
                    <input type="text" placeholder="Enter Zip Code Here.." class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" placeholder="Enter Phone Number Here.." class="form-control">
            </div>
            <div class="form-group">
                <label>Email Address</label>
                <input type="text" placeholder="Enter Email Address Here.." class="form-control">
            </div>
            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </form>

    <p><a href="index.jsp">GO HOME</a></p>


</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

