package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUTill {
        public static Connection getConnection() throws SQLException {
            Connection c = null;

            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                String url = "jdbc:mySQL://127.0.0.1:3306/vevippro?useSSL=false";
                String username = "root";
                String password = "duongvanhoan22082005";

                // tao ket noi
                c = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return c;
        }
}

