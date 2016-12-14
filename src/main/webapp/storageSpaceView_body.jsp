<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 12/14/16
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="container">

    <div class="starter-template">
        <h1>Storage Space Details</h1>
    </div>

    <div class="col-lg-12">

        <h2 class="page-header">${storageSpace.ssName}</h2>

        <input type="hidden" id="storageSpaceView" value="${storageSpace}">

    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-12" style="padding: 2%;">

                <h2 class="page-header">Space Details</h2>

                <p class="navbar-text pull-right">
                    <a href="/stashit/editspace" class="navbar-link">Edit Space</a>
                </p>

            </div>

            <div class="col-lg-12" style="height:250px; overflow-y:scroll; background:lightgray; padding-top: 1%">

                <%@include file="storageSpaceView_form.jsp"%>

            </div>
        </div>


    </div>
</div>

