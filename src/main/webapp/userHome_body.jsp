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


    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12" style="padding: 2%;">

                <h2 class="page-header">Find Locations</h2>

                <div class="form-group">
                    <label for="storageSearch" class="col-sm-2 control-label">Search: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="storageSearch" placeholder="search for storage...">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Find Space</button>
                    </div>
                </div>


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
                <h2 class="page-header">Your Locs</h2>


                <p class="navbar-text pull-right">
                    <a href="addStorageSpace.jsp" class="navbar-link">Add New Storage</a>
                </p>
            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">
                <c:forEach var="space" items="${storageSpaces}">

                    <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                        <a class="thumbnail" href="#">
                            <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                        </a>
                        <p>${space.ssName}</p>
                        <p>${space.ssType}</p>
                    </div>

                </c:forEach>

                <%--<c:choose>--%>
                    <%--<c:when test="${TRUE}" >--%>


                            <%--<c:forEach var="space" items="${storageSpaces}">--%>

                                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                                    <%--<a class="thumbnail" href="#">--%>
                                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                                    <%--</a>--%>
                                    <%--<p>${space.ssName}</p>--%>
                                    <%--<p>${space.ssType}</p>--%>
                                <%--</div>--%>

                            <%--</c:forEach>--%>

                    <%--</c:when>--%>

                    <%--<c:otherwise>--%>

                        <%--<h3>Didn't work loading</h3>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Basement</p>--%>
                    <%--</div>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Attic</p>--%>
                    <%--</div>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Garage</p>--%>
                    <%--</div>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Basement</p>--%>
                    <%--</div>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Attic</p>--%>
                    <%--</div>--%>

                    <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                        <%--<a class="thumbnail" href="#">--%>
                            <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                        <%--</a>--%>
                        <%--<p>Garage</p>--%>
                    <%--</div>--%>

                    <%--</c:otherwise>--%>

                <%--</c:choose>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Basement</p>--%>
                <%--</div>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Attic</p>--%>
                <%--</div>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Garage</p>--%>
                <%--</div>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Basement</p>--%>
                <%--</div>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Attic</p>--%>
                <%--</div>--%>

                <%--<div class="col-lg-3 col-md-4 col-xs-6 thumb">--%>
                    <%--<a class="thumbnail" href="#">--%>
                        <%--<img class="img-responsive" src="http://placehold.it/400x300" alt="">--%>
                    <%--</a>--%>
                    <%--<p>Garage</p>--%>
                <%--</div>--%>

            </div>

        </div>
    </div>
</div>


