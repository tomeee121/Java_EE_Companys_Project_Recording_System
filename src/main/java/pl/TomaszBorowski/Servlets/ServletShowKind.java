package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.rodzajModel;
import pl.TomaszBorowski.Model.statusModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/pokazRodzaj")
public class ServletShowKind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDAO reference = new ProjectDAO();
        List<rodzajModel> kinds = reference.getKinds();
        request.setAttribute("kinds",kinds);

        request.getRequestDispatcher("/WEB-INF/pokazRodzaj.jsp").forward(request,response);
    }
}
