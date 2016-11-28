<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 11/28/16
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <body>

    <nav class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">StaShit</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Settings</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/stashit/logout">Logout ${username}</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>

    <h1>Welcome to StaShit</h1>
    <h3>${addUserMessage}, Welcome ${username}!</h3>
    <div class="row marketing">

        <div class="col-lg-6">
            <h4>Storage Locations Near You</h4>
            <div id="map" style="width:100%;height:300px"></div>
            <p>Put your the extra storage space in your garage, attic, or basement to work!</p>

            <script>
                function myMap() {
                    var myCenter = new google.maps.LatLng(43.0731,-89.4012);
                    var mapCanvas = document.getElementById("map");
                    var mapOptions = {center: myCenter, zoom: 5};
                    var map = new google.maps.Map(mapCanvas, mapOptions);
                    var marker = new google.maps.Marker({position:myCenter});
                    marker.setMap(map);

                    var infowindow = new google.maps.InfoWindow({
                        content: "Store Things Here!"
                    });

                    infowindow.open(map,marker);
                }
            </script>

            <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

        </div>

        <div class="col-lg-4">

            <div class="column-overlay"><h4>Search for Storage</h4></div>
            bs3
            <div class="brickfolio">
                <div class="bf-item"> <img data-src="1.jpg">
                    <h4>Title 1</h4>
                    <p>Description 1</p>
                </div>

                <div class="bf-item"> <img data-src="2.jpg">
                    <h4>Title 2</h4>
                    <p>Description 2</p>
                </div>


            </div>

        </div>

        <div class="col-lg-4">

            <div class="column-overlay"><h4>Your Storage Spaces</h4></div>
            <div class="brickfolio">
                <div class="bf-item"> <img data-src="1.jpg">
                    <h4>Title 1</h4>
                    <p>Description 1</p>
                </div>

                <div class="bf-item"> <img data-src="2.jpg">
                    <h4>Title 2</h4>
                    <p>Description 2</p>
                </div>

                <div class="bf-item"> <img data-src="3.jpg">
                    <h4>Title 3</h4>
                    <p>Description 3</p>
                </div>


            </div>

        </div>

    </div>

    </body>
</div>
