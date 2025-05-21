package com.atyeti;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
        JDBCConnection.connectDB();
    }
}
