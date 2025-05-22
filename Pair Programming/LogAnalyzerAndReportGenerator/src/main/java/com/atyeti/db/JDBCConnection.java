package com.atyeti.db;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Logger;

public class JDBCConnection {
    private static final Logger log=Logger.getLogger(JDBCConnection.class.getName());
    public static void connectDB(int info,int error,int warning) throws FileNotFoundException {
        String url = "jdbc:mysql://localhost:3306/log_analyzer";
        String username = "root";
        String password = "42379";
        String query = "Insert into log_summary(error_count, warning_count, info_count) values(?,?,?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(query);) {

            log.info("Connection Established successfully");
            con.setAutoCommit(true);

            st.setInt(1,error);
            st.setInt(2,warning);
            st.setInt(3,info);
            int k = st.executeUpdate();

        } catch (SQLException e) {
           log.warning("Database connection or query failed");
           throw new FileNotFoundException("File Not Found");
        }

        log.info("Connection Closed....");
    }
}