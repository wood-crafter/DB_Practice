/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Todo;
import dbConnect.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class TodoModel {
    public ArrayList<Todo> readAll() throws SQLException, Exception {
        Todo ToDoInfor = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Todo> students = new ArrayList<Todo>();

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [ToDo]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String titles = rs.getString("Titles");
                Date date = rs.getDate("Deadline");
                boolean isDone = rs.getBoolean("IsDone");
                
                ToDoInfor = new Todo(titles, date, isDone);
                students.add(ToDoInfor);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return students;
    }
    
    public ArrayList<Todo> readAllToDo() throws SQLException, Exception {
        Todo ToDoInfor = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Todo> students = new ArrayList<Todo>();

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [ToDo] WHERE IsDone = 0");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String titles = rs.getString("Titles");
                Date date = rs.getDate("Deadline");
                boolean isDone = rs.getBoolean("IsDone");
                
                ToDoInfor = new Todo(titles, date, isDone);
                students.add(ToDoInfor);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return students;
    }
    
    public ArrayList<Todo> readAllDone() throws SQLException, Exception {
        Todo ToDoInfor = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Todo> students = new ArrayList<Todo>();

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [ToDo] WHERE IsDone = 1");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String titles = rs.getString("Titles");
                Date date = rs.getDate("Deadline");
                boolean isDone = rs.getBoolean("IsDone");
                
                ToDoInfor = new Todo(titles, date, isDone);
                students.add(ToDoInfor);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return students;
    }
//    public StudentInfor read(String studenttId) throws SQLException, Exception {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        StudentInfor studentInfor = null;
//
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement("SELECT * FROM [StudenInfor] WHERE ID = ?");
//            ps.setString(1, studenttId);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String name = rs.getString("Name");
//                boolean isMale = rs.getBoolean("IsMale");
//                int departID = rs.getInt("DepartID");
//                float GPA = rs.getFloat("GPA");
//                String address = rs.getString("Address");
//                String ID = rs.getString("ID");
//                
//                studentInfor = new StudentInfor(name, isMale, departID, GPA, address, ID);
//            }
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//        }
//
//        return studentInfor;
//    }
//    
    public void insert(Todo toDo) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO ToDo (Id, Titles, Deadline, IsDone) VALUES (?, ?, ?, ?);");
            ps.setInt(1, 9); 
            ps.setString(2, toDo.getTitles());
            ps.setDate(3, new java.sql.Date(toDo.getDeadline().getTime()));
            ps.setBoolean(4, toDo.getIsDone());
            
            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }
//    
    public void delete(String titles) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("DELETE FROM [ToDo] WHERE Titles = ?;");        
            ps.setString(1, titles);
            
            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }
//    
//    public void update(StudentInfor studentInfor) throws Exception{
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement("UPDATE [StudenInfor] SET Name = ?, IsMale = ?, DepartID = ?, GPA = ?, Address = ? WHERE ID = ?;");
//            ps.setString(1, studentInfor.getName());
//            ps.setBoolean(2, studentInfor.getGender());
//            ps.setInt(3, studentInfor.getDepartID());
//            ps.setFloat(4, studentInfor.getGPA());
//            ps.setString(5, studentInfor.getAddress());
//            ps.setString(6, studentInfor.getID());
//            
//            ps.execute();
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//        }
//    }
}
