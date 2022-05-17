package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/usuńStatus")
public class ServletDeleteStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_status_req = request.getParameter("id_status");
        Integer id_status = Integer.valueOf(id_status_req);
        ProjectDAO ref = new ProjectDAO();
        ref.deleteStatus(id_status);
        response.sendRedirect("/projekt/pokazStatus");


    }



}
