package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
import com.vtan.salesapp.salesapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InstructorBatchController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private InstructorBatchService instructorBatchService;


    public String InitialLoad(ModelMap model) {
        List<Batch> batchList = batchService.findAll();
        model.addAttribute("batchList", batchList);

        List<Employee> emptList = employeeService.findAll();
        model.addAttribute("emptList", emptList);


        return "InstructorBatchRegistration";
    }

    @RequestMapping(value = {"/newbatchinstructor"}, method = RequestMethod.GET)
    public String LoadStudentBatch(ModelMap model) {
        InstructorBatch ib = new InstructorBatch();
        model.addAttribute("instructorBatch", ib);
        InitialLoad(model);
        return "InstructorBatchRegistration";

    }

    @RequestMapping(value = {"/newbatchinstructor"}, method = RequestMethod.POST)
    public String saveStudentBatch(@Valid InstructorBatch instructorBatch, ModelMap model, BindingResult bindingResult) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());
       // List<StudentBatch> valsb = studentBatchService.finByStundentBatchId(studentbatch.getBatchid(), studentbatch.getStudentid());
        List<InstructorBatch> valib = instructorBatchService.finByInstructortBatchId(instructorBatch.getBatchid(), instructorBatch.getEmployeid());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valib.size() > 0) {

            bindingResult.rejectValue("employeid","error.instructorBatch",  "Instructor already registered to this batch");
            // bindingResult.rejectValue("studentid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "InstructorBatchRegistration";
        }
        //instructorBatch.
        instructorBatch.setStatus(true);
        instructorBatchService.save(instructorBatch);
        List<InstructorBatch> iBatchList = instructorBatchService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("instructorBatchList",iBatchList);

        return "InstructorBatchView";


    }

    @RequestMapping(value = {"/batchinstructor"}, method = RequestMethod.GET)
    public String LoadBatchStudentform(ModelMap model) {

        List<InstructorBatch> iBatchList = instructorBatchService.findByStatus(true);
        model.addAttribute("instructorBatchList", iBatchList);
        return "InstructorBatchView";
    }

    @RequestMapping(value = {"edit-instructorbatch-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int insbatId = Integer.parseInt(id);

        InstructorBatch insbatObj = instructorBatchService.findById(insbatId);
        model.addAttribute("instructorBatch", insbatObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "InstructorBatchRegistration";
    }

    @RequestMapping(value = {"edit-instructorBatch-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid InstructorBatch instructorBatch, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "InstructorBatchRegistration";
        }

        instructorBatch.setStatus(true);
        instructorBatchService.save(instructorBatch);
        List<InstructorBatch> iBatchList = instructorBatchService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("instructorBatchList",iBatchList);

        return "InstructorBatchView";
    }
}
