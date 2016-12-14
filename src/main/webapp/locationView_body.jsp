<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 12/2/16
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="container">

    <div class="starter-template">
        <h1>Location Details</h1>
    </div>

    <div class="col-lg-12">

        <h2 class="page-header">${storageLoc.stoLocName}</h2>

        <%--Div to append the google map--%>
        <div id="map" style="width:100%;height:300px"></div>
        <input type="hidden" id="lat" value="${lat}">
        <input type="hidden" id="long" value="${longit}">

    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12" style="padding: 2%;">

                <h2 class="page-header">Location Details</h2>

                <p class="navbar-text pull-right">
                    <a href="/stashit/editLocation" class="navbar-link">Edit Location</a>
                </p>

            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">

                <%@include file="locationViewDetail_form.jsp"%>

            </div>
        </div>


    </div>
</div>