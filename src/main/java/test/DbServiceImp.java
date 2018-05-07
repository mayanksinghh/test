package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DbServiceImp implements DbService{


    String dbURL = "jdbc:mysql://35.200.139.190:3306/sampledb";
    String username = "testuser";
    String password = "mayank";

    public String insertStudent(Student e) throws Exception {
        String q = "insert into student values(?,?,?,?,?,?,?) on duplicate key update first_name=?,last_name=?,age=?,percent=?,phone_no=?,class=?;";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        statement.setInt(1, e.getRollNo());
        statement.setString(2, e.getFirstName());
        statement.setString(3,e.getLastName());
        statement.setInt(4,e.getAge());
        statement.setInt(5,e.getPercentage());
        statement.setString(6, e.getPhoneNumber());
        statement.setInt(7, e.getKlass());
        statement.setString(8, e.getFirstName());
        statement.setString(9,e.getLastName());
        statement.setInt(10,e.getAge());
        statement.setInt(11,e.getPercentage());
        statement.setString(12, e.getPhoneNumber());
        statement.setInt(13, e.getKlass());
        int rowsUpdated = statement.executeUpdate();

        return "No. of rows inserted: "+rowsUpdated;
    }

    public String updateStudent(Student e) throws Exception {
        String q = "update student set first_name=?,last_name=?,age=?,percent=?,phone_no=?,class=? where roll_no= ?;" ;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        statement.setString(1, e.getFirstName());
        statement.setString(2,e.getLastName());
        statement.setInt(3,e.getAge());
        statement.setInt(4,e.getPercentage());
        statement.setString(5, e.getPhoneNumber());
        statement.setInt(6, e.getKlass());
        statement.setInt(7, e.getRollNo());
        int rowsUpdated = statement.executeUpdate();
        return "No. of rows updated: "+rowsUpdated;
    }

    public String deleteStudent(Student e) throws Exception {
        String q = "delete from student where roll_no= ?;" ;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        
        statement.setInt(1, e.getRollNo());
        int rowsUpdated = statement.executeUpdate();
        return "No. of rows deleted: "+rowsUpdated;
    }
    
    public String insertStudentBatch(List<Student> list) throws Exception {
        String q = "insert into student values(?,?,?,?,?,?,?) on duplicate key update first_name=?,last_name=?,age=?,percent=?,phone_no=?,class=?;";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        for(int i=0;i<list.size();i++){
            Student e = list.get(i);
            statement.setInt(1, e.getRollNo());
            statement.setString(2, e.getFirstName());
            statement.setString(3,e.getLastName());
            statement.setInt(4,e.getAge());
            statement.setInt(5,e.getPercentage());
            statement.setString(6, e.getPhoneNumber());
            statement.setInt(7, e.getKlass());
            statement.setString(8, e.getFirstName());
            statement.setString(9,e.getLastName());
            statement.setInt(10,e.getAge());
            statement.setInt(11,e.getPercentage());
            statement.setString(12, e.getPhoneNumber());
            statement.setInt(13, e.getKlass());
            statement.addBatch();
            
        }
        int[] affectedRecords = statement.executeBatch();
        return "No. of rows updated: "+affectedRecords.toString();
    }
    
    
    public String updateStudentBatch(List<Student> list) throws Exception {
        String q = "update student set first_name=?,last_name=?,age=?,percent=?,phone_no=?,class=? where roll_no= ?;" ;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        for(int i=0;i<list.size();i++){
            Student e = list.get(i);
            statement.setString(1, e.getFirstName());
            statement.setString(2,e.getLastName());
            statement.setInt(3,e.getAge());
            statement.setInt(4,e.getPercentage());
            statement.setString(5, e.getPhoneNumber());
            statement.setInt(6, e.getKlass());
            statement.setInt(7, e.getRollNo());
            statement.addBatch();
            
        }
        int[] affectedRecords = statement.executeBatch();
        return "No. of rows updated: "+affectedRecords;
    }

    public String deleteStudentBatch(List<Student> list) throws Exception {
        String q = "delete from student where roll_no= ?;" ;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        for(int i=0;i<list.size();i++){
            Student e = list.get(i);
            statement.setInt(1, e.getRollNo());
            statement.addBatch();
            
        }
        int[] rowsUpdated = statement.executeBatch();
        return "No. of rows deleted: "+rowsUpdated;
    }
    
    public List<Student> selectStudent(int count) throws Exception {
        String q = "select * from student limit "+count+";";
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        Connection conn= (Connection) DriverManager.getConnection(dbURL, username, password);


        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
        ResultSet resultSet = statement.executeQuery();
        List<Student> sl = new ArrayList<Student>();
        while (resultSet.next()){
            Student student = new Student();
            student.setRollNo(resultSet.getInt(1));
            student.setFirstName(resultSet.getString(2));
            student.setLastName(resultSet.getString(3));
            student.setAge(resultSet.getInt(4));
            student.setPercentage(resultSet.getInt(5));
            student.setPhoneNumber(resultSet.getString(6));
            student.setKlass(resultSet.getInt(7));
            sl.add(student);
        }

        return sl;
    }
}