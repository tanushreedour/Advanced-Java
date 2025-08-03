package JDBC;
import java.sql.*;
import java.util.*;

public class Prepared_Statement {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/employee";
        String username = "postgres";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter city : ");
        String city = sc.nextLine();
        System.out.println("Enter age : ");
        int age = sc.nextInt();
        System.out.println("Enter unique ID: ");
        int id = sc.nextInt();

        String sql = "INSERT INTO demo values(?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);

        st.setString(1, name);
        st.setString(2, city);
        st.setInt(3, age);
        st.setInt(4, id);

        st.executeUpdate();

        Statement s = conn.createStatement();
        ResultSet res = s.executeQuery("SELECT * FROM DEMO");

        while(res.next())
        {
            System.out.println(res.getString(1) +", " + res.getString(2) + ", " + res.getInt(3) + ", " + res.getInt(4));
        }

        System.out.println("PreparedStatement executed!!!!");
    }
}
