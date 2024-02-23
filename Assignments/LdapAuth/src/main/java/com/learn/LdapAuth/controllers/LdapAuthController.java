package com.learn.LdapAuth.controllers;

import com.learn.LdapAuth.Model.LdapUser;
import com.learn.LdapAuth.services.LdapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LdapAuthController {
    @Autowired
    private LdapUserService ldapUserService;
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
    @GetMapping("get-user-details")
    public String getUserDetails(Authentication authentication){
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        String userName=userDetails.getUsername();
        boolean isNonAcountExpired=userDetails.isAccountNonExpired();
        return "user name:"+userName + "\n is account non expired: "+isNonAcountExpired;
    }
    @GetMapping("/getAllUsers")
    public List<LdapUser> getAllUsers(){
        return ldapUserService.getAllUsers();
    }
    @GetMapping("/getUserById/{uid}")
    public LdapUser getUserById(@PathVariable String uid){
        return ldapUserService.getUserById(uid);
    }
}
