package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/edytujStatus")
public class ServletEditStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String id_status = request.getParameter("id_status");
        Integer id = Integer.valueOf(id_status);
        ProjectDAO ref = new ProjectDAO();
        ref.editStatus(id,title);
        request.getRequestDispatcher("/WEB-INF/pokazStatus.jsp").forward(request,response);

    }

}
