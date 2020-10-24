package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
import com.vtan.salesapp.salesapp.service.OJTPlaceService;
import com.vtan.salesapp.salesapp.service.OjtDetailsService;
import com.vtan.salesapp.salesapp.service.RegisterStudentService;
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
public class OjtDetailsController {
    @Autowired
    private OJTPlaceService ojtPlaceService;
    @Autowired
    private RegisterStudentService registerStudentService;
    @Autowired
    private OjtDetailsService ojtDetailsService;

    public String InitialLoad(ModelMap model) {

        List<RegistedStudent> studentList = registerStudentService.findAll();
        model.addAttribute("studentList", studentList);

        List<OJTPlace> ojtPlaceList = ojtPlaceService.findAll();
        model.addAttribute("ojtList", ojtPlaceList);



        return "OjtDetailsRegstration";
    }

    @RequestMapping(value = {"/newojtstudent"}, method = RequestMethod.GET)
    public String LoadojtStudent(ModelMap model) {
        OjtDetails od = new OjtDetails();
        model.addAttribute("ojtDetails", od);
        InitialLoad(model);
        return "modules/ojt/OjtDetailsRegstration";

    }

    @RequestMapping(value = {"/newojtstudent"}, method = RequestMethod.POST)
   //bing oject should same model attribute ui to controller
    public String saveojtStudent(@Valid OjtDetails ojtDetails, ModelMap model, BindingResult bindingResult) {
        //Employee valEmp = employeeService.findByNic(employee.getNic());

        //List<StudentBatch> valsb = studentBatchService.finByStundentBatchId(studentbatch.getBatchid(), studentbatch.getStudentid());
        List<OjtDetails> valojtDetail = ojtDetailsService.finByOjtDetailsId(ojtDetails.getStudentid(),ojtDetails.getOjtid());
        //StudentBatch valsb = studentBatchService.finByStundBatchId(studentBatch.getBatchid().getId(),studentBatch.getStudentid().getId());

        if (valojtDetail.size() > 0) {

            bindingResult.rejectValue("ojtid","error.ojtDetails",  "Student already registered to this ojt place");
            // bindingResult.rejectValue("studentid", "error.studentbatch",  "both number in the system");
        }

        if (bindingResult.hasErrors()) {

            InitialLoad(model);
            return "modules/ojt/OjtDetailsRegstration";
        }

        ojtDetails.setStatus(true);

        ojtDetailsService.save(ojtDetails);
        List<OjtDetails> ojtchList = ojtDetailsService.findByStatus(true);
        // model.addAttribute("studentBatch", studentBatchList);
        model.addAttribute("ojtPlaceList", ojtchList);

        return "modules/ojt/OjtDetailsView";


    }

    @RequestMapping(value = {"/ojtstudent"}, method = RequestMethod.GET)
    public String Loadojtform(ModelMap model) {

        List<OjtDetails> ojtchList = ojtDetailsService.findByStatus(true);
        model.addAttribute("ojtPlaceList", ojtchList);

        return "modules/ojt/OjtDetailsView";
    }

    @RequestMapping(value = {"edit-ojtstudent-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int stuojtId = Integer.parseInt(id);

        OjtDetails stubatObj = ojtDetailsService.findById(stuojtId);
        model.addAttribute("ojtDetails", stubatObj);
        InitialLoad(model);
        model.addAttribute("edit", true);
        return "modules/ojt/OjtDetailsRegstration";
    }

    @RequestMapping(value = {"edit-ojtstudent-{id}"}, method = RequestMethod.POST)
    public String updateCourse(@Valid OjtDetails ojtDetails, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "modules/ojt/OjtDetailsRegstration";
        }

        ojtDetails.setStatus(true);
        ojtDetailsService.save(ojtDetails);
        // List<Employee> empList = employeeService.findAll();
        Loadojtform(model);
        /*List<Course> couList = courseService.findByStatus(true);
        model.addAttribute("courseList", couList);
        return "CourseView";*/

        return "modules/ojt/OjtDetailsView";
    }
}
