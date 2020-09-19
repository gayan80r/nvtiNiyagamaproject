package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Accessor;
import com.vtan.salesapp.salesapp.entity.Designation;
import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.service.AccessorService;
import com.vtan.salesapp.salesapp.service.DesignationService;
import com.vtan.salesapp.salesapp.service.GenderService;
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
public class AccessorController {
    @Autowired
    private AccessorService accessorService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private DesignationService designationService;
    public String InitialLoad(ModelMap model) {

        List<Gender> genderList = genderService.findAll();
        model.addAttribute("genderList", genderList);


        List<Designation> designationList = designationService.findAll();
        model.addAttribute("designationList", designationList);


        return "AccessorRegistration";

    }

    @RequestMapping(value = {"/newaccessor"}, method = RequestMethod.GET)
    // when we calling the LoadEmployee we passed the empty ModelMap
//controller class load UI EmployeeRegistration.jsp
//controler to ui

    public String LoadAccessor(ModelMap model) {

        //InitialLoad();
        //we create the object empobj using employee entity class
        Accessor accobj = new Accessor();
        model.addAttribute("accessor", accobj);
        InitialLoad(model);


        //we  call  the EmployeeRegistration.jsp but we don not add jsp with surfiix of the application property
        return "AccessorRegistration";
    }
    @RequestMapping(value = {"edit-accessor-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int accId = Integer.parseInt(id);

        Accessor accObj = accessorService.findById(accId);
        model.addAttribute("accessor", accObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "AccessorRegistration";

    }

    @RequestMapping(value = {"edit-accessor-{id}"}, method = RequestMethod.POST)
    public String updateAccessor(@Valid Accessor accessor, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "AccessorRegistration";
        }

        accessor.setStatus(true);
        accessorService.save(accessor);
        // List<Employee> empList = employeeService.findAll();
        List<Accessor> accList = accessorService.findByStatus(true);
        model.addAttribute("accessorList", accList);
        return "AccessorView";
    }

    @RequestMapping(value = {"delete-accessor-{id}"}, method = RequestMethod.GET)
    public String deleteAccessor(Accessor accessor, ModelMap model, @PathVariable String id) {


        int accId = Integer.parseInt(id);

        Accessor accObj = accessorService.findById(accId);
        accObj.setStatus(false);

        accessorService.update(accObj);

        //employeeService.delete(empObj);
        //List<Employee> empList = employeeService.findAll();
        List<Accessor> accList = accessorService.findByStatus(true);
        model.addAttribute("accessorList", accList);
        return "AccessorView";

    }

    @RequestMapping(value = {"/newaccessor"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveAccessor(@Valid Accessor accessor, BindingResult bindingResult,
                               ModelMap model) {
        //validating whether the NIC is exists or not
        Accessor valAcc = accessorService.findByNic(accessor.getNic());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valAcc != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("nic", "error.accessor",
                    "This nic already exists in the system");

        }

        Accessor valnic = accessorService.findByNic(accessor.getEmail());
        if (valnic != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.accessor",
                    "This Email already exists in the system");

        }
        // validation
        if (bindingResult.hasErrors()) {
            return "AccessorRegistration";
        }


        accessor.setStatus(true);

        accessorService.save(accessor);


        List<Accessor> accList = accessorService.findByStatus(true);
        model.addAttribute("accessorList", accList);
        return "AccessorView";
        //return "EmployeeRegistration";
    }

    @RequestMapping(value = {"/accessor"}, method = RequestMethod.GET)
    public String LoadEmployeeForm(ModelMap model) {
        //we use the java generic List<Employee>
        List<Accessor> accList = accessorService.findByStatus(true);
        model.addAttribute("accessorList", accList);
        return "AccessorView";
    }

    }
