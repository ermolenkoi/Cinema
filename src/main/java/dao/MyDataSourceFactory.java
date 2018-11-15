package dao;

import org.postgresql.ds.PGSimpleDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDataSourceFactory {
    public static DataSource getMyPGDataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();

        ds.setServerName("localhost");
        ds.setDatabaseName("cinema");
        ds.setUser("postgres");
        ds.setPassword("4rfv5tgb");

        return ds;
    }

    public static DataSource getMyDataSource(String dbType) {
        BasicDataSource ds = new BasicDataSource();
        if ("postgres".equals(dbType)){
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl("jdbc:postgresql://localhost:5432/cinema");
            ds.setUsername("postgres");
            ds.setPassword("4rfv5tgb");
            return ds;
        }
        return null;
    }

    public static Connection getConnection(){
        Connection con = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/Postgres");
            return ds.getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return con;
    }
}
