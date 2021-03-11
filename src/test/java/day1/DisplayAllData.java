package day1;

import java.sql.*;

public class DisplayAllData {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@3.84.101.66:1521:xe";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM COUNTRIES");

        //how to get last row number--> rs.last(0
        // how to get current last row --> rs.getRow
        rs.last();
       int rowNum =  rs.getRow();
        System.out.println("row num is: "+rowNum);


        ResultSetMetaData rsmd=rs.getMetaData();
        int colcount = rsmd.getColumnCount();

        // i want to print out entire row of data in 1 line
        // example looping by 1
//        rs.first();
//        for (int col = 1; col <=colcount; col++) {
//            System.out.print(rs.getString(col) +"\t");
//
//        }
//        System.out.println();


        System.out.println("----------------------------------------------------");
        System.out.println("THIS is printing each column names");
        // print al collumn names
        for (int col = 1; col <= colcount; col++) {
            System.out.println(rsmd.getColumnName(col)+"\t");
        }


        System.out.println("-----------------------------------------------------");

        System.out.println("THIS is printing each column row data");

        rs.beforeFirst();
        // now i want to go through each and evevry row
        while (rs.next()) {
            // this will print entire row

            for (int col = 1; col <= colcount; col++) {
                System.out.print(rs.getString(col) + "\t");
            }
            System.out.println();
        }

        rs.close();
       stm.close();
        con.close();
    }
}
