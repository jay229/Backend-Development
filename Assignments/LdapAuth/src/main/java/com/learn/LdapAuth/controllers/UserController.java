package com.learn.LdapAuth.controllers;

import com.learn.LdapAuth.Model.LdapUser;
import com.learn.LdapAuth.services.LdapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private LdapUserService ldapUserService;

    @GetMapping("/addUserForm")
    public String addUserForm( Model model) {
        System.out.println("inside addUser form ");
        model.addAttribute("ldapUser", new LdapUser());
        return "addUser";
//        return "greet";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("ldapUser") LdapUser ldapUser) {
        System.out.println("Inside addUser method");
        ldapUserService.addUser(ldapUser);
        return "success";
    }

//    @GetMapping("/userList")
//    public String userList( Model model) {
//        model.addAttribute("userList", ldapUserService.getAllUsers());
//        return "userList";
//    }

    @GetMapping("edit/{uid}")
    public String showUpdateForm(@PathVariable String uid,Model model){
        LdapUser ldapUser= ldapUserService.getUserById(uid);
        if (ldapUser==null)
            return "userError";
        model.addAttribute("ldapUser", ldapUser);
        return "updateUser";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("ldapUser") LdapUser ldapUser){
//        System.out.println("id"+ldapUser.getUsername());
        ldapUserService.updateUser(ldapUser);
        return "successUpdate";
    }
}