import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet",
urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private final String USER = "eric";
    private final String PW = "eric";
    private final String DRIVER = "jdbc:derby:";
    private final String DB_PATH = "/WEB-INF/lib/tftdb";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(DB_PATH);

            conn = DriverManager.getConnection(DRIVER + path, USER, PW);

            stmt = conn.createStatement();

            rset = stmt.executeQuery("Select Name, champid, ORIGIN from Champions");

            StringBuilder html = new StringBuilder("<html><body>");

            while (rset.next()){
                int id = rset.getInt("champID");
                String name = rset.getString("Name");
                String origin = rset.getString("Origin");

                html.append("<p>ID:").append(id).append("<br/>").append(name).append("<br/>Origin: ").append(origin).append("</p>");
            }
            html.append("</body></html>");

            response.getWriter().print(html.toString());

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().print(e.getMessage());
        }
        finally {
            try {
                if(rset != null) {
                    rset.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
