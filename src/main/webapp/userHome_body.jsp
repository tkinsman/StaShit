
<%@include file="navBar.jsp"%>

<div class="container">

    <div class="starter-template">
        <h1>Welcome To StaShit, ${username}!</h1>
        <p class="lead">Stash your stuff easy and locally or make some money renting your extra space.</p>
    </div>

    <div class="col-lg-12">

        <h2 class="page-header">Storage Locations Near You</h2>

        <%--Div to append the google map--%>
        <div id="map" style="width:100%;height:300px"></div>

        <input type="hidden" value="${username}" id="userNameForMap" />
        <input type="hidden" value="${storageMapLocations}" id="storageMapLocations" />

    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12" style="padding: 2%;">

                <h2 class="page-header">Your Locations</h2>

                <p class="navbar-text pull-right">
                    <a href="addLocation.jsp" class="navbar-link">Add New Location</a>
                </p>

            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">
                <c:forEach var="location" items="${storageLocations}" varStatus="loop">

                    <c:set value="${location}" var="location" scope="session" />

                    <div class="col-lg-3 col-md-4 col-xs-6 thumb">

                        <a class="thumbnail" href="/stashit/viewlocation?locationId=${location.storageLocId}">

                            <img class="img-responsive" src="images/homesil.jpeg" alt="house">

                        </a>

                        <p>${location.stoLocName}</p>
                        <p>${location.stoLocState}</p>
                    </div>

                </c:forEach>

            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12">
                <h2 class="page-header">Your Storage Spaces</h2>


                <p class="navbar-text pull-right">
                    <a href="/stashit/addspace" class="navbar-link">Add New Storage</a>
                </p>
            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">

                <c:forEach var="space" items="${storageSpaces}">

                    <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                        <a class="thumbnail" href="/stashit/viewspace?spaceId=${space.storageSpaceId}">
                            <img class="img-responsive" src="images/nut.png" alt="nut storage">
                        </a>
                        <p>${space.ssName}</p>
                        <p>${space.ssType}</p>
                    </div>

                </c:forEach>

            </div>

        </div>
    </div>
</div>


