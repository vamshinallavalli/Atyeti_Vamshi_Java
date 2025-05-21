package com.atyeti;

import java.sql.*;
import java.util.logging.Logger;

public class JDBCConnection {
    private static final Logger log=Logger.getLogger(JDBCConnection.class.getName());
    public static void connectDB() {
        String url = "jdbc:mysql://localhost:3306/log_analyzer";
        String username = "root";
        String password = "42379";
        String query = "SELECT * FROM log_summary";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(query);) {

            log.info("Connection Established successfully");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("");
            }

        } catch (SQLException e) {
            log.warning("Database connection or query failed");
        }

        log.info("Connection Closed....");
    }
}
