package com.vtan.salesapp.salesapp.controller;

//import com.vtan.salesapp.salesapp.entity.User;
import com.vtan.salesapp.salesapp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {
    @RequestMapping( value = {"/login"}, method = RequestMethod.GET)
    //we dont write a method for post it manage by spring security
    public String loadLoginForm(ModelMap model){
        //String modelAttribute = "user"
        //modelAttribute="user" of the login.jsp
                model.addAttribute("user", new User());


        return "Login";
    }

}
