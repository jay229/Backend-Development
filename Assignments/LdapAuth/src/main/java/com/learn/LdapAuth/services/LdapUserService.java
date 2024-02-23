package com.learn.LdapAuth.services;

import com.learn.LdapAuth.Model.LdapUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LdapUserService {
    @Autowired
    LdapTemplate ldapTemplate;
    private static final String BASE_DN="ou=users,ou=system";
    public void addUser(LdapUser ldapUser){
        ldapTemplate.bind("uid="+ldapUser.getUserName()+","+BASE_DN,null, ldapUser.toAttributes());
    }
    public List<LdapUser> getAllUsers() {
        return ldapTemplate.search(BASE_DN, "(objectClass=inetOrgPerson)",
                (AttributesMapper<LdapUser>) attributes ->{
                    LdapUser ldapuser = new LdapUser();
                    ldapuser.setCn(attributes.get("cn").get().toString());
                    ldapuser.setSn(attributes.get("sn").get().toString());
                    ldapuser.setUserName(attributes.get("uid").get().toString());
                    ldapuser.setPassword(attributes.get("userPassword").get().toString());
                    return ldapuser;
                });
    }
    public LdapUser getUserById(String uid) {
        List<LdapUser> userDetails=  ldapTemplate.search(BASE_DN, "(uid="+uid+")",
                (AttributesMapper<LdapUser>) attributes ->{
                    LdapUser ldapuser = new LdapUser();
                    ldapuser.setCn(attributes.get("cn").get().toString());
                    ldapuser.setSn(attributes.get("sn").get().toString());
                    ldapuser.setUserName(attributes.get("uid").get().toString());
                    ldapuser.setPassword(attributes.get("userPassword").get().toString());
                    return ldapuser;
                });
        if (userDetails.size()>0)
            return userDetails.get(0);
        return null;
    }
}
