package day1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ResultSetMethodColumnInfo {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM COUNTRIES");

        // ResultSet object only contains the data comes from the query result
        // It does not have any method to get information about columns or columns datatype and so on
        // ResultSetMeta data , which is obtained by ResultSet object contains column information

        // usage of ResultNExtMetaData is used only for dealing with collumn(how many collumns in a table)
        ResultSetMetaData rsmd = rs.getMetaData();
        // 2 methods which we gonna use
        // rsmd.getColumnCount();
        //rsmd.getColumnName();
        System.out.println("rsmd.getCollumnCount: " + rsmd.getColumnCount());
        System.out.println("rsmd.getColumnNme: " + rsmd.getColumnName(2));
        System.out.println("rsmd.getColumnNme: " + rsmd.getColumnName(1));


        // print out all the collumn names

        int columnCount = rsmd.getColumnCount();

        for (int col = 1; col <= columnCount; col++) {
            System.out.println("column " + col + " names =" + rsmd.getColumnName(col));

        }

        // save all columnName into List

        int colCount = rsmd.getColumnCount();
        List<String> allColumns = new ArrayList<>();
        for (int col = 1; col <= colCount; col++) {
            allColumns.add(rsmd.getColumnName(col) );
        }
        System.out.println("allColumns = " + allColumns);
    }
}