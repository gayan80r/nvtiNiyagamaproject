package com.vtan.salesapp.salesapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.service.BatchService;
import com.vtan.salesapp.salesapp.service.StudentBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestDataController {
    @Autowired
    private StudentBatchService studentBatchService;
    @Autowired
    private BatchService batchService;

    @RequestMapping(value={"/retrivestudent"},method = RequestMethod.GET)
    public List<StudentBatch> getStudentByName(@RequestParam("json") String requestJSON){
        List <StudentBatch> studentList=new ArrayList<>();

        try{

            ObjectMapper mapper = new ObjectMapper();
            String[]  values= mapper.readValue(requestJSON, String[].class);
            String vall=values[0];
            Batch batch = batchService.findById(Integer.parseInt(vall));
            studentList=studentBatchService.finByStundent(batch);

        }

        catch (Exception e){

        }
        return  studentList;
    }
}