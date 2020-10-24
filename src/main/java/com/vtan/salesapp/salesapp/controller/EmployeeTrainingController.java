package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
import com.vtan.salesapp.salesapp.service.EmployeeService;
import com.vtan.salesapp.salesapp.service.EmployeeTrainingDetailsService;
import com.vtan.salesapp.salesapp.service.EmployeeTrainingService;
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
public class EmployeeTrainingController {
    @Autowired
    private EmployeeTrainingDetailsService employeeTrainingDetailsService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeTrainingService employeeTrainingService;

    public String InitialLoad(ModelMap model) {
        List<Employee> empList = employeeService.findAll();
        model.addAttribute("empList", empList);

        List<EmployeeTraining> trainingList = employeeTrainingService.findAll();
        model.addAttribute("trainingList", trainingList);


        return "EmployeeTrainingRegistration";
    }

    @RequestMapping(value = {"/newemployeetraining"}, method = RequestMethod.GET)
    public String LoadEmployeeTrainning(ModelMap model) {
        EmployeeTrainingDetails etd = new EmployeeTrainingDetails();
        model.addAttribute("employeeTrainingDetails", etd);
        InitialLoad(model);
        return "modules/employee/employeetraning/EmployeeTrainingRegistration";

    }

    @RequestMapping(value = {"/newemployeetraining"}, method = RequestMethod.POST)
    public String saveEmployeeTraining(@Valid EmployeeTrainingDetails employeeTrainingDetails, ModelMap model, BindingResult bindingResult) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());
        List<EmployeeTrainingDetails> valinstra = employeeTrainingDetailsService.findByEmployeeTrainingId(employeeTrainingDetails.getEmpid(), employeeTrainingDetails.getEmptraid());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valinstra.size() > 0) {

            bindingResult.rejectValue("emptraid","error.employeeTrainingDetails",  "Instructor already registered to this training");
            // bindingResult.rejectValue("emptraid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "modules/employee/employeetraning/EmployeeTrainingRegistration";
        }
        //employeeTriningDetails
        employeeTrainingDetails.setStatus(true);

        employeeTrainingDetailsService.save(employeeTrainingDetails);
        List<EmployeeTrainingDetails> insTrainigList = employeeTrainingDetailsService.findByStatus(true);
         model.addAttribute("employeeTrainningList", insTrainigList);

        return "modules/employee/employeetraning/EmployeeTrainingView";


    }

    @RequestMapping(value = {"/employeetraining"}, method = RequestMethod.GET)
    public String LoadEmployeeTrainningform(ModelMap model) {


        List<EmployeeTrainingDetails> insTrainigList = employeeTrainingDetailsService.findByStatus(true);
        model.addAttribute("employeeTrainningList", insTrainigList);

        return "modules/employee/employeetraning/EmployeeTrainingView";
    }

    @RequestMapping(value = {"edit-employeetrainning-{id}"}, method = RequestMethod.GET)
    public String loadUpdateEmployeeTrainningForm(ModelMap model, @PathVariable String id) {

        int insEmployeeId = Integer.parseInt(id);

        EmployeeTrainingDetails insTrainObj = employeeTrainingDetailsService.findById(insEmployeeId);
        //model.addAttribute("studentBatch", insTrainObj);
        model.addAttribute("employeeTrainingDetails", insTrainObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "modules/employee/employeetraning/EmployeeTrainingRegistration";
    }

    @RequestMapping(value = {"edit-employeetrainning-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid EmployeeTrainingDetails employeeTrainingDetails, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "modules/employee/employeetraning/EmployeeTrainingRegistration";
        }

        employeeTrainingDetails.setStatus(true);
        employeeTrainingDetailsService.save(employeeTrainingDetails);
        // List<Employee> empList = employeeService.findAll();
        LoadEmployeeTrainningform(model);


        return "modules/employee/employeetraning/EmployeeTrainingView";
    }
}
