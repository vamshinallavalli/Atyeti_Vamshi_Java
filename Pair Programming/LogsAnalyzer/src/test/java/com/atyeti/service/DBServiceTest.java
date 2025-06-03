package com.atyeti.service;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DBServiceTest {
    DBService dbService = new DBService();

    @Test
    void testCreateConnection() {
        assertDoesNotThrow(() ->
                        dbService.createConnection("jdbc:mysql://localhost:3306/log_analyzer", "root", "42379"),
                "database method should not throw any exception"
        );
    }

    @Test
    void testExecuteUserQuery() throws SQLException {
        dbService.createConnection("jdbc:mysql://localhost:3306/log_analyzer", "root", "42379");

        String query = "INSERT INTO log_summary(error_count, warning_count, info_count) VALUES (0, 0, 0)";

        assertDoesNotThrow(() -> dbService.executeUserQuery(query));
    }
}
