<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">StaShit</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="/stashit/logout">Logout ${username}</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">

    <div class="starter-template">
        <h1>Welcome To StaShit, ${username}!</h1>
        <p class="lead">Stash your stuff easy and locally or make some money renting your extra space.</p>
    </div>

    <div class="col-lg-12">
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
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12">
                <h1 class="page-header">Find Locations</h1>
            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Basement</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Attic</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Garage</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Basement</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Attic</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Garage</p>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12">
                <h1 class="page-header">Your Locs</h1>
            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Basement</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Attic</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Garage</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Basement</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Attic</p>
                </div>

                <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                    <a class="thumbnail" href="#">
                        <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                    </a>
                    <p>Garage</p>
                </div>

            </div>

        </div>
    </div>
</div>


