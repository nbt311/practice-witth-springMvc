package com.example.studentmanagerwithspringmvc.model;

import com.example.studentmanagerwithspringmvc.database.Database;
import com.example.studentmanagerwithspringmvc.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentDAO {
    protected Connection conn;

    public StudentModel() {
        Database database = Database.getInstance();
        this.conn = database.connection();
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                LocalDate dateOfBirth = rs.getDate(4).toLocalDate();
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classroom = rs.getString(7);
                Student student = new Student(id, name, email,dateOfBirth,address,phone,classroom);
                list.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return list;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                LocalDate dateOfBirth = rs.getDate(4).toLocalDate();
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classRoom = rs.getString(7);
                student = new Student(id,name,email,dateOfBirth,address,phone,classRoom);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return student;
    }
}
