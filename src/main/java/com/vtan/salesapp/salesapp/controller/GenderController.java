package com.vtan.salesapp.salesapp.controller;

import com.vtan.salesapp.salesapp.entity.Gender;
import com.vtan.salesapp.salesapp.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenderController {
    @Autowired
    private GenderService genderService;
    @RequestMapping(value={"/insertgender"},method= RequestMethod.GET)
    public String insertGender(){

        Gender g=new Gender();
        g.setName("male");
        genderService.save(g);
        return "sucessfully inserted";


    }
}
