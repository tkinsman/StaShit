<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 12/14/16
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<form action="/stashit/addspace" method="post" role="form">

    <legend>Add New Storage Space</legend>
    <div class="form-group">
        <label for="ssName">Storage Space Name</label>
        <input type="text" class="form-control" name="ssName" id="ssName" placeholder="Input...">
    </div>

    <div class="form-group">
        <label for="ssDesc">Description</label>
        <input type="text" class="form-control" name="ssDesc" id="ssDesc" placeholder="Input...">
    </div>

    <div class="form-group">
        <label for="spaceTypeId">Storage Space Type</label>
        <select name="spaceType" id="spaceTypeId" class="form-control">
            <option value="garage">Garage</option>
            <option value="attic">Attic</option>
            <option value="basement">Basement</option>
            <option value="shed">Shed</option>
            <option value="other">Other</option>
        </select>
    </div>

    <div class="form-group">
        <label for="storageLocId">Storage Location</label>

        <%--todo need to update with locaiton jsp--%>
        <a href="">Add Location</a>
        <select name="storageLocId" id="storageLocId" class="form-control">
            <c:forEach var="location" items="${storageLocations}">
                <option value="${location.storageLocId}">${location.stoLocName}</option>
            </c:forEach>
        </select>
    </div>

    <div class="btn-group">

        <%--todo fix this--%>
        <button type="button" class="btn btn-default" ><a href="/stashit/userhome">Cancel</a></button>
    </div>

</form>
