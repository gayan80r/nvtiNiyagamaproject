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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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







    @RequestMapping(value={"/retrivebatch/{batchid}"},method = RequestMethod.GET)
    public List<Batch> getBatch(@PathVariable("batchid") int batchid){
        //System.out.println("restapi");
        return  batchService.findByStatusAndyearId(1,batchid);
    }

    @RequestMapping(value={"/retrivestudent"},method = RequestMethod.GET)
    public List<RegistedStudent> getStudent( ){
        //System.out.println("restapi");
        return registerStudentService.findByStatus(1);
    }

    @RequestMapping(value={"/retrivecourse"},method = RequestMethod.GET)
    public List<Course> getCourse( ){
        //System.out.println("restapi");
        return courseService.findByStatus(1);
    }





}
