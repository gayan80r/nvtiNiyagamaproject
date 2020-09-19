package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.entity.RegistedStudent;
import com.vtan.salesapp.salesapp.entity.StudentParrent;
import com.vtan.salesapp.salesapp.service.ParrentService;
import com.vtan.salesapp.salesapp.service.RegisterStudentService;
import com.vtan.salesapp.salesapp.service.StudentParrentService;
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
public class StudentParrentController {
   @Autowired
   private StudentParrentService studentParrentService;
    @Autowired
    private ParrentService parrentService;
    @Autowired
    private RegisterStudentService registerStudentService;

    public String InitialLoad(ModelMap model) {
        List<Parrent> parrentList = parrentService.findAll();
        model.addAttribute("parrentList", parrentList);

        List<RegistedStudent> studentList = registerStudentService.findAll();
        model.addAttribute("studentList", studentList);


        return "StudentParrentRegistration";
    }
    @RequestMapping(value = {"/newstudentparrent"}, method = RequestMethod.GET)
    public String LoadStudentParrent(ModelMap model) {

        StudentParrent sp = new StudentParrent();
        model.addAttribute("studentParrent", sp);
        InitialLoad(model);
        return "StudentParrentRegistration";

    }

    @RequestMapping(value = {"/newstudentparrent"}, method = RequestMethod.POST)
    public String saveStudentBatch(@Valid StudentParrent studentParrent, ModelMap model,BindingResult bindingResult) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());
        List<StudentParrent> valsp = studentParrentService.finByStundentParrendId(studentParrent.getParrentId(), studentParrent.getStudentId());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valsp.size() > 0) {

            bindingResult.rejectValue("studentId","error.studentParrent",  "Parrent already registered to this student");
            // bindingResult.rejectValue("studentid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "StudentParrentRegistration";
        }

        studentParrent.setStatus(true);

        studentParrentService.save(studentParrent);
        List<StudentParrent> sParrentList = studentParrentService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("studentParrentList", sParrentList);

        return "StudentParrentView";


    }

    @RequestMapping(value = {"/studentparrent"}, method = RequestMethod.GET)
    public String LoadBatchStudentform(ModelMap model) {

        List<StudentParrent> sParrentList = studentParrentService.findByStatus(true);
        model.addAttribute("studentParrentList", sParrentList);

        return "StudentParrentView";
    }

    @RequestMapping(value = {"edit-studentParrent-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int stupatId = Integer.parseInt(id);

        StudentParrent stubatObj = studentParrentService.findById(stupatId);
        model.addAttribute("studentParrent", stubatObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "StudentParrentRegistration";
    }

    @RequestMapping(value = {"edit-studentParrent-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid StudentParrent studentParrent, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "StudentBatchRegistration";
        }

        studentParrent.setStatus(true);
        studentParrentService.save(studentParrent);
        // List<Employee> empList = employeeService.findAll();
        LoadBatchStudentform(model);
        /*List<Course> couList = courseService.findByStatus(true);
        model.addAttribute("courseList", couList);
        return "CourseView";*/

        return "StudentParrentView";
    }



}

