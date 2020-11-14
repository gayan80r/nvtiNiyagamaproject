package com.vtan.salesapp.salesapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.service.BatchService;
import com.vtan.salesapp.salesapp.service.CourseService;
import com.vtan.salesapp.salesapp.service.RegisterStudentService;
import com.vtan.salesapp.salesapp.service.StudentBatchService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value={"/api"},method = RequestMethod.GET)
public class RestDataController {
    @Autowired
    private StudentBatchService studentBatchService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private RegisterStudentService registerStudentService;
    @Autowired
    private CourseService courseService;

    private final SimpleDateFormat SDFormat= new SimpleDateFormat("MMMM dd, yyyy");

    @RequestMapping(value={"/retrivebatch/{batchid}"},method = RequestMethod.GET)
    public List<Batch> getBatch(@PathVariable("batchid") int batchid){
        //System.out.println("restapi");
        return  batchService.findByStatusAndyearId(1,batchid);
    }

    @RequestMapping(value={"/retrivestudent/{batchid}"},method = RequestMethod.GET)
    public List<RegistedStudent> getStudent( ){
        //System.out.println("restapi");
        return registerStudentService.findByStatus(1);
    }

    @RequestMapping(value={"/retrivebcstudent/{batchid}/{courseid}"},method = RequestMethod.GET)
    public List<Object> getBCStudent(@PathVariable("batchid") int batchid, @PathVariable("courseid") int courseid){
        List<RegistedStudent> students = registerStudentService.findByStatus(1).stream()
                .filter(student ->
                        student.getStudentBatchList().stream().
                                filter(batch -> batch.getBatchid().getId() == batchid && batch.getBatchid().getCourseid().getId() == courseid) != null).collect(Collectors.toList());

        JSONArray array=new JSONArray();
        students.forEach(student->{
            StudentBatch studentBatch = student.getStudentBatchList().stream().filter(batch -> batch.getBatchid().getId() == batchid && batch.getBatchid().getCourseid().getId() == courseid).findAny().orElse(null);
            if(studentBatch!=null) {
                JSONObject object = new JSONObject();
                object.put("name", student.getFirst_name() + " " + student.getLast_name());
                object.put("join", SDFormat.format(studentBatch.getDatejoint()));
                object.put("status", studentBatch.getBatchid().getStatus());
                array.put(object);
            }
        });

        return array.toList();
    }

    @RequestMapping(value={"/retrivecourse"},method = RequestMethod.GET)
    public List<Course> getCourse( ){
        //System.out.println("restapi");
        return courseService.findByStatus(1);
    }





}
