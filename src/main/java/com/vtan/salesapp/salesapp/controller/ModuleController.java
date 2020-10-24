package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Module;
import com.vtan.salesapp.salesapp.entity.Semister;
import com.vtan.salesapp.salesapp.service.CourseService;
import com.vtan.salesapp.salesapp.service.ModuleSevice;
import com.vtan.salesapp.salesapp.service.SemisterService;
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
public class ModuleController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SemisterService semisterService;
    @Autowired
    private ModuleSevice moduleSevice;

    public String InitialLoad(ModelMap model) {
        List<Course> courseList=courseService.findAll();
        model.addAttribute("courseList",courseList);

        List<Semister> semisterList = semisterService.findAll();
        model.addAttribute("semisterList", semisterList);

       return "ModuleRegistration";
    }
    @RequestMapping(value = {"/newmodule"}, method = RequestMethod.GET)
    public String LoadModule(ModelMap model) {

        Module mod = new Module();
        model.addAttribute("module", mod);
        InitialLoad(model);
        return "modules/course/modules/ModuleRegistration";

    }
    @RequestMapping(value = {"/module"}, method = RequestMethod.GET)
    public String LoadModuleForm(ModelMap model) {

        List<Module> mouList = moduleSevice.findAll();
        model.addAttribute("moduleList", mouList);
        return "modules/course/modules/ModuleView";
    }

    @RequestMapping(value = {"edit-module-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {
        int moduId = Integer.parseInt(id);
        Module modObj = moduleSevice.findById(moduId);
        model.addAttribute("module", modObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "modules/course/modules/ModuleRegistration";
    }

    @RequestMapping(value = {"edit-module-{id}"}, method = RequestMethod.POST)
    public String updateModule(@Valid Module module, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "modules/course/modules/ModuleRegistration";
        }

        //course.setStatus(true);
        moduleSevice.save(module);
        // List<Employee> empList = employeeService.findAll();
        LoadModule(model);

        return "modules/course/modules/ModuleView";
    }

    @RequestMapping(value = {"delete-module-{id}"}, method = RequestMethod.GET)
    public String deleteModule(Module module, ModelMap model, @PathVariable String id) {

        int modId = Integer.parseInt(id);
        Module modObj = moduleSevice.findById(modId);
        //couObj.setStatus(false);
        moduleSevice.update(modObj);
        //List<Module> modList = moduleSevice.findByStatus(true);
        List<Module> modList = moduleSevice.findAll();
        model.addAttribute("moduleList", modList);
        return "modules/course/modules/ModuleView";
    }
    @RequestMapping(value = {"/newmodule"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveModule(@Valid Module module, BindingResult bindingResult,
                             ModelMap model) {
        //validating whether the Name is exists or not
        Module valmod = moduleSevice.findByName(module.getName());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valmod != null) {

            bindingResult.rejectValue("name", "error.module",
                    "This Module name already exists in the system");

        }

        if (bindingResult.hasErrors()) {
            return "modules/course/modules/ModuleRegistration";
        }

        //course.setStatus(true);
        moduleSevice.save(module);

        //List<Course> couList = courseService.findByStatus(true);
        List<Module> modList = moduleSevice.findAll();
        model.addAttribute("moduleList", modList);

        return "modules/course/modules/ModuleView";


    }

}
