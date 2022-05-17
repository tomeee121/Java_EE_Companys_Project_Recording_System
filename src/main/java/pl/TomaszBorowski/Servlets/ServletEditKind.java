package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/edytujRodzaj")
public class ServletEditKind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String id_rodzaj = request.getParameter("id_rodzaj");
        Integer id = Integer.valueOf(id_rodzaj);
        ProjectDAO ref = new ProjectDAO();
        ref.editKind(id,title);
        response.sendRedirect("/projekt/pokazStatus");

//        request.getRequestDispatcher("/WEB-INF/pokazRodzaj.jsp").forward(request,response);


    }
}
