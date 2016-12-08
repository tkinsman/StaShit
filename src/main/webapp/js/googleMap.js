/**
 * Created by toddkinsman on 12/3/16.
 */

// Step 1: When loading the user home page, get the username assign to variable
//--You'll have to make sure to either get it from the server session OR assign the username as a
//  value to a page element val attribute

// Step 2: in the js file, you'll get the element by id of the user name and
//      and set that value in the ajax call url request parameters that is sent to
//      a deidicated js servlet to get the correct json response.

// Step 3: in a dedicated js servlet get an array of latLongs that can be looped through
// when the mapinti callback is triggered.


$(document).ready(function() {
    var geoJsonLocations;
    var map;

    function initMap() {

        getUserLocationLatLong();
    }


    var username = $("#userNameForMap").val();

    console.log("The username is: " + username);


    console.log("This is the googleMap.js file");


    $.get("http://localhost:8080/stashit/UserService/userlocations/" + username, function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        console.log("The response json: " + responseJson);
        geoJsonLocations = responseJson;

    });

    function createUserSpecificMap(lat, long) {
        var currentPosition = {lat: lat, lng: long};
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 5,
            center: new google.maps.LatLng(lat,long),
            mapTypeId: 'terrain'
        });
        map.data.loadGeoJson('googleMap.js');

        var marker = new google.maps.Marker({
            position: currentPosition,
            map: map
        });

    }

    function createUserSpecificMap(lat, long) {
        var currentPosition = {lat: lat, lng: long};
        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 5,
            center: new google.maps.LatLng(lat,long),
            mapTypeId: 'terrain'
        });
        map.data.loadGeoJson('googleMap.js');

        var marker = new google.maps.Marker({
            position: currentPosition,
            map: map
        });

        // Create a <script> tag and set the USGS URL as the source.
        var script = document.createElement('script');
        // This example uses a local copy of the GeoJSON stored at
        // http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.geojsonp


        // THIS THIS THIS! Try to replace. you'll replace thise with the location of
        // the json that you generate
        // script.src = 'https://developers.google.com/maps/documentation/javascript/examples/json/earthquake_GeoJSONP.js';

        // script.src = "js/googleMap.js";
        //
        // document.getElementsByTagName('head')[0].appendChild(script);

    }


});