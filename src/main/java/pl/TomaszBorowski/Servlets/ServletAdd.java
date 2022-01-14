package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/dodaj")
public class ServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        request.setAttribute("check",check);

        request.getRequestDispatcher("/WEB-INF/dodaj.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = "";
        String title = request.getParameter("title");
        if(title.equals(null) || title.equals("")){
            check = "error";
            request.setAttribute("check", check);
            request.getRequestDispatcher("/WEB-INF/dodaj.jsp").forward(request,response);
//            response.sendRedirect("/projekt".concat("/dodajStatus"));
        }
        else {
            request.setAttribute("check",check);
            ProjectDAO reference = new ProjectDAO();
            reference.addProject(title);
            request.getRequestDispatcher("/WEB-INF/dodaj.jsp").forward(request,response);
//            response.sendRedirect("/projekt");
        }
    }
}
