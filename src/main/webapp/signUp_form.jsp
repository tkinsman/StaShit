<div class="container">

    <form action="/stashit/adduser" method="post" class="form-horizontal" role="form" style="padding-bottom: 2%">
        <div class="form-group">
            <legend>Sign Up</legend>
            <h4><small> DO IT.<br> Squirrel wants it.</small></h4>
        </div>
        <div class="col-sm-8">
            <div class="row">
                <div class="col-sm-12 form-group">
                    <label>Username</label>
                    <input type="text" id="username" name="username" placeholder="Enter Username Here.." class="form-control">
                </div>
                <div class="col-sm-6 form-group">
                    <label>First Name</label>
                    <input type="text" id="firstName" name="firstName" placeholder="Enter First Name Here.." class="form-control">
                </div>
                <div class="col-sm-6 form-group">
                    <label>Last Name</label>
                    <input type="text" id="lastName" name="lastName" placeholder="Enter Last Name Here.." class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>Address</label>
                <textarea placeholder="Enter Address Here.." rows="3" id="address" name="address" class="form-control"></textarea>
            </div>
            <div class="row">
                <div class="col-sm-4 form-group">
                    <label>City</label>
                    <input type="text" id="city" name="city" placeholder="Enter City Name Here.." class="form-control">
                </div>
                <div class="col-sm-4 form-group">
                    <label>State</label>
                    <input type="text" id="state" name="state" placeholder="Enter State Name Here.." class="form-control">
                </div>
                <div class="col-sm-4 form-group">
                    <label>Zip</label>
                    <input type="text" id="zipcode" name="zipcode" placeholder="Enter Zip Code Here.." class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number Here.." class="form-control">
            </div>
            <div class="form-group">
                <label>Email Address</label>
                <input type="text" id="email" name="email" placeholder="Enter Email Address Here.." class="form-control">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="text" id="password" name="password" placeholder="Enter A Password Here.." class="form-control">
            </div>
            <div class="form-group">
                <label>Confirm Password</label>
                <input type="text" id="confirmPassword" name="confirmPassword" placeholder="Confirm Your Password Here.." class="form-control">
            </div>

            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="index.jsp"> <label>Cancel</label> </a>

            </div>

        </div>
    </form>
</div><!-- /.container -->