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
public class StudentBatchController {
    @Autowired
    private StudentBatchService studentBatchService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private RegisterStudentService registerStudentService;
    @Autowired
    private YearService yearService;
    @Autowired
    private CourseService courseService;
   /* @Autowired
    private StudentBatch studentBatch;*/

    public String InitialLoad(ModelMap model) {
        List<Year> yearlist=yearService.findAll();
        model.addAttribute("yearList",yearlist);

        List<Course> courselist=courseService.findAll();
        model.addAttribute("courselist",courselist);

        List<Batch> batchList = batchService.findAll();
        model.addAttribute("batchList", batchList);

        List<RegistedStudent> studentList = registerStudentService.findAll();
        model.addAttribute("studentList", studentList);


        return "StudentBatchRegistration";
    }

    @RequestMapping(value = {"/newbatchstudent"}, method = RequestMethod.GET)
    public String LoadStudentBatch(ModelMap model) {
        StudentBatch sb = new StudentBatch();
        model.addAttribute("studentBatch", sb);
        InitialLoad(model);
        return "modules/student/StudentBatchRegistration";

    }

    @RequestMapping(value = {"/newbatchstudent"}, method = RequestMethod.POST)
    public String saveStudentBatch(@Valid StudentBatch studentbatch, ModelMap model,BindingResult bindingResult) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());
        List<StudentBatch> valsb = studentBatchService.finByStundentBatchId(studentbatch.getBatchid(), studentbatch.getStudentid());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valsb.size() > 0) {

            bindingResult.rejectValue("studentid","error.studentbatch",  "Student already registered to this batch");
                   // bindingResult.rejectValue("studentid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "modules/student/StudentBatchRegistration";
        }

        studentbatch.setStatus(true);
        studentBatchService.save(studentbatch);
       List<StudentBatch> sBatchList = studentBatchService.findByStatus(true);
       // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("studentBatchList", sBatchList);

        return "modules/student/StudentBatchView";


    }

    @RequestMapping(value = {"/batchstudent"}, method = RequestMethod.GET)
    public String LoadBatchStudentform(ModelMap model) {
        StudentBatch sb = new StudentBatch();
        List<StudentBatch> sBatchList = studentBatchService.findByStatus(true);
        model.addAttribute("studentBatchList", sBatchList);
        model.addAttribute("studentBatch", sb);
        InitialLoad(model);
        return "modules/student/StudentBatchView";
    }

    @RequestMapping(value = {"edit-studentbatch-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {
        int stubatId = Integer.parseInt(id);

        StudentBatch stubatObj = studentBatchService.findById(stubatId);
        model.addAttribute("studentBatch", stubatObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        model.addAttribute("batchID", stubatObj.getBatchid().getId());
        return "modules/student/StudentBatchRegistration";
    }

    @RequestMapping(value = {"edit-studentbatch-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid StudentBatch studentbatch, ModelMap model, BindingResult bindingResult, @PathVariable String id) {
        if (bindingResult.hasErrors()) {

            return "modules/student/StudentBatchRegistration";
        }

        StudentBatch stubatObj = studentBatchService.findById(Integer.parseInt(id));
        stubatObj.setBatchid(studentbatch.getBatchid());
        stubatObj.setStatus(true);
        studentBatchService.update(stubatObj);
        LoadBatchStudentform(model);

        return "modules/student/StudentBatchView";
    }

    @RequestMapping(value = {"detele-studentbatch-{id}"}, method = RequestMethod.GET)
    public String deleteStudentBatch(ModelMap model, @PathVariable String id){

        int stubatId = Integer.parseInt(id);

        StudentBatch stubatObj = studentBatchService.findById(stubatId);
        stubatObj.setStatus(false);
        studentBatchService.update(stubatObj);
        LoadBatchStudentform(model);
        return "modules/student/StudentBatchView";
    }

}
