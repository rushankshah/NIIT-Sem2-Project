
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

@WebServlet(name="LoginValidation",urlPatterns="/LoginValidation")
public class LoginValidation extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryUserData","rushank","rushank");
            PreparedStatement ps=con.prepareStatement("select password from UserData where username=?");
            ps.setString(1,req.getParameter("username"));
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                res.sendRedirect("DisplayBooks.jsp");
            }
            else
            {
                res.sendRedirect("Login.jsp");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}