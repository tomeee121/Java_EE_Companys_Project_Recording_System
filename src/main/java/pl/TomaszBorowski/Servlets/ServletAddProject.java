package pl.TomaszBorowski.Servlets;

import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.projektModel;
import pl.TomaszBorowski.Model.rodzajModel;
import pl.TomaszBorowski.Model.statusModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@WebServlet("/dodajProjekt")
public class ServletAddProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDAO reference = new ProjectDAO();
        List<statusModel> statuses = reference.getStatus();
        List<rodzajModel> kinds = reference.getKinds();
        request.setAttribute("statuses",statuses);
        request.setAttribute("kinds",kinds);

        request.getRequestDispatcher("/WEB-INF/dodajProjekt.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDAO ref = new ProjectDAO();
        projektModel projektModel = generateOject(request);
        ref.saveProject(projektModel);

        List<statusModel> statuses = ref.getStatus();
        List<rodzajModel> kinds = ref.getKinds();
        request.setAttribute("statuses",statuses);
        request.setAttribute("kinds",kinds);

        request.getRequestDispatcher("/WEB-INF/dodajProjekt.jsp").forward(request,response);
    }

    private projektModel generateOject(HttpServletRequest request) {
        ProjectDAO ref = new ProjectDAO();
        String status = request.getParameter("status");
        String kind = request.getParameter("kind");
        String nr_projekt = request.getParameter("nr_projekt");
        String temat_projekt = request.getParameter("temat_projekt");
        String kwota1 = request.getParameter("kwota");
        BigDecimal kwota = new BigDecimal(kwota1);
        String uwagi = request.getParameter("uwagi");
        String data_rozpoczeciaString = request.getParameter("data_rozpoczecia");
        String data_zakonczeniaString = request.getParameter("data_zakonczenia");

        //initializing java.sql.Date objects
        java.sql.Date data_rozpoczecia = null;
        java.sql.Date data_zakonczenia = null;

        //converting string into sql date);
        try {
            data_rozpoczecia = new java.sql.Date(
                    ((java.util.Date) new SimpleDateFormat("yyyy-MM-dd").parse(data_rozpoczeciaString)).getTime());

            data_zakonczenia = new java.sql.Date(
                    ((java.util.Date) new SimpleDateFormat("yyyy-MM-dd").parse(data_zakonczeniaString)).getTime());


        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Integer> statusIdList = ref.getStatusId(status);
        Integer Id_status = 0;
        for(Integer one : statusIdList){
            Id_status = one;
        }

        List<Integer> kindIdList = ref.getKindId(kind);
        Integer Id_rodzaj = 0;
        for(Integer one : kindIdList){
            Id_rodzaj = one;
        }

        return new projektModel(Id_rodzaj,Id_status,nr_projekt,temat_projekt, data_rozpoczecia,data_zakonczenia,kwota,uwagi);
    }

}

