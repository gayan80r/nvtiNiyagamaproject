package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.JobPlacement;
import com.vtan.salesapp.salesapp.entity.OJTPlace;
import com.vtan.salesapp.salesapp.service.JobPlacementService;
import com.vtan.salesapp.salesapp.service.OJTPlaceService;
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
public class JobPlacementController {
    @Autowired
   private JobPlacementService jobPlacementService;


    @RequestMapping(value = {"/newjobplacement"}, method = RequestMethod.GET)
    public String LoadOJTPlace(ModelMap model) {

        JobPlacement ojtp = new JobPlacement();
        model.addAttribute("jobplace", ojtp);
        //InitialLoad(model);
        return "JobPlacementRegistrtion";

    }



    @RequestMapping(value = {"edit-jobplace-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int jobpId = Integer.parseInt(id);

        JobPlacement jobppObj = jobPlacementService.findById(jobpId);
        model.addAttribute("jobplace", jobppObj);
        //InitialLoad(model);
        model.addAttribute("edit", true);
        return "JobPlacementRegistrtion";
    }

    @RequestMapping(value = {"edit-jobplace-{id}"}, method = RequestMethod.POST)
    public String UpdateOJTPlace(@Valid JobPlacement jobplace, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "JobPlacementRegistrtion";
        }

        jobplace.setStatus(true);
        jobPlacementService.save(jobplace);
       // jobPlacementService.save(jobplace);
        // List<Employee> empList = employeeService.findAll();
        LoadOJTPlaceForm(model);
        List<JobPlacement> jobPList = jobPlacementService.findByStatus(true);
        model.addAttribute("JobPlacementList", jobPList);
        return "JobPlacementView";
    }

    @RequestMapping(value = {"delete-jobplace-{id}"}, method = RequestMethod.GET)
    public String deleteOjtplace(JobPlacement jobplace, ModelMap model, @PathVariable String id) {
        int jobpId = Integer.parseInt(id);

        JobPlacement jobppObj = jobPlacementService.findById(jobpId);
        jobppObj.setStatus(false);
       jobPlacementService.update(jobppObj);
        List<JobPlacement> jobPList = jobPlacementService.findByStatus(true);
        model.addAttribute("JobPlacementList", jobPList);
        return "JobPlacementView";
    }

    @RequestMapping(value = {"/newjobplacement"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveOjtplace(@Valid JobPlacement jobplace, BindingResult bindingResult,
                               ModelMap model) {


        JobPlacement valEmail = jobPlacementService.findByEmail(jobplace.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.jobplace",
                    "This Email already exists in the system");

        }

        JobPlacement valname = jobPlacementService.findByName(jobplace.getName());
        if (valname != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("name", "error.jobplace",
                    "This name already exists in the system");

        }
        // validation
        if (bindingResult.hasErrors()) {
            return "JobPlacementRegistrtion";
        }


        jobplace.setStatus(true);

        jobPlacementService.save(jobplace);

        List<JobPlacement> jobPList = jobPlacementService.findByStatus(true);
        model.addAttribute("JobPlacementList", jobPList);
        return "JobPlacementView";

    }

    @RequestMapping(value = {"/jobplacement"}, method = RequestMethod.GET)
    public String LoadOJTPlaceForm(ModelMap model) {

        List<JobPlacement> jobPList = jobPlacementService.findByStatus(true);
        model.addAttribute("JobPlacementList", jobPList);
        return "JobPlacementView";
    }

}
