package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/employee";

        String username = "postgres";
        String password = "password";

        // Loading and registering the class, you can skip this step as well.
        Class.forName("org.postgresql.Driver");

        // But, this is a mandatory step, Establishing the connection.
        Connection conn = DriverManager.getConnection(url, username, password);

        System.out.println("Connection established");

        // Create statement
        String sql = "SELECT name FROM demo WHERE city = 'Ujjain'";
        Statement st = conn.createStatement();

        //Execute statement
        ResultSet rs = st.executeQuery(sql);

        // ResultSet provides a pointer to initial row even before the 1st row in a database.
        // So, in order to go to the 1st row, we have to call next() method.
        while(rs.next()) {
            String name = rs.getString("name");
            System.out.println("Hii, I am " + name);
        }

        // Close the connection
        conn.close();

        System.out.println("Connection closed.....");
    }
}