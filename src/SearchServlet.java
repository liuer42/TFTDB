import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet",
            urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private final String USER = "eric";
    private final String PW = "eric";
    private final String DRIVER = "jdbc:derby:";
    private final String DB_PATH = "/WEB-INF/lib/tftdb";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(DB_PATH);

            conn = DriverManager.getConnection(DRIVER + path, USER, PW);

            pstmt = conn.prepareStatement("SELECT * from Champions WHERE name = ?");

            String searchTerm = request.getParameter("searchTerm");

            pstmt.setString(1, searchTerm);

            rset = pstmt.executeQuery();

            StringBuilder html = new StringBuilder("<html><body>");

            while(rset.next()){
                int id = rset.getInt("champid");
                String name = rset.getString("name");
                String abilityName = rset.getString("abilityName");
                String abilityDesc = rset.getString("abilityDesc");
                html.append("<p>ID: ").append(id).append("<br/>").append("Name: ").append(name).append("<br/>Ability<br/>").append(abilityName).append(": ").append(abilityDesc).append("</p>");
            }

            html.append("</body></html>");

            response.getWriter().print(html.toString());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().print(e.getMessage());
        }

    }
}
