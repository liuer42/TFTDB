import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/hello")

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        String msg = "<html><body> Thanks, " + username  + ", your password is " + password +
                "</body></html>";
        response.getWriter().print(msg);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String p = request.getParameter("param1");


        String msg = "<html><body>" + p + "</body></html>";
        response.getWriter().print(msg);*/
    }
}