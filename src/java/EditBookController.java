
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;

@WebServlet(name="EditBookController", urlPatterns = "/EditBookController")
public class EditBookController extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        int id=Integer.parseInt(req.getParameter("id"));
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData", "rushank","rushank");
            PreparedStatement ps=con.prepareStatement("select * from books where bookid="+id);
            ResultSet rs =ps.executeQuery();
            
            rs.next();
            BookDetails book=new BookDetails();
            book.setBookId(id);
            book.setBookName(rs.getString("bookname"));
            book.setAuthorName(rs.getString("authorname"));
            book.setPrice(rs.getFloat("price"));
            book.setLinkName(rs.getString("linkname"));
            
            req.setAttribute("book",book);
            //System.out.println(" THe id value is :::::::::::::::::::::::::::::::::::::::::::::::::::::::::: "+book.bookid);
            RequestDispatcher rd=req.getRequestDispatcher("AddBook.jsp");
            rd.forward(req, res);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
