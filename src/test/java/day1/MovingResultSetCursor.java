package day1;

import java.sql.*;

public class MovingResultSetCursor {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.84.101.66:1521:xe";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");
        /* THESE ARE METHODS of RESULTSET objects
        that we can us eto move cursor accordingly
        THIS will only work if your result is type scroll insesitive

         rs.next();
        rs.previous();
        rs.first();
        rs.last();
        rs.beforeFirst(); // move right before 1st line
        rs.afterLast();
        rs.absolute(3); // move in specific row
        */

        rs.first();
        System.out.println("First row " + rs.getString(2));
        rs.last();
        System.out.println("LAst row " + rs.getString(2));
        rs.previous();
        System.out.println("Previous row "+ rs.getString(2));

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("2nd collumn data : "+rs.getString(2));
        }

        // move to 2nd row from this point and print resion_name
        rs.absolute(2);
        System.out.println("2nd row REGION_NAME is :"+rs.getString(2));
    }
}
