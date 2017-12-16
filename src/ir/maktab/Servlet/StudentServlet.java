package ir.maktab.Servlet;

import ir.maktab.Dao.Student.StudentDao;
import ir.maktab.Dao.Student.StudentDaoImpl;
import ir.maktab.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by nader on 12/11/2017.
 */
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    StudentDao studentDao;

    public void init() throws ServletException{
        studentDao = new StudentDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            switch (request.getParameter("button")) {
                case "Load":
                    out.print(studentDao.get(Integer.parseInt(request.getParameter("id"))));
                    break;
                case "Add":
                    Student student = new Student(request.getParameter("id").equals("")?null:Integer.parseInt(request.getParameter("id"))
                            , request.getParameter("name"), request.getParameter("dept"), Integer.parseInt(request.getParameter("profid")));
                    out.print(studentDao.add(student));
                    break;
                case "Edit":
                    Student studentEd = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("name")
                            , request.getParameter("dept"), Integer.parseInt(request.getParameter("profid")));
                    out.print(studentDao.edit(studentEd));
                    break;
                case "Delete":
                    out.print(studentDao.delete(Integer.parseInt(request.getParameter("id"))));
                    break;
                default:
                    out.print("wrong!");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("HeLLO\n");
        try {
            out.print(studentDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
