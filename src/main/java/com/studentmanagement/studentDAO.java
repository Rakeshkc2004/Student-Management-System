package com.studentmanagement;

import java.sql.*;

public class studentDAO {

    // Add student
    public void addStudent(Student student) {




        String sql = "INSERT INTO students " +
                "(name, age, course, email) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all students
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course") + " | " +
                                rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search student
    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getInt("age") + " | " +
                                    rs.getString("course") + " | " +
                                    rs.getString("email")
                    );
                } else {
                    System.out.println("Student not found.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update student
    public void updateStudent(int id, String name,
                              int age, String course,
                              String email) {

        String sql = "UPDATE students SET name=?, age=?, " +
                "course=?, email=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            System.out.println(rows > 0
                    ? "Student updated successfully!"
                    : "Student not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println(rows > 0
                    ? "Student deleted successfully!"
                    : "Student not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}