package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Employee;
import com.vtan.salesapp.salesapp.entity.EmployeeLeave;
import com.vtan.salesapp.salesapp.entity.LeaveType;
import com.vtan.salesapp.salesapp.entity.StudentBatch;
import com.vtan.salesapp.salesapp.service.EmployeeLeaveService;
import com.vtan.salesapp.salesapp.service.EmployeeService;
import com.vtan.salesapp.salesapp.service.LeaveTypeService;
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
public class EmployeeLeaveController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveTypeService leaveTypeService;
    @Autowired
    private EmployeeLeaveService employeeLeaveService;

    @RequestMapping(value = {"/newemployeeleave"}, method = RequestMethod.GET)
    // when we calling the LoadEmployee we passed the empty ModelMap
//controller class load UI EmployeeRegistration.jsp
//controler to ui

    public String LoadEmployeeLeave(ModelMap model) {

        //InitialLoad();
        //we create the object empobj using employee entity class
        EmployeeLeave emplobj = new EmployeeLeave();
        //we add model propertity as the employee object property
        model.addAttribute("employeeLeave", emplobj);
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

    @RequestMapping(value = {"/newemployeeleave"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveEmployee(@Valid EmployeeLeave employeeLeave, BindingResult bindingResult,
                               ModelMap model) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());
        List<EmployeeLeave> valel = employeeLeaveService.finByEmployeeStartEndDate(employeeLeave.getEpf_no(),employeeLeave.getStartdate(), employeeLeave.getEnddate());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valel.size() > 0) {

            bindingResult.rejectValue("epf_no", "error.employeeLeave", "This Leave already registered to this batch");
            // bindingResult.rejectValue("studentid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "EmployeeLeaveRegistration";
        }

       employeeLeave.setStatus(true);

        employeeLeaveService.save(employeeLeave);
        List<EmployeeLeave> employeeleaveList = employeeLeaveService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("employeeLeaveList", employeeleaveList);

        return "EmployeeLeaveView";
    }



    @RequestMapping(value = {"/employeeleave"}, method = RequestMethod.GET)
    public String LoadBatchStudentform(ModelMap model) {

        List<EmployeeLeave> employeeleaveList = employeeLeaveService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("employeeLeaveList", employeeleaveList);

        return "EmployeeLeaveView";
    }

    @RequestMapping(value = {"edit-employeeLeave-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int empleavetId = Integer.parseInt(id);

        EmployeeLeave employeeLeaveObj = employeeLeaveService.findById(empleavetId);
        model.addAttribute("employeeLeave", employeeLeaveObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "EmployeeLeaveRegistration";
    }

    @RequestMapping(value = {"edit-employeeLeave-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid  EmployeeLeave employeeLeave, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "EmployeeLeaveRegistration";
        }

        employeeLeave.setStatus(true);

        employeeLeaveService.save(employeeLeave);
        List<EmployeeLeave> employeeleaveList = employeeLeaveService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("employeeLeaveList", employeeleaveList);

        return "EmployeeLeaveView";
    }
}
