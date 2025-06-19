package com.atyeti.service;

import com.atyeti.dbConfig.DBConnection;
import com.atyeti.dbConfig.DbQueries;
import com.atyeti.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class StudentService {
    public static Logger logger=Logger.getLogger(StudentService.class.getName());
    public static void login(int id, String password) throws SQLException {
        Connection connection=DBConnection.connectDB();
        PreparedStatement statement= connection.prepareStatement(DbQueries.LOGIN);
        statement.setInt(1,id);
        statement.setString(2,password);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            System.out.println("Welcome, " + rs.getString("name"));
        } else {
            System.out.println("Invalid ID or Password.");
        }

    }

    public static void register(Student student) throws SQLException {

        Connection connection=DBConnection.connectDB();
        PreparedStatement statement= connection.prepareStatement(DbQueries.REGISTER);

       statement.setString(1,student.getStudentName());
       statement.setString(2,student.getGmail());
       statement.setString(3,student.getPassword());


       if(statement.execute()){
          logger.info("Student Registered Successfully!");
       }
    }
}
