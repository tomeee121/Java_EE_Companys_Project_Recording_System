package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.projektModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/wykazProjektow")
public class ServletShowProjects extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDAO ref = new ProjectDAO();
        List<projektModel> projekty = ref.getProjects();
        request.setAttribute("projekty",projekty);
        request.getRequestDispatcher("/WEB-INF/wykazProjektow.jsp").forward(request,response);



    }


}
