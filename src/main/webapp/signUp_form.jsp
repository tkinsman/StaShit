<div class="container">


    <form action="/stashit/adduser" method="post" role="form">

    	<div class="form-group">
            <legend>Sign Up</legend>
        </div>

        <span class="label" style="color: black;">${formMessage}</span>

    	<div class="form-group">
    		<label for="username">Username:</label>
    		<input type="text" class="form-control" name="username" id="username" placeholder="username">
    	</div>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="first name">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="last name">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" name="address" id="address" placeholder="address">
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" name="city" id="city" placeholder="city">
        </div>
        <div class="form-group">
            <label for="state">State:</label>
            <input type="text" class="form-control" name="state" id="state" placeholder="state">
        </div>
        <div class="form-group">
            <label for="zipcode">Zipcode:</label>
            <input type="text" class="form-control" name="zipcode" id="zipcode" placeholder="zipcode">
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="phoneNumber">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" id="email" placeholder="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="password">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="confirm password">
        </div>


    	<button type="submit" class="btn btn-primary">Submit</button>
        <a href="/stashit/index">Cancel</a>

    </form>
</div><!-- /.container -->