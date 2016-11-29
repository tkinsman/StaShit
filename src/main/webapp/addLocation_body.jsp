<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 11/29/16
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<form action="" method="post" role="form">
	<legend>Add New Storage Space</legend>

	<div class="form-group">
		<label for="">Storage Space Name</label>
		<input type="text" class="form-control" name="" id="" placeholder="Input...">
	</div>

    <div class="form-group">
        <label for="">Description</label>
        <input type="text" class="form-control" name="" id="" placeholder="Input...">
    </div>

    <div class="form-group">
        <label for="">Storage Space Type</label>
        <select name="spaceType" id="spaceTypeId" class="form-control">
            <option value="garage">Garage</option>
            <option value="attic">Attic</option>
            <option value="basement">Basement</option>
            <option value="shed">Shed</option>
            <option value="other">Other</option>
        </select>
    </div>


    <div class="btn-group">
        <button type="submit" class="btn btn-primary">Submit</button>
        <%--todo fix this--%>
        <button type="button" class="btn btn-default" ><a href="userHome.jsp">Cancel</a></button>
    </div>

</form>
