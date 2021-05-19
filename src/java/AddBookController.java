
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name="AddBookController",urlPatterns="/AddBookController")
public class AddBookController extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        BookDetails bd=new BookDetails();
        bd.setBookName(req.getParameter("bookname"));
        bd.setAuthorName(req.getParameter("authorname"));
        bd.setPrice(Float.parseFloat(req.getParameter("price")));
        bd.setLinkName(req.getParameter("linkname"));
        
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData","rushank","rushank");
            PreparedStatement ps=con.prepareStatement("insert into Books(bookname,authorname,price,linkname,status)"
                    + " values(?,?,?,?,'A')");
            ps.setString(1,bd.getBookName());
            ps.setString(2,bd.getAuthorName());
            ps.setFloat(3,bd.getPrice());
            ps.setString(4,bd.getLinkName());
            ps.executeUpdate();
            System.out.println(req.getParameter("authorname"));
            res.sendRedirect("DisplayBooks.jsp");
            
                 
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}