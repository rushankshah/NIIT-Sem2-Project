
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

@WebServlet(urlPatterns = {"/DeleteBookController"})
public class DeleteBookController extends HttpServlet 
{
    @Override
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
    {
        int id=Integer.parseInt(req.getParameter("id"));
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData","rushank","rushank");
            PreparedStatement ps=con.prepareStatement("update books set status='D' where bookid="+id);
            ps.executeUpdate();
            
            res.sendRedirect("DisplayBooks.jsp");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
}
