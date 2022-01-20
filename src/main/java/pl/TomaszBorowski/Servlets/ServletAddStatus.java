package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/dodajStatus")
public class ServletAddStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        request.setAttribute("check",check);

        request.getRequestDispatcher("/WEB-INF/dodajStatus.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = "";
        String title = request.getParameter("title");
        if(title.equals(null) || title.equals("")){
            check = "error";
            request.setAttribute("check", check);
            request.getRequestDispatcher("/WEB-INF/dodajStatus.jsp").forward(request,response);
        }
        else {
            ProjectDAO reference = new ProjectDAO();
            reference.addProjectStatus(title);
            request.getRequestDispatcher("/WEB-INF/dodajStatus.jsp").forward(request,response);
        }
    }
}

