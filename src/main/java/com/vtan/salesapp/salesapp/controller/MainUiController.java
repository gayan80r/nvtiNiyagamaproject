package com.vtan.salesapp.salesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainUiController {
	   @RequestMapping(value={"/leftmenu"},method= RequestMethod.GET)
	    public String leftnavbar(ModelMap model){ 
	        return "modules/leftnavbar"; 
	    }
	   @RequestMapping(value={"/dashboard"},method= RequestMethod.GET)
	    public String dashboard(ModelMap model){ 
	        return "modules/dashboard"; 
	    }
}
