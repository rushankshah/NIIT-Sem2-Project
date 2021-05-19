<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Books</title>
    </head>
    <body>
            <jsp:include page="CommonHeader.jsp"/>
        
            <div class="text-center">
            <input type="button" onclick="window.location='AddBook.jsp'" value="Add Book" class="btn btn-success">
        </div>
        <br>
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver"
                           url="jdbc:derby://localhost:1527/LibraryUserData"
                           user="rushank"
                           password="rushank"
                           var="mydatasource"/>
            
        <!--Expressioin Language-->
        <sql:query dataSource="${mydatasource}" var="data">
            select * from books where status='A'
        </sql:query>    
        
        <div class=" text-center">    
            <table class="table table-bordered col-lg-8 col-md-12 col-sm-12 col-xs-12">
                <thead class="thead-dark">
                    <tr>
                        <th>Book Id</th>
                        <th>Book Name</th>
                        <th>Author Name</th>
                        <th>Price</th>  
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${data.rows}" var="row">
                    <tr>
                    
                        <td>${row.bookid}</td>
                        <td><a href="${row.linkname}">${row.bookname}</a></td>
                        <td>${row.authorname}</td>
                        <td>${row.price}</td>
                    
                        <td>
                            <a href="EditBookController?id=${row.bookid}" class="btn btn-primary">Edit</a>
                            <a href="DeleteBookController?id=${row.bookid}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
