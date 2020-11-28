package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
import com.vtan.salesapp.salesapp.service.BatchService;
import com.vtan.salesapp.salesapp.service.CourseService;
import com.vtan.salesapp.salesapp.service.RegisterStudentService;
import com.vtan.salesapp.salesapp.service.StudentBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
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

    private final SimpleDateFormat SDFormat= new SimpleDateFormat("MMMM dd, yyyy");

    @RequestMapping(value={"/retrivebatch/{yearid}"},method = RequestMethod.GET)
    public List<Batch> getBatch(@PathVariable("yearid") int yearid){
        //System.out.println("restapi");
        return  batchService.findByStatusAndyearId(1, yearid);
    }

    @RequestMapping(value={"/retriveyearandcoursebatch/{yearid}/{courseid}"},method = RequestMethod.GET)
    public List<Batch> getYearAndCourseBatch(@PathVariable("yearid") int yearid, @PathVariable("courseid") int courseid){
        //System.out.println("restapi");
        if(yearid!=0 && courseid!=0) {
            return batchService.findByYearAndCourseId(yearid, courseid);
        }else{
            return null;
        }
    }

    @RequestMapping(value={"/retrivestudent"},method = RequestMethod.GET)
    public List<RegistedStudent> getStudent( ){
        //System.out.println("restapi");
        return registerStudentService.findByStatus(1);
    }

    @RequestMapping(value={"/retrivebcstudent/{batchid}/{courseid}"},method = RequestMethod.GET)
    public List<StudentBatchCourse> getBCStudent(@PathVariable("batchid") int batchid, @PathVariable("courseid") int courseid){
        if(batchid!=0 && courseid!=0) {
            return studentBatchService.finByStundentBatchIdCourseId(batchService.findById(batchid), courseService.findById(courseid));
        }else{
            return null;
        }
    }

    @RequestMapping(value={"/retrivecourse"},method = RequestMethod.GET)
    public List<Course> getCourse( ){
        //System.out.println("restapi");
        return courseService.findByStatus(1);
    }





}
