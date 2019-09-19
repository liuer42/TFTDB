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

            StringBuilder output = new StringBuilder("<html><body><ul>");

            while (rset.next()) {
                int id = rset.getInt(1);
                String name = rset.getString(2);
                int classId = rset.getInt(3);
                String origin = rset.getString(4);
                int cost = rset.getInt(5);
                String health = rset.getString(6);
                int armor = rset.getInt(7);
                int mr = rset.getInt(8);
                int range = rset.getInt(9);
                String abName = rset.getString(10);
                String abDesc = rset.getString(11);

                output.append("<li>").append(id);
                output.append(", ").append(name).append(", ").append(classId).append(", ").append(origin).append(", ").append(cost).append(", ").append(health).append(", ").append(armor).append(", ").append(mr).append(", ").append(range).append(", ").append(abName).append(", ").append(abDesc);
                output.append("</li>");
                output.append("</ul></body></html>");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String p = request.getParameter("param1");


        String msg = "<html><body>" + p + "</body></html>";
        response.getWriter().print(msg);*/
    }
}