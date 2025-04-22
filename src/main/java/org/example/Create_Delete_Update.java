package org.example;

// 1. Importing libraries
import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class Create_Delete_Update {
    public static void main(String[] args) throws Exception{

        // 2. Load and register class
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/employee";
        String username = "postgres";
        String password = "password";

        // 3.Creating connection
        Connection conn = DriverManager.getConnection(url, username, password);

        // 4.Creating statement
        Statement st = conn.createStatement();

        // 5.Exceute query
        String sql = "INSERT INTO demo VALUES ('Anuradha', 'Sagar', 21, 120)";
        st.execute(sql);

        // UPDATE operation
        String update_query = "UPDATE demo SET name='Nammo' WHERE num=60";

        Statement st2 = conn.createStatement();
        st2.execute(update_query);

        // Delete query
        String delete_query = "DELETE FROM demo WHERE (num=120 or name='Nammo')";

        // Checking if the update got made or not
        getData(st, delete_query, conn);

        // 6.Close connection
        conn.close();
    }

    public static void getData(Statement st, String sql, Connection conn) throws SQLException {
        ResultSet res = st.executeQuery("SELECT * FROM demo");

        while(res.next())
        {
            System.out.println(res.getString(1)+ " - "+ res.getString(2) + " - "+ res.getInt(3) + " - "+ res.getInt(4));
        }
    }
}
