import dao.MyDataSourceFactory;

import java.sql.Connection;

public class TestDataSource {
    public static void main(String[] args) {
        Connection con = MyDataSourceFactory.getConnection();
        System.out.println(con.getClass());
    }

}
