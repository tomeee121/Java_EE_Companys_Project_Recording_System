package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.statusModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/pokazStatus")
public class ServletShowStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDAO reference = new ProjectDAO();
        List<statusModel> statuses = reference.getStatus();
        request.setAttribute("statuses",statuses);

        request.getRequestDispatcher("/WEB-INF/pokazStatus.jsp").forward(request,response);
    }

}
