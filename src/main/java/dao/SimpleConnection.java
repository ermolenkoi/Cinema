package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

    public SimpleConnection(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            ex.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
    }

    public Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/cinema";
        String login = "postgres";
        String password = "4rfv5tgb";
        try{
            connection = DriverManager.getConnection(url, login, password);
        }catch(SQLException ex){
            System.out.println("Connection Failed! Check output console");
            ex.printStackTrace();
        }

        return connection;
    }
}
