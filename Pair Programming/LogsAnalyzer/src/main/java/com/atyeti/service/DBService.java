package com.atyeti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBService {

    public static Connection connection;

    private static final Logger logger=Logger.getLogger(DBService.class.getName());

    public void createConnection(String url,String name,String password){
        try {
            connection= DriverManager.getConnection(url,name,password);
            logger.info("Connection Established!");
        } catch (SQLException e) {
            logger.warning("Unable to Establish the Connection!");
            throw new RuntimeException(e);
        }
    }

    public void executeUserQuery(String query) throws SQLException {
        PreparedStatement statement= connection.prepareStatement(query);
        statement.executeUpdate();
        logger.info("Statement Executed!");
    }
}
