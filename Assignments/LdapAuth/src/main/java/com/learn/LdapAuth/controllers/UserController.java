package com.learn.LdapAuth.controllers;

import com.learn.LdapAuth.Model.LdapUser;
import com.learn.LdapAuth.services.LdapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private LdapUserService ldapUserService;
    @GetMapping("/addUserForm")
    public String addUserForm(Model model){
        model.addAttribute("ldapUser",new LdapUser());
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(LdapUser ldapUser){
        ldapUserService.addUser(ldapUser);
        return "success";
    }


}
