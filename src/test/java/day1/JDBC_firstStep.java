package day1;

import java.sql.*;

public class JDBC_firstStep {

    public static void main(String[] args) {

        // connecting to JDBC
        String URL = "jdbc:oracle:thin:@3.84.101.66:1521:xe";
        try {
            Connection con = DriverManager.getConnection(URL, "hr", "hr");

            // this line is only for dealing with data what to do with it
            Statement stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            // object resultSet(where all results stored all adat that comes from SQL tables)
            ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

            // in order to access to ResultSet we need to know we re at
            // before entering the first row, we re at the cursor resultSet  is at the LOCATION known- AS BEFORE SET
            // in order to move to next line we need to call next method of resultSet
            // if order to get any collumn data we need to call methods getString or getDouble...

            rs.next() ;
            // now we re at 1st row
            System.out.println("FIRST ROW REGION_NAME is " + rs.getString("REGION_NAME"));


            rs.next() ;
            // now we re at 1st row
            System.out.println("SECOND ROW REGION_NAME is " + rs.getString("REGION_NAME"));


            rs.next() ;
            // now we re at 1st row
            System.out.println("THIRD ROW REGION_NAME is " + rs.getString("REGION_NAME"));


            rs.next() ;
            // now we re at 1st row
            System.out.println("FOURTH ROW REGION_NAME is " + rs.getString("REGION_NAME"));

            System.out.println("Connection successfull");
            rs.close();
            stmnt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
        }
    }
}