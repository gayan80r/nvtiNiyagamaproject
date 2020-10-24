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
public class RegisterStudentController {
    @Autowired
    private RegisterStudentService registerStudentService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private CivilStatusService civilStatusService;
    @Autowired
    private GSDivitionService gsDivitionService;
    @Autowired
    private DevitionalSecataryService devitionalSecataryService;
    @Autowired
    private YearService yearService;
   /* @Autowired
    private BatchService batchService;*/

    public String InitialLoad(ModelMap model) {

        List<Gender> genderList = genderService.findAll();
        model.addAttribute("genderList", genderList);

        List<CivilStatus> civilStatusList = civilStatusService.findAll();
        model.addAttribute("civilStatusList", civilStatusList);

        List<GSDivition> gsDivitionListList = gsDivitionService.findAll();
        model.addAttribute("gsDivitionListList", gsDivitionListList);

        List<DevitionalSecatary> devitionalSecataryListivitionList = devitionalSecataryService.findAll();
        model.addAttribute("devitionalSecataryListivitionList", devitionalSecataryListivitionList);

        List<Year> yearList = yearService.findAll();
        model.addAttribute("yearList", yearList);

        return "StudentRegistration";

    }
    @RequestMapping(value = {"/newstudent"}, method = RequestMethod.GET)
    // when we calling the LoadEmployee we passed the empty ModelMap
//controller class load UI EmployeeRegistration.jsp
//controler to ui

    public String Loadstudent(ModelMap model) {

        //we create the object empobj using employee entity class
        RegistedStudent stuobj = new RegistedStudent();
        model.addAttribute("Student", stuobj);
        InitialLoad(model);

        return "modules/student/StudentRegistration";
    }
        @RequestMapping(value = {"edit-registedStudent-{id}"}, method = RequestMethod.GET)
        public String loadUpdateForm(ModelMap model, @PathVariable String id) {

            int stuId = Integer.parseInt(id);

            RegistedStudent stuObj = registerStudentService.findById(stuId);
            model.addAttribute("Student", stuObj);
            InitialLoad(model);
            model.addAttribute("edit", true);
            return "modules/student/StudentRegistration";
        }
    @RequestMapping(value = {"edit-registedStudent-{id}"}, method = RequestMethod.POST)
    public String updateStudent(@Valid RegistedStudent registedStudent, ModelMap model, BindingResult bindingResult, @PathVariable String id) {


        // validation
        if (bindingResult.hasErrors()) {

            return "modules/student/StudentRegistration";
        }

        registedStudent.setStatus(1);
        registerStudentService.save(registedStudent);

        List<RegistedStudent> stuList = registerStudentService.findByStatus(1);
        model.addAttribute("studentList", stuList);
        return "modules/student/StudentView";
    }
    @RequestMapping(value = {"/newstudent"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String savestudent(@Valid RegistedStudent registedStudent, BindingResult bindingResult,
                               ModelMap model) {
        //validating whether the NIC is exists or not
        RegistedStudent valstu = registerStudentService.findByNic(registedStudent.getNic());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valstu != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("nic", "error.registedStudent",
                    "This nic already exists in the system");

        }

        RegistedStudent valEmail = registerStudentService.findByemail(registedStudent.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.registedStudent",
                    "This Email already exists in the system");

        }
        // validation
        if (bindingResult.hasErrors()) {
            return "modules/student/StudentRegistration";
        }

        //System.out.println(employee);
        //(Employee) convert the model object
        //Employee empobj=(Employee)model.getAttribute("employee");
        registedStudent.setStatus(1);

        registerStudentService.save(registedStudent);
        // After saving the employee object into the data base we want
        //List our employee
        //we assign the result of the employeeService.findAll() in to the emplist
        //it return the employee list
        //we  create the list emplist and assign the value of employeeService.findAll() into emplist
        //List<Employee> emplist=employeeService.findAll();
        List<RegistedStudent> stuList = registerStudentService.findByStatus(1);
        model.addAttribute("studentList", stuList);
        return "modules/student/StudentView";

    }

    @RequestMapping(value = {"delete-registedStudent-{id}"}, method = RequestMethod.GET)
    public String deleteStudent(RegistedStudent registedStudent, ModelMap model, @PathVariable String id) {


        int stuId = Integer.parseInt(id);

       RegistedStudent stuObj = registerStudentService.findById(stuId);
        stuObj.setStatus(0);

        registerStudentService.update(stuObj);

        //employeeService.delete(empObj);
        //List<Employee> empList = employeeService.findAll();
        List<RegistedStudent> stuList = registerStudentService.findByStatus(1);
        model.addAttribute("studentList", stuList);
        return "modules/student/StudentView";

    }
    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String ListStudentForm(ModelMap model) {
        //we use the java generic List<Employee>
        List<RegistedStudent> stuList = registerStudentService.findByStatus(1);
        model.addAttribute("studentList", stuList);
        return "modules/student/StudentView";
    }
}

