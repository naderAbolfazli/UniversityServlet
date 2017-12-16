package ir.maktab.Servlet;

import ir.maktab.Dao.Prof.ProfDao;
import ir.maktab.Dao.Prof.ProfDaoImpl;
import ir.maktab.model.Prof;

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
@WebServlet("/professors")
public class ProfServlet extends HttpServlet {
    ProfDao profDao = new ProfDaoImpl();

    @Override
    public void init() throws ServletException {
        profDao = new ProfDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            switch (request.getParameter("button")) {
                case "Load":
                    out.print(profDao.get(Integer.parseInt(request.getParameter("id"))));
                    break;
                case "Add":
                    Prof prof = new Prof(request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id"))
                            , request.getParameter("name"), request.getParameter("address"));
                    out.print(profDao.add(prof));
                    break;
                case "Edit":
                    Prof profEd = new Prof(Integer.parseInt(request.getParameter("id")), request.getParameter("name")
                            , request.getParameter("address"));
                    out.print(profDao.edit(profEd));
                    break;
                case "Delete":
                    out.print(profDao.delete(Integer.parseInt(request.getParameter("id"))));
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("HeLLO\n");
        try {
            out.print(profDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
