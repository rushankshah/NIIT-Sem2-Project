
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="RegisterController",urlPatterns="/RegisterController")
public class RegisterController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        DetailsClass dc=new DetailsClass();
        dc.setUsername(req.getParameter("username"));
        dc.setEmail(req.getParameter("email"));
        dc.setPassword(req.getParameter("password"));
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData","rushank","rushank");
            PreparedStatement ps=con.prepareStatement("insert into USERDATA values(?,?,?)");
            ps.setString(1,dc.getUsername());
            ps.setString(2,dc.getEmail());
            ps.setString(3,dc.getPassword());
            ps.executeUpdate();
            
            //RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
            res.sendRedirect("Login.jsp");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}