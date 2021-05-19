

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Log in</title>
    </head>
    <body>
            <jsp:include page="CommonHeader.jsp"/>
        
        <div class="container col-lg-4 col-md-6 col-sm-12 col-xs-12">
            <div class="text-center">
                Log In :
            </div>
            <form action="LoginValidation" method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter Username">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter Password">
                </div>
                <div class="form-group">
                    <input type="submit" value="Log in" class="btn btn-success">
                    <br>
                    Don't Have an account ?
                    <input type="button" value="Register Now" onclick="window.location='Register.jsp'" class="btn btn-warning">
                </div>
            </form>
        </div>
    </body>
</html>