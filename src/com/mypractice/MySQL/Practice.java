package com.mypractice.MySQL;

import java.sql.*;
import java.util.Random;

public class Practice {
    static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/practice";
    static final String ACCOUNT = "root";
    static final String PASSWORD = "";

    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, ACCOUNT, PASSWORD);

            Random random = new Random();
            stmt = conn.prepareStatement("INSERT INTO test (money, sex) VALUES (?, ?)");
            for (int i = 0; i < 9000000; i++) {
                stmt.setInt(1, random.nextInt(1000001));
                stmt.setInt(2, random.nextInt(2));
                stmt.execute();
                System.out.println("record " + i + 0 + "done");
            }
            System.out.println("all done!");

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

}
