

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registration</title>
    </head>
    <body>
            <jsp:include page="CommonHeader.jsp"/>
            
        <div class="container col-lg-4 col-md-6 col-sm-12 col-xs-12">
            <div class="text-center">
                Registration :
            </div>
            <form action="RegisterController" method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" name="username" class="form-control" placeholder="Enter Username">
                </div>
                <div class="form-group">
                    <label>E-Mail:</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter E-Mail-id">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter Password">
                </div>
                <div class="form-group">
                    <input type="submit" value="Submit" class="btn btn-success ">
                    <input type="reset" value="Reset" class="btn btn-danger">
                </div>
            </form>
        </div>
           
     
    </body>
</html>
