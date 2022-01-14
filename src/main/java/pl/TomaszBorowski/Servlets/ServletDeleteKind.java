package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/usuńRodzaj")
public class ServletDeleteKind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_rodzaj_req = request.getParameter("id_rodzaj");
        Integer id_rodzaj = Integer.valueOf(id_rodzaj_req);
        ProjectDAO ref = new ProjectDAO();
        ref.deleteRodzaj(id_rodzaj);
        response.sendRedirect("/projekt/pokazRodzaj");


    }



}
