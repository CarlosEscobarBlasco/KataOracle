package kataoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KataOracle {

    private static final String URL = "jdbc:oracle:thin:@localhost:1002:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "orcl";
    private static final String QUERY = "select * from cambio_eur_a";

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement =  connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY);
        while(resultSet.next()){
            System.out.println(resultSet.getString("DIVISA")+" ");
            System.out.println(resultSet.getString("CAMBIO"));
        }
        connection.close();
                
    }
}
