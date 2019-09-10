import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Servlet", urlPatterns = "/hello")

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        String msg = "<html><body> Thanks, " + username  + ", your password is " + password +
                "</body></html>";
        response.getWriter().print(msg);*/
        String absPath = getServletContext().getRealPath("/WEB-INF/../lib/tftdb");

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby:" + absPath, "eric", "eric");
            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("SELECT * FROM Classes");

        }
        catch (Exception e){
            e.printStackTrace();
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String p = request.getParameter("param1");


        String msg = "<html><body>" + p + "</body></html>";
        response.getWriter().print(msg);*/
    }
}