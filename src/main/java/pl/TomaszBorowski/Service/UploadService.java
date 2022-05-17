package pl.TomaszBorowski.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.TomaszBorowski.DAO.ProjectDAO;
import pl.TomaszBorowski.Model.projektModel;

import javax.servlet.http.HttpServletRequest;

public class UploadService {

    public String uploadFile(HttpServletRequest request){
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = null;
        String path = null;
        try {
            fileItems = servletFileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
        for (FileItem fileItem : fileItems) {
            try {
                path = "D:\\Projekty_Java\\Java_EE\\projekty—kopia(2)\\src\\main\\webapp\\WEB-INF\\tmp\\" + fileItem.getName();
                File filePath = new File(path);
                fileItem.write(filePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return path;
    }

    public List<projektModel> retrieveDataFromXLSX(String path) throws IOException, ParseException {
        FileInputStream file = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        List<projektModel> projects = new ArrayList<>();
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING: data.get(new Integer(i)).add(cell.getRichStringCellValue().getString()); break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue()+"");}
                        else{
                        data.get(i).add(cell.getNumericCellValue()+"");} break;
                    case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + ""); break;
                    case FORMULA: data.get(i).add(cell.getCellFormula() + ""); break;
                    default: data.get(new Integer(i)).add(" ");
                }
            }
            i++;
        }
        ProjectDAO projectDAO = new ProjectDAO();

        for (Map.Entry<Integer, List<String>> dataTmp : data.entrySet()) {
//            System.out.println(dataTmp.getKey() + ":" + dataTmp.getValue());

            //pobieram w tym miejscu rodzaj projektu z bazy danych
            List<Integer> kindIdList = projectDAO.getKindId(dataTmp.getValue().get(0));
            //jezeli jest nieobecny wczesniej,dynamicznie podczas uplaodu tworzony jest odziajs/status projektu
            if(kindIdList.size()==0){
                projectDAO.addProject(dataTmp.getValue().get(0));
            }
            //ponownie pobieram id rodzaju/statusu,poniewaz w przypadku gdy w bazie dancych wczesniej nie istnial potrzebne jest jego utworzenie
            //co z kolei wpływa na zmianę id podczas wykonywania metody
            List<Integer> kindIdListNew = projectDAO.getKindId(dataTmp.getValue().get(0));
            Integer Id_rodzaj = 0;
            for(Integer one : kindIdListNew){
                Id_rodzaj = one;
            }

            List<Integer> statusIdList = projectDAO.getStatusId(dataTmp.getValue().get(1));
            if(statusIdList.size()==0){
                projectDAO.addProjectStatus(dataTmp.getValue().get(1));
            }
            List<Integer> statusIdListNew = projectDAO.getStatusId(dataTmp.getValue().get(1));
            Integer Id_status = 0;
            for(Integer one : statusIdListNew){
                Id_status = one;
            }
            
            //initializing java.sql.Date objects
//            java.sql.Date data_rozpoczecia = new java.sql.Date(
//                    ((java.util.Date) new SimpleDateFormat("yyyy-MM-dd").parse(data_rozpoczeciaString)).getTime());
//            java.sql.Date data_zakonczenia = new java.sql.Date(
//                    ((java.util.Date) new SimpleDateFormat("yyyy-MM-dd").parse(data_zakonczeniaString)).getTime());


            //excel data->string as request parameter->back to java.sql.Date format(able to save then)
            String data_rozpoczeciaString = null;
            String data_zakonczeniaString = null;

            String[] arrayWithData1 = dataTmp.getValue().get(4).split(" ");
            String year1 = arrayWithData1[5];
            String month1 = String.valueOf(convertStringMontToIntMonth(arrayWithData1[1]));
            String day1 = arrayWithData1[2];
            data_rozpoczeciaString = year1 + "-" + month1 + "-" + day1;

            String[] arrayWithData2 = dataTmp.getValue().get(5).split(" ");
            String year2 = arrayWithData1[5];
            String month2 = String.valueOf(convertStringMontToIntMonth(arrayWithData1[1]));
            String day2 = arrayWithData1[2];
            data_zakonczeniaString = year2 + "-" + month2 + "-" + day2;

            projects.add(new projektModel(Id_rodzaj,Id_status,dataTmp.getValue().get(2),
                    dataTmp.getValue().get(3),
                    java.sql.Date.valueOf(data_rozpoczeciaString),
                    java.sql.Date.valueOf(data_zakonczeniaString),
                    new BigDecimal(dataTmp.getValue().get(6)),dataTmp.getValue().get(7)));

            }
        return projects;
        }

        private static int convertStringMontToIntMonth(String month){
            int monthInt = 0;
            switch (month){
                case "Jan":
                    monthInt = 1;
                    break;
                case "Feb":
                    monthInt = 2;
                    break;
                case "Mar":
                    monthInt = 3;
                    break;
                case "Apr":
                    monthInt = 4;
                    break;
                case "May":
                    monthInt = 5;
                    break;
                case "Jun":
                    monthInt = 6;
                    break;
                case "Jul":
                    monthInt = 7;
                    break;
                case "Aug":
                    monthInt = 8;
                    break;
                case "Sep":
                    monthInt = 9;
                    break;
                case "Oct":
                    monthInt = 10;
                    break;
                case "Nov":
                    monthInt = 11;
                    break;
                case "Dec":
                    monthInt = 12;
                    break;
            }
            return monthInt;
        }
}

