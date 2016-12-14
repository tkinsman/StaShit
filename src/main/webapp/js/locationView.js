/**
 * Created by toddkinsman on 11/28/16.
 */

function initMap() {
    loadmaps();
}

var map;
var userMarkers;


function loadmaps() {

    getUserLocationLatLong();

}




function createUserSpecificMap(lat, long) {

    var currentPosition = {lat: lat, lng: long};
    console.log("The specid position: " + currentPosition);
    var latit = $("#lat").val();
    var longti = $("#long").val();
    console.log("The value of loc cooreds: " + latit);
    console.log("The value of loc cooreds length: " + latit.length);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 5,
        center: new google.maps.LatLng(lat,long),
        mapTypeId: 'terrain'
    });

    var marker = new google.maps.Marker({
        position: currentPosition,
        map: map
    });

    addLocationMarkers(userMarkers);

}


function getUserLocationLatLong() {

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        console.log("Geolocation is not supported by this browser.");
    }

}

function showPosition(position) {

    console.log("Latitude: " + position.coords.latitude +
        " Longitude: " + position.coords.longitude);

    userLat = position.coords.latitude;
    userLong = position.coords.longitude;

    createUserSpecificMap(userLat, userLong);
}

// Loop through the results array and place a marker for each
// set of coordinates.
window.locations_callback = function(results) {

    console.log("you're in the list" + results);
    console.log("the length: " + results.features.length);

    for (var i = 0; i < results.features.length; i++) {
        var coords = results.features[i].geometry.coordinates;
        console.log("The coods: " + coords);
        var latLng = new google.maps.LatLng(coords[0],coords[1]);
        var lat = coords[0];
        var long = coords[1];

        console.log("The latlng: " + latLng);
        var currentPosition = {lat: lat, lng: long};
        var marker = new google.maps.Marker({
            position: currentPosition,
            map: map,
            title: 'Hello World!'
        });

        marker.setMap(map);
    }
}



function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            console.log("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            console.log("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            console.log("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            console.log("An unknown error occurred.");
            break;
    }
}

