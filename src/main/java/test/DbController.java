package test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DbController {
    
    @Autowired
    private DbService dbService;
    @RequestMapping(value="/insert" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String insert(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        Student stu = ob.readValue(emp, Student.class);
        String r = dbService.insertStudent(stu);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);

    }

    @RequestMapping(value="/update" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String updateStudent(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        Student stu = ob.readValue(emp, Student.class);
        String r = dbService.updateStudent(stu);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);
    }
    
    @RequestMapping(value="/delete" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String delete(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        Student stu = ob.readValue(emp, Student.class);
        String r = dbService.deleteStudent(stu);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);
    }
    
    @RequestMapping(value="/insertBatch" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String insertStudentBatch(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {};
        List<Student> list = ob.readValue(emp, mapType);
        String r = dbService.insertStudentBatch(list);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);

    }

    @RequestMapping(value="/updateBatch" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String updateStudentBatch(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {};
        List<Student> list = ob.readValue(emp, mapType);
        String r = dbService.updateStudentBatch(list);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);
    }
    
    @RequestMapping(value="/deleteBatch" , headers = {
    "content-type=application/json" },method = RequestMethod.POST)
    public String deleteStudentBatch(@RequestBody String emp) throws Exception{
        long s = System.currentTimeMillis();
        ObjectMapper ob = new ObjectMapper();
        TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {};
        List<Student> list = ob.readValue(emp, mapType);
        String r = dbService.deleteStudentBatch(list);
        long e = System.currentTimeMillis();
        return r+" and time taken (in millis): "+(e-s);
    }

    @RequestMapping(value="/select" ,method = RequestMethod.GET)
    public List<Student> select(@RequestParam("count") int count) throws Exception{

        long s=System.currentTimeMillis();
        List<Student> list =  dbService.selectStudent(count);
        long e = System.currentTimeMillis();
        System.out.println("Time taken (in millis): "+(e-s));
        return list;
    }
    
}
