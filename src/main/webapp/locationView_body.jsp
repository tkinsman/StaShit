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

        <c:forEach items="latLong" var="coord" varStatus="loop">
            <p>First Loop ${loop.index}: ${coord}</p>
        </c:forEach>


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

                <%--<c:forEach var="location" items="${storageLocations}">--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>

                            <%--&lt;%&ndash;Todo updated db to hold images to replace this with user images&ndash;%&gt;--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>${location.stoLocName}</p>--%>
                        <%--<p>${location.stoLocState}</p>--%>
                    <%--</div>--%>

                <%--</c:forEach>--%>

            </div>
        </div>
    </div>
</div>