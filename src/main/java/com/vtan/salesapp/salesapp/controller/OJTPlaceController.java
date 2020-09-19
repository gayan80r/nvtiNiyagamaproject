package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.*;
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
public class OJTPlaceController {
    @Autowired
    private OJTPlaceService ojtPlaceService;

    /*public String InitialLoad(ModelMap model) {


        return "OJTPlaceRegistration";
    }*/

    @RequestMapping(value = {"/newojtplace"}, method = RequestMethod.GET)
    public String LoadOJTPlace(ModelMap model) {

        OJTPlace ojtp = new OJTPlace();
        model.addAttribute("ojtPlace", ojtp);
        //InitialLoad(model);
        return "OJTPlaceRegistration";

    }



    @RequestMapping(value = {"edit-ojtPlace-{id}"}, method = RequestMethod.GET)
    public String loadUpdateForm(ModelMap model, @PathVariable String id) {

        int ojtpId = Integer.parseInt(id);

        OJTPlace ojtpObj = ojtPlaceService.findById(ojtpId);
        model.addAttribute("ojtPlace", ojtpObj);
        //InitialLoad(model);
        model.addAttribute("edit", true);
        return "OJTPlaceRegistration";
    }

    @RequestMapping(value = {"edit-ojtPlace-{id}"}, method = RequestMethod.POST)
    public String UpdateOJTPlace(@Valid OJTPlace ojtplace, ModelMap model, BindingResult bindingResult, @PathVariable String id) {

        if (bindingResult.hasErrors()) {

            return "OJTPlaceRegistration";
        }

        ojtplace.setStatus(true);
        ojtPlaceService.save(ojtplace);
        // List<Employee> empList = employeeService.findAll();
        LoadOJTPlaceForm(model);
        List<OJTPlace> ojtPList = ojtPlaceService.findByStatus(true);
        model.addAttribute("ojtplaceList", ojtPList);
        return "OJTPlaceView";
    }

    @RequestMapping(value = {"delete-ojtplace-{id}"}, method = RequestMethod.GET)
    public String deleteOjtplace(OJTPlace ojtplace, ModelMap model, @PathVariable String id) {

        int ojtpId = Integer.parseInt(id);

        OJTPlace ojtpObj = ojtPlaceService.findById(ojtpId);
        ojtpObj.setStatus(false);
        ojtPlaceService.update(ojtpObj);
        List<OJTPlace> ojtPList = ojtPlaceService.findByStatus(true);
        model.addAttribute("ojtplaceList", ojtPList);
        return "OJTPlaceView";
    }

    @RequestMapping(value = {"/newojtplace"}, method = RequestMethod.POST)
    //when save bind data view to controller we need the special bindingResult object
    //to maintain the result
    public String saveOjtplace(@Valid OJTPlace ojtPlace, BindingResult bindingResult,
                              ModelMap model) {


        OJTPlace valEmail = ojtPlaceService.findByEmail(ojtPlace.getEmail());
        if (valEmail != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("email", "error.ojtPlace",
                    "This Email already exists in the system");

        }

        OJTPlace valname = ojtPlaceService.findByName(ojtPlace.getName());
        if (valname != null) {
//rejectvalue method used to print error message to the backend to frontend
            // error.employee used the object name employee
            bindingResult.rejectValue("name", "error.ojtPlace",
                    "This name already exists in the system");

        }
        // validation
        if (bindingResult.hasErrors()) {
            return "OJTPlaceRegistration";
        }


        ojtPlace.setStatus(true);

      ojtPlaceService.save(ojtPlace);

        List<OJTPlace> ojtPList = ojtPlaceService.findByStatus(true);
        model.addAttribute("ojtplaceList", ojtPList);
        return "OJTPlaceView";

    }

    @RequestMapping(value = {"/ojtplace"}, method = RequestMethod.GET)
    public String LoadOJTPlaceForm(ModelMap model) {

        List<OJTPlace> ojtPList = ojtPlaceService.findByStatus(true);
        model.addAttribute("ojtplaceList", ojtPList);
        return "OJTPlaceView";
    }

}
