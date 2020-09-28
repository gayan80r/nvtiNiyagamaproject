package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.EmployeeLeave;
import com.vtan.salesapp.salesapp.entity.LeaveType;
import com.vtan.salesapp.salesapp.service.EmployeeService;
import com.vtan.salesapp.salesapp.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeLeaveController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveTypeService leaveTypeService;

    @RequestMapping(value = {"/newemployeeleave"}, method = RequestMethod.GET)
    // when we calling the LoadEmployee we passed the empty ModelMap
//controller class load UI EmployeeRegistration.jsp
//controler to ui

    public String LoadEmployeeLeave(ModelMap model) {

        //InitialLoad();
        //we create the object empobj using employee entity class
        EmployeeLeave emplobj = new EmployeeLeave();
        //we add model propertity as the employee object property
        model.addAttribute("employeeleave", emplobj);
        InitialLoad(model);


        //we  call  the EmployeeRegistration.jsp but we don not add jsp with surfiix of the application property
        return "EmployeeLeaveRegistration";
    }

    public String InitialLoad(ModelMap model) {

        List<Employee> employeetList = employeeService.findAll();
        model.addAttribute("employeelist", employeetList);

        List<LeaveType> leaveTypeList = leaveTypeService.findAll();
        model.addAttribute("leavetypelist", leaveTypeList);

        return "EmployeeLeaveRegistration";




    }
}
