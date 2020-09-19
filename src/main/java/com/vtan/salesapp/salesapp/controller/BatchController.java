package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Batch;
import com.vtan.salesapp.salesapp.entity.Course;
import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.service.BatchService;
import com.vtan.salesapp.salesapp.service.CourseService;
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
public class BatchController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private BatchService batchService;



    public String InitialLoad(ModelMap model) {


        List<Course> courseList=courseService.findAll();
        model.addAttribute("courselList",courseList);


        return "BatchRegistration";
    }

    @RequestMapping(value = {"/newbatch"}, method = RequestMethod.GET)
    public String Loadbatch(ModelMap model) {

        Batch ba = new Batch();
        model.addAttribute("batch", ba);
        InitialLoad(model);
        return "BatchRegistration";

    }

    @RequestMapping(value = {"/batch"}, method = RequestMethod.GET)
    public String LoadBatchForm(ModelMap model) {

        List<Batch> batchList = batchService.findByStatus(true);
        model.addAttribute("batchList", batchList);
        return "BatchView";
    }

    @RequestMapping(value = {"edit-batch-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int batId = Integer.parseInt(id);

        Batch batObj = batchService.findById(batId);
        model.addAttribute("batch", batObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "BatchRegistration";
    }

    @RequestMapping(value = {"edit-batch-{id}"}, method = RequestMethod.POST)
    public String updateBatch(@Valid Batch batch, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "BatchRegistration";
        }

        batch.setStatus(true);
        batchService.save(batch);
        // List<Employee> empList = employeeService.findAll();
        LoadBatchForm(model);

        return "BatchView";
    }
    @RequestMapping(value = {"delete-batch-{id}"}, method = RequestMethod.GET)
    public String deleteBatch(Batch batch, ModelMap model, @PathVariable String id) {

        int batId = Integer.parseInt(id);

        Batch batObj = batchService.findById(batId);
        batObj.setStatus(false);
        batchService.update(batObj);
        List<Batch> batchList = batchService.findByStatus(true);
        model.addAttribute("batchList", batchList);
        return "BatchView";
    }
    @RequestMapping(value = {"/newbatch"}, method = RequestMethod.POST)

    public String saveBatch(@Valid Batch batch, BindingResult bindingResult,
                             ModelMap model) {
        //validating whether the Name is exists or not
        Batch valbat = batchService.findByName(batch.getName());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valbat != null) {

            bindingResult.rejectValue("name", "error.batch",
                    "This batch name already exists in the system");

        }

        if (bindingResult.hasErrors()) {
            return "BatchRegistration";
        }

        batch.setStatus(true);
        batchService.save(batch);

        List<Batch> batchList = batchService.findByStatus(true);
        model.addAttribute("batchList", batchList);
        return "BatchView";


    }

}
