package day2;

import utility.ConfigurationReader;
import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRun {


    public static void main(String[] args) throws SQLException {

          // 1st method
       // DB_Utility.createConnection();


        // 2nd method usame way but overloaded using parametrz.
        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");
        DB_Utility.createConnection(url, username, password);


        // 3rd calling RUN Quiery method
        ResultSet result  =DB_Utility.runQuery("SELECT * FROM REGIONS");
        result.next();
        System.out.println("Region name is "+result.getString("REGION_NAME"));


        // 5th get RowCount
        int totalRow = DB_Utility.getRowCount();
        System.out.println("totalRow = "+totalRow);


        // 6th method get column Count
        int totalColumnCount = DB_Utility.getColumnCount();
        System.out.println("total column count "+totalColumnCount);


        // 7 method column name list method
        System.out.println("DB_Utility.getAllColumnNamesAsList() = " + DB_Utility.getAllColumnNamesAsList());

        
        // 8th method get row data as List according to row number
        System.out.println("DB_Utility.getRowDataAsList(3) = " + DB_Utility.getRowDataAsList(3));


        // 9th method get specific cell value
        System.out.println("DB_Utility.getCEllValue(3,2) = " + DB_Utility.getCEllValue(3,2));

         // 10th Method
        System.out.println("DB_Utility.getCEllValue(3,\"REGION_NAME\") = " + DB_Utility.getCEllValue(3,"REGION_NAME"));


        
        // 11 th method
        System.out.println("DB_Utility.getColumnDataAsList(2) = " + DB_Utility.getColumnDataAsList(2));


        // 12th method
        System.out.println("DB_Utility.getColumnDataAsList(\"REGION_NAME\") = " + DB_Utility.getColumnDataAsList("REGION_NAME"));


        // 13 th method  printing all data
        DB_Utility.displayAllData();


        // 15th Method get data as MAp key & value
        System.out.println("DB_Utility.getRowMap(3) = " + DB_Utility.getRowMap(3));

        
        // 16 method all row as list of MAp
        System.out.println("DB_Utility.getRowMapAsListOfMap() = " + DB_Utility.getRowMapAsListOfMap());


        // 4 Method destroy=close
        DB_Utility.destroy();






    }



}
