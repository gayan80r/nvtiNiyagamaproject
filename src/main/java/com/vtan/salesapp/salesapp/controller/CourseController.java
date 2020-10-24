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
public class CourseController {
    @Autowired
    private TradeService tradeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private CourseDurationService courseDurationService;
    @Autowired
    private NvqlevelService nvqlevelService;

    public String InitialLoad(ModelMap model) {
        List<CourseType> courseTypeList=courseTypeService.findAll();
        model.addAttribute("courseTypeList",courseTypeList);

        List<Trade> tradeList = tradeService.findAll();
        model.addAttribute("tradeList", tradeList);


        List<CourseDuration> courseDurationList=courseDurationService.findAll();
        model.addAttribute("courseDurationList",courseDurationList);

        List<NvqLevel> nvqLevelList=nvqlevelService.findAll();
        model.addAttribute("nvqLevelList",nvqLevelList);

        return "CourseRegistration";
    }

    @RequestMapping(value = {"/newcourse"}, method = RequestMethod.GET)
    public String LoadCourse(ModelMap model) {

        Course cou = new Course();
        model.addAttribute("course", cou);
        InitialLoad(model);
        return "modules/course/CourseRegistration";

    }
//this controller to the ui
    @RequestMapping(value = {"/course"}, method = RequestMethod.GET)
    public String LoadCourseForm(ModelMap model) {

        List<Course> couList = courseService.findByStatus(1);
        model.addAttribute("courseList", couList);
        return "modules/course/CourseView";
    }
    @RequestMapping(value = {"edit-course-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int couId = Integer.parseInt(id);

       Course couObj = courseService.findById(couId);
        model.addAttribute("course", couObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "modules/course/CourseRegistration";
    }

    @RequestMapping(value = {"edit-course-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid Course course, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "modules/course/CourseRegistration";
        }

        course.setStatus(1);
        courseService.save(course);
        // List<Employee> empList = employeeService.findAll();
        LoadCourseForm(model);
        /*List<Course> couList = courseService.findByStatus(true);
        model.addAttribute("courseList", couList);
        return "CourseView";*/
        return "modules/course/CourseView";
    }

    @RequestMapping(value = {"delete-course-{id}"}, method = RequestMethod.GET)
    public String deleteCourse(Course course, ModelMap model, @PathVariable String id) {

        int couId = Integer.parseInt(id);
        Course couObj = courseService.findById(couId);
        couObj.setStatus(0);
        courseService.update(couObj);
        List<Course> couList = courseService.findByStatus(1);
        model.addAttribute("courseList", couList);
        return "modules/course/CourseView";
    }

    @RequestMapping(value = {"/newcourse"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveCourse(@Valid Course course, BindingResult bindingResult,
                               ModelMap model) {
        //validating whether the Name is exists or not
        Course valCou = courseService.findByName(course.getName());
        // Employee valEmail=employeeService.findByemail(employee.getEmail());
        if (valCou != null) {

            bindingResult.rejectValue("name", "error.course",
                    "This course name already exists in the system");

        }

        if (bindingResult.hasErrors()) {
            return "modules/course/CourseRegistration";
        }

                course.setStatus(1);
        courseService.save(course);

        List<Course> couList = courseService.findByStatus(1);
         model.addAttribute("courseList", couList);

        return "modules/course/CourseView";


            }

}

