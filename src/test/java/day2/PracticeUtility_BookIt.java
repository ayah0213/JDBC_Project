package day2;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class PracticeUtility_BookIt {

    public static void main(String[] args) {

        String url = ConfigurationReader.getProperty("bookit.database.url");
        String username=ConfigurationReader.getProperty("bookit.database.username");
        String password =ConfigurationReader.getProperty("bookit.database.password");
        DB_Utility.createConnection(url, username, password);


        DB_Utility.createConnection(url, username, password);
        DB_Utility.runQuery("SELECT * FROM ROOM");
        System.out.println("DB_Utility.getFirstRowFirstColumn() = " + DB_Utility.getFirstRowFirstColumn());
        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());
        DB_Utility.displayAllData();
        DB_Utility.destroy();

    }
}
