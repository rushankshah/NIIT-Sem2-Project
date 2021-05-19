<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <jsp:include page="CommonHeader.jsp"/>

        <div class="container col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <c:if test="${book==null}">    
                <div class="text-center">
                    Add Book
                </div>
            </c:if>
           <c:if test="${book!=null}">   
                <div class="text-center">
                    Update Book
                </div>
           </c:if>
            <div>
                <c:if test="${book==null}">
                    <form action="AddBookController" method="post">
                </c:if>
                <c:if test="${book!=null}">
                    <form action="UpdateBookController" method="post">
                        <div class="form-group">
                            <label>Book Id</label>
                            <input type="text" name="bookid" value="${book.getBookId()}" readonly class="form-control">
                        </div>
                </c:if>
                
                <div class="form-group">
                    <label>Book Name</label>
                    <input type="text" name="bookname" value="${book.getBookName()}" class="form-control" placeholder="Enter Book Name">
                </div>
                <div class="form-group">
                    <label>Author</label>
                    <input type="text" name="authorname" value="${book.getAuthorName()}" class="form-control" placeholder="Enter Author Name">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="text" name="price" value="${book.getPrice()}" class="form-control" placeholder="Enter Price">
                </div>
                <div class="form-group">
                    <label>Link</label>
                    <input type="text" name="linkname" value="${book.getLinkName()}" class="form-control" placeholder="Enter PDF link">
                </div>
                <c:if test="${book==null}">
                    <div>
                        <input type="submit" value="Add Book" class="btn btn-success">                        
                        <input type="reset" value="Reset" class="btn btn-danger">
                    </div>
                </c:if>
                <c:if test="${book!=null}">
                    <div>
                        <input type="submit" value="Update Book" class="btn btn-warning">
                        <input type="reset" value="Reset" class="btn btn-danger">
                    </div>
                </c:if>
                
                </form>
                
            </div>
                
        </div>
    </body>
</html>
