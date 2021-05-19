
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

@WebServlet(name="UpdateBookController" ,urlPatterns = "/UpdateBookController")
public class UpdateBookController extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        BookDetails book=new BookDetails();
        book.setBookName(req.getParameter("bookname"));
        book.setAuthorName(req.getParameter("authorname"));
        book.setPrice(Float.parseFloat(req.getParameter("price")));
        book.setLinkName(req.getParameter("linkname"));
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData","rushank","rushank");
            PreparedStatement ps=con.prepareStatement("update books set bookname=?, authorname=?, price=?, linkname=? where bookid=?");
            
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getAuthorName());
            ps.setFloat(3, book.getPrice());
            ps.setString(4, book.getLinkName());
            ps.setInt(5, Integer.parseInt(req.getParameter("bookid")));
            
            ps.executeUpdate();
            
            res.sendRedirect("DisplayBooks.jsp");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
