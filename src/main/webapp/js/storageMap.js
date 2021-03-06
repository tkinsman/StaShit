/**
 * Created by toddkinsman on 11/28/16.
 */

function initMap() {

    // getUserLocationLatLong();
    loadmaps();
}

var map;
var userMarkers;



var username = $("#userNameForMap").val();
stoLocs = $("#storageMapLocations").val();

console.log("Sto locs: " + stoLocs);

var username = $("#userNameForMap").val();
stoLocs = $("#storageMapLocations").val();

function loadmaps() {


    $.ajax({
        url: "http://localhost:8080/stashit/UserService/userMaplocations/" + username,
        type: "GET",
    })
        .done(function (data, textStatus, jqXHR) {
            console.log("HTTP Request Succeeded: " + jqXHR.status);
            console.log(data);
            userMarkers = data;
            getUserLocationLatLong();



        })
        .fail(function (jqXHR, textStatus, errorThrown) {
            console.log("HTTP Request Failed");
        })
        .always(function () {

        });

}

function createUserSpecificMap(lat, long) {
    var currentPosition = {lat: lat, lng: long};

    console.log("The specid position: " + currentPosition);

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


function addLocationMarkers(results) {
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

function locations_callback(response) {
    map.data.addGeoJson(response);
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

