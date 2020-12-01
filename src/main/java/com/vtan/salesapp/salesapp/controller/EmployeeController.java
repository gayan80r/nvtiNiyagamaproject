package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
import com.vtan.salesapp.salesapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    private HighestEducationalQualificationService highestEducationalQualificationService;
    @Autowired
    private HighestVocationalQualificationService highestVocationalQualificationService;
    @Autowired
    private CivilStatusService civilStatusService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private  CityService cityService;

    public String InitialLoad(ModelMap model) {

        List<Gender> genderList = genderService.findAll();
        model.addAttribute("genderList", genderList);

        List<CivilStatus> civilStatusList = civilStatusService.findAll();
        model.addAttribute("civilStatusList", civilStatusList);

        List<Designation> designationList = designationService.findAll();
        model.addAttribute("designationList", designationList);


        List<Department> departmentList = departmentService.findAll();
        model.addAttribute("departmentList", departmentList);

        List<City> cityList = cityService.findAll();
        model.addAttribute("cityList", cityList);

        List<highestEducationalQualification> highesteducationalqualificationList = highestEducationalQualificationService.findAll();
        model.addAttribute("highesteducationalqualificationList", highesteducationalqualificationList);

        List<highestVocationalQualification> highestvocationalqualificationList = highestVocationalQualificationService.findAll();
        model.addAttribute("highestvocationalqualificationList", highestvocationalqualificationList);

        List<EmployeeType> typeServiceAll = employeeTypeService.findAll();
        model.addAttribute("employeeTypeList", typeServiceAll);

        return "EmployeeRegistration";

    }

    @RequestMapping(value = {"/newemployee"}, method = RequestMethod.GET)
    public String LoadEmployee(ModelMap model) {
        Employee empobj = new Employee();
        model.addAttribute("employee", empobj);
        InitialLoad(model);
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
    @RequestMapping(value = {"active-employee-{id}"}, method = RequestMethod.GET)
    public String activateEmployee(Employee employee, ModelMap model, @PathVariable String id) {


        int empId = Integer.parseInt(id);

        Employee empObj = employeeService.findById(empId);
        empObj.setStatus(true);

        employeeService.update(empObj);

        //employeeService.delete(empObj);
        //List<Employee> empList = employeeService.findAll();
        List<Employee> empList = employeeService.findByStatus(true);
        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }

    @RequestMapping(value = {"/newemployee"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult,ModelMap model) {

        Employee valEmp = employeeService.findByNic(employee.getNic());
        if (valEmp != null) {
            bindingResult.rejectValue("nic", "error.employee",
                    "This nic already exists in the system");

        }

        Employee valEmail = employeeService.findByemail(employee.getEmail());
        if (valEmail != null) {
            bindingResult.rejectValue("email", "error.employee",
                    "This Email already exists in the system");

        }

        // validation
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            InitialLoad(model);
            return "modules/employee/EmployeeRegistration";
        }
        employee.setStatus(true);

        employeeService.save(employee);
        List<Employee> empList = employeeService.findByStatus(true);

        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public String LoadEmployeeForm(ModelMap model) {
        //we use the java generic List<Employee>
        List<Employee> empList = employeeService.findByStatus(true);

//List<Employee> emplist=employeeService.findAll();
        //we used the employeeList passed the value controller to EmployeeView.jsp
        InitialLoad(model);
        model.addAttribute("employeeList", empList);
        return "modules/employee/EmployeeView";
    }
}

