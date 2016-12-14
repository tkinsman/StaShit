<%--
  Created by IntelliJ IDEA.
  User: toddkinsman
  Date: 11/29/16
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<form action="/stashit/addlocation" method="post" role="form">

    <legend>Storage Location Details</legend>
    <div class="form-group">
        <label for="stoLocName">Storage Location Name</label>
        <input type="text" class="form-control" name="stoLocName" id="stoLocName" placeholder="${storageLoc.stoLocName}" value="${storageLoc.stoLocName}"/>
    </div>

    <div class="form-group">
        <label for="stoLocDescription">Description</label>
        <input type="text" class="form-control" name="stoLocDescription" id="stoLocDescription"  placeholder="location description" value="${storageLoc.stoLocDescription}"/>
    </div>

    <div class="form-group">
        <label for="stoLocAddress">Address</label>
        <input type="text" class="form-control" name="stoLocAddress" id="stoLocAddress" placeholder="address" value="${storageLoc.stoLocAddress}"/>
    </div>

    <div class="form-group">
        <label for="city">City</label>
        <input type="text" class="form-control" name="city" id="city" placeholder="city" value="${storageLoc.city}"/>
    </div>

    <div class="form-group">
        <label for="stoLocState">State</label>
        <input type="text" class="form-control" name="stoLocState" id="stoLocState" placeholder="state" value="${storageLoc.stoLocState}"/>
    </div>

    <div class="form-group">
        <label for="stoLocZip">Zip</label>
        <input type="text" class="form-control" name="stoLocZip" id="stoLocZip" placeholder="zipcode" value="${storageLoc.stoLocZip}"/>
    </div>


    <div class="btn-group">
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="button" class="btn btn-default" ><a href="/stashit/userhome">Cancel</a></button>
    </div>

</form>
