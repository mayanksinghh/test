package test;

import java.sql.SQLException;
import java.util.List;

public interface DbService {
    
	String insertStudent(Student e) throws Exception;

    String updateStudent(Student e) throws Exception;
    
    String deleteStudent(Student e) throws Exception;
    
    String insertStudentBatch(List<Student> list) throws Exception; 
    
    String updateStudentBatch(List<Student> list) throws Exception;
    
    String deleteStudentBatch(List<Student> e) throws Exception;
    
    List<Student> selectStudent(int count) throws Exception;
}

