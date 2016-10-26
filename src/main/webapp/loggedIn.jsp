    <%@include file="head.jsp"%>
    <!DOCTYPE html>
    <html lang="en">
    <header>
        <div class="page-header">
            <img src="images/StaShit_med.png" alt="squirrel" class="img-responsive center-block" />
        </div>
    </header>
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
        		<a class="navbar-brand" href="#">Title</a>
        	</div>

        	<!-- Collect the nav links, forms, and other content for toggling -->
        	<div class="collapse navbar-collapse navbar-ex1-collapse">
        		<ul class="nav navbar-nav">
        			<li class="active"><a href="#">Link</a></li>
        			<li><a href="#">Link</a></li>
        		</ul>
        		<form class="navbar-form navbar-left" role="search">
        			<div class="form-group">
        				<input type="text" class="form-control" placeholder="Search">
        			</div>
        			<button type="submit" class="btn btn-default">Submit</button>
        		</form>
        		<ul class="nav navbar-nav navbar-right">
        			<li><a href="#">Link</a></li>
        			<li class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
        				<ul class="dropdown-menu">
        					<li><a href="#">Action</a></li>
        					<li><a href="#">Another action</a></li>
        					<li><a href="#">Something else here</a></li>
        					<li><a href="#">Separated link</a></li>
        				</ul>
        			</li>
        		</ul>
        	</div><!-- /.navbar-collapse -->
        </nav>
            <h1>Welcome to StaShit</h1>
            <div class="row marketing">

                <div class="col-lg-4">
                    <h4>Map of Areas</h4>
                    <div id="map" style="width:100%;height:300px"></div>
                    <p>Put your the extra storage space in your garage, attic, or basement to work!</p>

                    <script>
                        function myMap() {
                            var myCenter = new google.maps.LatLng(51.508742,-0.120850);
                            var mapCanvas = document.getElementById("map");
                            var mapOptions = {center: myCenter, zoom: 5};
                            var map = new google.maps.Map(mapCanvas, mapOptions);
                            var marker = new google.maps.Marker({position:myCenter});
                            marker.setMap(map);

                            var infowindow = new google.maps.InfoWindow({
                                content: "Hello World!"
                            });
                            infowindow.open(map,marker);
                        }
                    </script>

                    <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

                </div>

                <div class="col-lg-4">

                    <h4>Need Storage?</h4>
                    <p>Find storage options for a reasonable cost.</p>

                </div>

                <div class="col-lg-4">

                    <h4>Need Storage?</h4>
                    <p>Find storage options for a reasonable cost.</p>

                </div>

            </div>
            <p><a href="index.jsp">Home</a></p>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script src="js/bootstrap.min.js"></script>
        </body>
    </html>