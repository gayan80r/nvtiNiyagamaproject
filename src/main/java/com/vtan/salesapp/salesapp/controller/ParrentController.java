package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Parrent;
import com.vtan.salesapp.salesapp.service.ParrentService;
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
public class ParrentController {
    @Autowired
    private ParrentService parrentService;


    public String InitialLoad(ModelMap model) {


        return "ParrentRegistration";
    }
    @RequestMapping(value = {"/newparrent"}, method = RequestMethod.GET)
    public String LoadParrent(ModelMap model) {

        Parrent par = new Parrent();
        model.addAttribute("parrent", par);
        InitialLoad(model);
        return "ParrentRegistration";

    }

    @RequestMapping(value = {"/parrent"}, method = RequestMethod.GET)
    public String LoadParrentForm(ModelMap model) {
        Parrent newparrent =new Parrent();
        model.addAttribute("parrent",newparrent);
        List<Parrent> parList = parrentService.findByStatus(true);
        model.addAttribute("parrentList", parList);
        return "ParrentView";
    }




    @RequestMapping(value = {"edit-parrent-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int parId = Integer.parseInt(id);

        Parrent parObj = parrentService.findById(parId);
        model.addAttribute("parrent", parObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "ParrentRegistration";
    }

    @RequestMapping(value = {"edit-parrent-{id}"}, method = RequestMethod.POST)
    public String updateParrent(@Valid Parrent parrent, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "ParrentRegistration";
    }

        parrent.setStatus(true);
        parrentService.save(parrent);
        // List<Employee> empList = employeeService.findAll();
        LoadParrentForm(model);

        return "ParrentView";
    }

    @RequestMapping(value = {"delete-parrent-{id}"}, method = RequestMethod.GET)
    public String deleteParrent(Parrent parrent, ModelMap model, @PathVariable String id) {

        int parId = Integer.parseInt(id);
        Parrent parObj = parrentService.findById(parId);
        parObj.setStatus(false);
        parrentService.update(parObj);
        List<Parrent> parList = parrentService.findByStatus(true);
        model.addAttribute("parrentList", parList);
        return "ParrentView";
    }
    @RequestMapping(value = {"/newparrent"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveparrent(@Valid Parrent parrent, BindingResult bindingResult,
                             ModelMap model) {
        //validating whether the Name is exists or not
        Parrent valpar = parrentService.findByNameWithInitial(parrent.getName_with_initial());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valpar != null) {

            bindingResult.rejectValue("name_with_initial", "error.parrent",
                    "This  Name_with_initial already exists in the system");

        }
        Parrent valEmp = parrentService.findByNic(parrent.getNic());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valEmp != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("nic", "error.parrent",
                    "This nic already exists in the system");

        }

        Parrent valEmail = parrentService.findByemail(parrent.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.parrent",
                    "This Email already exists in the system");

        }

        if (bindingResult.hasErrors()) {
            return "ParrentRegistration";
        }

        parrent.setStatus(true);
        parrentService.save(parrent);

        List<Parrent> parList = parrentService.findByStatus(true);
        model.addAttribute("parrentList", parList);

        return "ParrentView";


    }



}
