package pl.TomaszBorowski.DBconfig;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {

        private static DataSource dataSource;

        private DataSourceProvider(){};

        public static DataSource getDataSource () {
            if(dataSource == null){
                try {
                    Context init = new InitialContext();
                    Context envContext = (Context) init.lookup("java:comp/env/");
                    dataSource = (DataSource) envContext.lookup("jdbc/projekty");

                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
            return dataSource;
        }
}

