package it.develhope.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "524013659?Ln");
            statement = connection.createStatement();
            String query = "SELECT * FROM students";
            statement.executeQuery(query);
            List<String> surnames = null;

            if (statement.execute(query)) {
                resultSet = statement.getResultSet();
                surnames = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    System.out.println(name);
                    surnames.add(surname);
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println(surnames);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

}
