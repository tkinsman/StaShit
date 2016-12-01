<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 11/29/16
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<form action="/addspace" method="post" role="form">
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
        <label for="storageLocationId">Storage Location</label>

        <%--todo need to update with locaiton jsp--%>
        <a href="">Add Location</a>
        <select name="storageLocation" id="storageLocationId" class="form-control">
            <c:forEach var="location" items="${storageLocations}">
                <option value="${location.storageLocId}">${location.stoLocName}</option>
            </c:forEach>
        </select>
    </div>

    <div class="btn-group">
        <button type="submit" class="btn btn-primary">Submit</button>
        <%--todo fix this--%>
        <button type="button" class="btn btn-default" ><a href="userHome.jsp">Cancel</a></button>
    </div>

</form>
