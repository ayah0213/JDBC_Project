package day1;

import java.sql.*;

public class LoopingResultSet {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.84.101.66:1521:xe";
        String username = "hr";
        String password = "hr";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM REGIONS");

        // next method will return ur cursor to next line(row)
        // and also return true if you have more row and return false if there is no row anymore
        //rs.next();
        //System.out.println("Region value is at this row: " + rs.getString("REGION_NAME"));

        while (rs.next()) {
            System.out.println("Region id at this row is "+rs.getString("REGION_ID"));
            System.out.println("Region value is at this row: " + rs.getString("REGION_NAME"));
        }

        // create new ResultSet Object by running different quiry like
        // SELECT * FROM JOBS
        // you may reuse sam varibale

        rs = st.executeQuery("SELECT * FROM JOBS");

        // rs.getString OVERLOADED version
        // and you can use collumn index instead of column names
        while(rs.next()){
            // get job_id and job_title
            System.out.print(rs.getString(1));
            System.out.println("\t\t"+ rs.getString(2));
        }


    }
}