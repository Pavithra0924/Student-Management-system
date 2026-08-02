package studentmanagement.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import studentmanagement.model.Student;

public class StudentDAO {

    public void addStudent(Student student) {

        try {
            Connection con = DBconnection.getConnection();

            String query = "INSERT INTO student(name, department, email, phone) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        }
        catch (java.sql.SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Email already exists!");
        }
        catch (Exception e) {
            e.printStackTrace();
        
        }
    }
    
    public void viewStudents() {

        try {
            Connection con = DBconnection.getConnection();

            String query = "SELECT * FROM student";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-25s %-15s%n",
                    "ID", "NAME", "DEPARTMENT", "EMAIL", "PHONE");
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) {

            	System.out.printf("%-5d %-15s %-15s %-25s %-15s%n",
            	        rs.getInt("id"),
            	        rs.getString("name"),
            	        rs.getString("department"),
            	        rs.getString("email"),
            	        rs.getString("phone"));
            }
            System.out.println("--------------------------------------------------------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudentEmail(int id, String email) {

        try {
            Connection con = DBconnection.getConnection();

            String query = "UPDATE student SET email=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student Updated Successfully!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int id) {

        try {
            Connection con = DBconnection.getConnection();

            String sql = "DELETE FROM student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Student searchStudent(int id) {

        Student student = null;

        try {
            Connection con = DBconnection.getConnection();

            String sql = "SELECT * FROM student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }
    
    public Student searchStudentByName(String name) {

        Student student = null;

        try {
            Connection con = DBconnection.getConnection();

            String query = "SELECT * FROM student WHERE name = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }
    
    public void updateStudent(Student student) {

        try {
            Connection con = DBconnection.getConnection();

            String sql = "UPDATE student SET name=?, department=?, email=?, phone=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}