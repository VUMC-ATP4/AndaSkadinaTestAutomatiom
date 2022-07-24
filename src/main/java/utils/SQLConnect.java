package utils;

import java.sql.*;

public class SQLConnect {
    public static Connection connect() throws SQLException {
        Connection conn = null;
        // db parameters
        String url = "jdbc:sqlite:C:\\Users\\User\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
        // create a connection to the database
        return conn = DriverManager.getConnection(url);
    }


    public static void main(String[] args) throws SQLException {
        Connection connection = connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Artist");
        while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("ArtistId"));
            System.out.print(", Name: " + rs.getString("Name"));
            System.out.println("\n");
        }
        Statement stmt1 = connection.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT MIN(t.Milliseconds),t.Composer from Track t");
        System.out.println("Shortest song COMPOSER IS: ");
        while(rs1.next()){
            System.out.print("ID: " + rs1.getString("Composer"));
        }

        connection.close();


    }


}
