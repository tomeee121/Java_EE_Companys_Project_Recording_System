package pl.TomaszBorowski.DAO;

import pl.TomaszBorowski.DBconfig.DataSourceProvider;
import pl.TomaszBorowski.Model.projektModel;
import pl.TomaszBorowski.Model.rodzajModel;
import pl.TomaszBorowski.Model.statusModel;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ProjectDAO {
    private DataSource dataSource;

    public ProjectDAO(){
        this.dataSource= DataSourceProvider.getDataSource();
    }

    public List<statusModel> getStatus(){
        final String querry = """
        SELECT Id_status, nazwa_status FROM status ORDER BY Id_status ASC""";
        List<statusModel> statuses = new ArrayList<>();

        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(querry);
            while(set.next()){
                statusModel one = mapper(set);
                statuses.add(one);
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return statuses;
    }

    private static statusModel mapper(ResultSet set){
        try {
            Integer id_status = set.getInt("Id_status");
            String nazwa_status = set.getString("nazwa_status");
            return new statusModel(id_status, nazwa_status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<rodzajModel> getKinds() {
        final String querry = """
        SELECT Id_rodzaj, nazwa_rodzaj FROM rodzaj ORDER BY Id_rodzaj ASC""";
        List<rodzajModel> kinds = new ArrayList<>();

        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(querry);
            while(set.next()){
                rodzajModel one = mapper2(set);
                kinds.add(one);
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return kinds;
    }

    private static rodzajModel mapper2(ResultSet set){
        try {
            Integer id_rodzaj = set.getInt("Id_rodzaj");
            String nazwa_rodzaj = set.getString("nazwa_rodzaj");
            return new rodzajModel(id_rodzaj, nazwa_rodzaj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProject(String title){
        final String sql = """
                INSERT INTO rodzaj (nazwa_rodzaj) VALUES (?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,title);
            statement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProjectStatus(String title) {
        final String sql = """
                INSERT INTO status (nazwa_status) VALUES (?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,title);
            statement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStatus(Integer id_status){
        final String sql = """
                DELETE FROM status WHERE Id_status=?""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id_status);
            statement.executeUpdate();

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRodzaj(Integer id_rodzaj) {
        final String sql = """
                DELETE FROM rodzaj WHERE Id_rodzaj=?""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id_rodzaj);
            statement.executeUpdate();

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editStatus(Integer id, String title) {

                final String querry = """
                UPDATE status SET nazwa_status = (?) WHERE Id_status = (?)""";
                try (
                        Connection connection = dataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(querry)) {
                        statement.setString(1,title);
                        statement.setInt(2,id);
                        statement.executeUpdate();
            } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    }

    public void editKind(Integer id, String title) {
        final String querry = """
                UPDATE rodzaj SET nazwa_rodzaj = (?) WHERE Id_rodzaj = (?)""";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1,title);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getStatusId(String nazwa_status) {
        final String querry = """
        SELECT Id_status FROM status WHERE nazwa_status=(?)""";
        List<Integer> idsfromstatus = new ArrayList<>();

        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1,nazwa_status);
            ResultSet set = statement.executeQuery();
            while(set.next()){
            Integer Id_status = set.getInt("Id_status");
            idsfromstatus.add(Id_status);}

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return idsfromstatus;
    }

    public List<Integer> getKindId(String nazwa_rodzaj) {
        final String querry = """
        SELECT Id_rodzaj FROM rodzaj WHERE nazwa_rodzaj=?""";
        List<Integer> idsfromkind = new ArrayList<>();

        try (   Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(querry)) {
            statement.setString(1,nazwa_rodzaj);
            ResultSet set = statement.executeQuery();
            while(set.next()){
            Integer Id_rodzaj = set.getInt("Id_rodzaj");
            idsfromkind.add(Id_rodzaj);}

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return idsfromkind;
    }

    public void saveProject(projektModel projektModel) {
        final String sql = """
                INSERT INTO projekt (Id_rodzaj, Id_status, nr_projekt, temat_projekt, data_rozpoczecia, data_zakonczenia, kwota, uwagi) VALUES (?,?,?,?,?,?,?,?)""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,projektModel.getId_rodzaj());
            statement.setInt(2,projektModel.getId_status());
            statement.setString(3,projektModel.getNr_projekt());
            statement.setString(4,projektModel.getTemat_projekt());
            statement.setDate(5, projektModel.getData_rozpoczecia());
            statement.setDate(6, projektModel.getData_zakonczenia());
            statement.setBigDecimal(7,projektModel.getKwota());
            statement.setString(8,projektModel.getUwagi());

            statement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<projektModel> getProjects(){
        final String querry = """
        SELECT p.Id_projekt, r.nazwa_rodzaj, s.nazwa_status, p.nr_projekt, p.temat_projekt, p.data_rozpoczecia, p.data_zakonczenia, p.kwota, p.uwagi 
        FROM projekt p INNER JOIN status s ON p.Id_status = s.Id_status 
        INNER JOIN rodzaj r ON p.Id_rodzaj = r.Id_rodzaj
        ORDER BY Id_projekt ASC""";
        List<projektModel> projekty = new ArrayList<>();

        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(querry);
            while(set.next()){
                projektModel one = mapper3(set);
                projekty.add(one);
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return projekty;
    }

    private static projektModel mapper3(ResultSet set){
        try {
            String nazwa_rodzaj = set.getString("nazwa_rodzaj");
            String nazwa_status = set.getString("nazwa_status");
            String nr_projekt = set.getString("nr_projekt");
            String temat_projekt = set.getString("temat_projekt");
            java.sql.Date data_rozpoczecia = set.getDate("data_rozpoczecia");
            java.sql.Date data_zakonczenia = set.getDate("data_zakonczenia");
            BigDecimal kwota = set.getBigDecimal("kwota");
            String uwagi = set.getString("uwagi");

            return new projektModel(nazwa_rodzaj,nazwa_status,nr_projekt,temat_projekt,data_rozpoczecia,data_zakonczenia,kwota,uwagi);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//
//    public List<String> getKindName(Integer Id_rodzaj) {
//        List<String> theName = new ArrayList<>();
//
//        final String querry = """
//        SELECT nazwa_rodzaj FROM rodzaj WHERE Id_rodzaj=?""";
//
//        try (   Connection connection = dataSource.getConnection();
//                PreparedStatement statement = connection.prepareStatement(querry)) {
//            statement.setInt(1,Id_rodzaj);
//            ResultSet set = statement.executeQuery();
//            while(set.next()){
//                String nazwa_rodzaj = set.getString("nazwa_rodzaj");
//                theName.add(nazwa_rodzaj)
//            }
//        }
//        catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        return theName;
//    }
//
//    public List<String> getStatusName(Integer Id_status) {
//        List<String> theName = new ArrayList<>();
//
//        final String querry = """
//        SELECT nazwa_status FROM status WHERE Id_status=?""";
//
//        try (   Connection connection = dataSource.getConnection();
//                PreparedStatement statement = connection.prepareStatement(querry)) {
//            statement.setInt(1,Id_status);
//            ResultSet set = statement.executeQuery();
//            while(set.next()){
//                String nazwa_status = set.getString("nazwa_status");
//                theName.add(nazwa_status);
//            }
//        }
//        catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        return theName;
//    }
}


