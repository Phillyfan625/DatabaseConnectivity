/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;
/**
 *
 * @author Test
 */
public class SQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     
        try {
            // setting up database connection
             //   Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");
                
                Statement stmt = dbConnection.createStatement();
        String testQuery = "SELECT * FROM CUSTOMER";
        ResultSet results;
        results = stmt.executeQuery(testQuery);

        // processing results
        while (results.next()) {
           System.out.println("Result: " + results.getString("NAME"));
        }
        
           // clean up
            results.close();
            stmt.close();
            dbConnection.close();
                 
            } catch (SQLException e) {
                    System.out.println("Cannot connect to database.\n" + e.getMessage());
            }
      
       

       



        

        
    }
    
}
