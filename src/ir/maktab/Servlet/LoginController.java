package ir.maktab.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nader on 12/12/2017.
 */
@WebServlet("/ControllerServlet")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String un = request.getParameter("uname");
        String pwd = request.getParameter("pass");

        if (un.equals("nader") && pwd.equals("1993")){
            out.print("Welcome, " + un);
            HttpSession session = request.getSession(true); // reuse existing
            // session if exist
            // or create one
            session.setAttribute("user", un);
            session.setMaxInactiveInterval(500); // 500 seconds
            response.sendRedirect("studentPage.jsp");
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Either userName or password is wrong.</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
