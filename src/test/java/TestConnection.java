import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {


        /*
        Hello World
Driver jar -->> provided through maven dependency
DriverManager -->> locate driver using connection String beginning syntax
DriverManager -->> continue to create connection using full connection info and username password
Connection Object is obtained
Statement Object is created from Connection Established above
   If not specified during creation , only the forward only ReseultSet can be created from it
ResultSet objectis created using Statement object and calling execute query method
It contains the data with rows and columns
It also maintain a cursor to point to the row so data at that location can be accessed
         */

        // host: 3.84.101.66
        // port: 1521
        // SID: xe
        // username : hr
        // password: hr


        /*
        jdbc url AKA connection STring
        syntax:
        jdbc: vendorNAme : driverame @YourHost:PORT:SID
        jdbc:oracle:thin@3.84.101.66:1521:xe
         */
        // commentblabla

        // connecting to JDBC
        String URL = "jdbc:oracle:thin:@3.84.101.66:1521:xe";
        try {
            Connection con = DriverManager.getConnection(URL, "hr", "hr");

            System.out.println("Connection successfull");

        } catch (SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
        }
    }
}