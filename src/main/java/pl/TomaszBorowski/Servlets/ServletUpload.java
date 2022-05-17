package pl.TomaszBorowski.Servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.projektModel;
import pl.TomaszBorowski.Service.UploadService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5/*,
        location = "D:\\Projekty_Java\\Java_EE\\projekty—kopia(2)\\src\\main\\webapp\\WEB-INF\\tmp"*/)
@WebServlet("/upload")
    public class ServletUpload extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProjectDAO DAO = new ProjectDAO();

        UploadService uploadService = new UploadService();
        String path = uploadService.uploadFile(request);
        try {
            List<projektModel> projectsToSave = uploadService.retrieveDataFromXLSX(path);
            projectsToSave.forEach(DAO::saveProject);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<projektModel> projekty = DAO.getProjects();
        request.setAttribute("projekty", projekty);
        request.getRequestDispatcher("/WEB-INF/wykazProjektow.jsp").forward(request,response);

    }
}
