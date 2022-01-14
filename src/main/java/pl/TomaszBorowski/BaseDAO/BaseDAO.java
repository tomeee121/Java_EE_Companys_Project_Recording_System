package pl.TomaszBorowski.BaseDAO;

import pl.TomaszBorowski.DBconfig.DataSourceProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    private final DataSource dataSource;

    public BaseDAO() {
        dataSource = DataSourceProvider.getDataSource();
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            return connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
