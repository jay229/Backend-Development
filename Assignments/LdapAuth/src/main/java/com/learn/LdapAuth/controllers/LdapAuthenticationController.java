package com.learn.LdapAuth.controllers;

import java.util.List;

import com.learn.LdapAuth.Model.LdapUser;
import com.learn.LdapAuth.services.LdapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LdapAuthenticationController {

    @Autowired
    private LdapUserService ldapUserService;

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping("/getUserDetails")
    public String getUserDetails(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // access user details
        String userName = userDetails.getUsername();
        boolean accNonExpired = userDetails.isAccountNonExpired();
        return "UserDetails: " + userName + "\n Account Non Expired: " + accNonExpired;
    }

    @GetMapping("/getAllUsers")
    public List<LdapUser> getAllUsers() {
        return ldapUserService.getAllUsers();
    }

    @GetMapping("/getUserById/{uid}")
    public LdapUser getUserById(@PathVariable String uid) {

        return ldapUserService.getUserById(uid);
    }

    @GetMapping("/deleteUser/{uid}")
    public String deleteUser(@PathVariable String uid) {
        ldapUserService.deleteUser(uid);
        return "User Deleted";
    }
    @GetMapping("/userList")
    public List<LdapUser> userList( Model model) {
        return ldapUserService.getAllUsers();
    }
}