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
public class EmployeeController {
    @Autowired
    //we can not directly create the object of the EmployeeService
    //we use the DI
    private EmployeeService employeeService;

    @Autowired
    private GenderService genderService;
    @Autowired
    private DesignationService designationService;


    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private  EmployeeTypeService employeeTypeService;

    @Autowired
    private HighestEducationalQualificationService highestEducationalQualificationService;

    @Autowired
    private HighestVocationalQualificationService highestVocationalQualificationService;
    @Autowired
    private CivilStatusService civilStatusService;

    public String InitialLoad(ModelMap model) {

        List<Gender> genderList = genderService.findAll();
        model.addAttribute("genderList", genderList);

        List<CivilStatus> civilStatusList = civilStatusService.findAll();
        model.addAttribute("civilStatusList", civilStatusList);

        List<Designation> designationList = designationService.findAll();
        model.addAttribute("designationList", designationList);


        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("departmentList", departmentList);

        List<EmployeeType> employeeTypeList = employeeTypeService.findAll();
        model.addAttribute("employeeTypeList", employeeTypeList);

        List<highestEducationalQualification> highesteducationalqualificationList = highestEducationalQualificationService.findAll();
        model.addAttribute("highesteducationalqualificationList", highesteducationalqualificationList);

        List<highestVocationalQualification> highestvocationalqualificationList = highestVocationalQualificationService.findAll();
        model.addAttribute("highestvocationalqualificationList", highestvocationalqualificationList);
        return "EmployeeRegistration";

    }

    //we use the same url /newemployee to save and to get add the employee form
    //but we changed the our URL method get to get employee registration form and
    //URL POST method use for employee save in to the data base
    //When use request newemployee with GET METHORD it passes the LoadEmployee method
    @RequestMapping(value = {"/newemployee"}, method = RequestMethod.GET)
    // when we calling the LoadEmployee we passed the empty ModelMap
//controller class load UI EmployeeRegistration.jsp
//controler to ui

    public String LoadEmployee(ModelMap model) {

        //InitialLoad();
        //we create the object empobj using employee entity class
        Employee empobj = new Employee();
        //we add model propertity as the employee object property
        model.addAttribute("employee", empobj);
        InitialLoad(model);


        //we  call  the EmployeeRegistration.jsp but we don not add jsp with surfiix of the application property
        return "modules/employee/EmployeeRegistration";
    }

    @RequestMapping(value = {"edit-employee-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int empId = Integer.parseInt(id);

        Employee empObj = employeeService.findById(empId);
        model.addAttribute("employee", empObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "modules/employee/EmployeeRegistration";


    }

    @RequestMapping(value = {"edit-employee-{id}"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, ModelMap model, BindingResult bindingResult, @PathVariable String id) {
      /* Employee valEmp = employeeService.findByNic(employee.getNic());

        if(valEmp != null){
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("nic","error.employee",
                    "This nic already exists in the system");


        }
        Employee valEmail = employeeService.findByemail(employee.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.employee",
                    "This Email already exists in the system");

        }*/

        // validation
        if (bindingResult.hasErrors()) {

            return "modules/employee/EmployeeRegistration";
        }

        employee.setStatus(true);
        employeeService.save(employee);
        // List<Employee> empList = employeeService.findAll();
        List<Employee> empList = employeeService.findByStatus(true);
        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }

    @RequestMapping(value = {"delete-employee-{id}"}, method = RequestMethod.GET)
    public String deleteEmployee(Employee employee, ModelMap model, @PathVariable String id) {


        int empId = Integer.parseInt(id);

        Employee empObj = employeeService.findById(empId);
        empObj.setStatus(false);

        employeeService.update(empObj);

        //employeeService.delete(empObj);
        //List<Employee> empList = employeeService.findAll();
        List<Employee> empList = employeeService.findByStatus(true);
        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }

    //    When use request newemployee with POST METHORD it passes the saveEmployee method
    //when we binding if there is error we need to be handle for that we used the BindingResult
    @RequestMapping(value = {"/newemployee"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult,
                               ModelMap model) {
        //validating whether the NIC is exists or not
        Employee valEmp = employeeService.findByNic(employee.getNic());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valEmp != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("nic", "error.employee",
                    "This nic already exists in the system");

        }

        Employee valEmail = employeeService.findByemail(employee.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.employee",
                    "This Email already exists in the system");

        }
        // validation
        if (bindingResult.hasErrors()) {
            return "modules/employee/EmployeeRegistration";
        }

        //System.out.println(employee);
        //(Employee) convert the model object
        //Employee empobj=(Employee)model.getAttribute("employee");
        employee.setStatus(true);

        employeeService.save(employee);
        // After saving the employee object into the data base we want
        //List our employee
        //we assign the result of the employeeService.findAll() in to the emplist
        //it return the employee list
        //we  create the list emplist and assign the value of employeeService.findAll() into emplist
        //List<Employee> emplist=employeeService.findAll();
        List<Employee> empList = employeeService.findByStatus(true);
        //we fill the the our model object with emplist
        //we passed the data controller to view-Employee view.jsp with employeeList-data binding
        //model map has two colums attribute name value -attributeName employeeList and value emplist object

        model.addAttribute("employeeList", empList);
        // we call EmployeeView.jsp  add the jsp file by the application property file
        return "modules/employee/EmployeeView";
        //return "EmployeeRegistration";

    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public String LoadEmployeeForm(ModelMap model) {
        //we use the java generic List<Employee>
        List<Employee> empList = employeeService.findByStatus(true);

//List<Employee> emplist=employeeService.findAll();
        //we used the employeeList passed the value controller to EmployeeView.jsp
        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }
}

