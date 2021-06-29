package day3;


import org.junit.Test;
import utility.ConfigurationReader;
import utility.DB_Utility;

import static org.junit.Assert.*;

public class SimpleTest {



/*
Assumin that we captured UI dashboard numbers from library1 app
 Now we want to make sure that thsoe numbers are match the database data
 */

    @Test
    public void testDashboard() {

        int userCountUI = 8588;
        int bookCountUI = 2036;
        int borrowedBookCountUI = 754;


        String url = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);


        DB_Utility.runQuery("SELECT count(*) FROM books");

        String bookCountDBStr = DB_Utility.getFirstRowFirstColumn();
        int bookCountDBInt = Integer.parseInt(bookCountDBStr); // we parsed it to make convert into INTEGER

        assertEquals(bookCountDBInt, bookCountUI);


        DB_Utility.runQuery("SELECT COUNT(*) FROM users");
        int userCountDB = Integer.parseInt(DB_Utility.getFirstRowFirstColumn());
        assertEquals(userCountDB, userCountUI);


        DB_Utility.runQuery("SELECT count(*) from book_borrow " +
                "where returned_date is null");
       int borrowedBookCountDb = Integer.parseInt(DB_Utility.getFirstRowFirstColumn());
       assertEquals(borrowedBookCountDb, borrowedBookCountUI);

        DB_Utility.destroy();

    }


}





