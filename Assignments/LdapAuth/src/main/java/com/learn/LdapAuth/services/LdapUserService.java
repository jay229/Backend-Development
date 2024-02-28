package com.learn.LdapAuth.services;

import com.learn.LdapAuth.Model.LdapUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import java.util.ArrayList;
import java.util.List;

@Service
public class LdapUserService {
    @Autowired
    LdapTemplate ldapTemplate;
    private static final String BASE_DN = "ou=users,ou=system";

    public void addUser(LdapUser ldapUser) {
        ldapTemplate.bind("uid=" + ldapUser.getUsername() + "," + BASE_DN, null, ldapUser.toAttributes());
    }

    public List<LdapUser> getAllUsers() {
        System.out.println("Hello I'm from getAllUsers");
        List<LdapUser> users = ldapTemplate.search(BASE_DN, "(objectClass=inetOrgPerson)",
                (AttributesMapper<LdapUser>) attributes -> {
                    LdapUser ldapuser = new LdapUser();
                    ldapuser.setCn(attributes.get("cn").get().toString());
                    ldapuser.setSn(attributes.get("sn").get().toString());
                    ldapuser.setUsername(attributes.get("uid").get().toString());
                    ldapuser.setPassword(attributes.get("userPassword").get().toString());
                    return ldapuser;
                });
        return users;
    }

    public LdapUser getUserById(String uid) {
        List<LdapUser> userDetails = ldapTemplate.search(BASE_DN, "(uid=" + uid + ")",
                (AttributesMapper<LdapUser>) attributes -> {
                    LdapUser ldapuser = new LdapUser();
                    ldapuser.setCn(attributes.get("cn").get().toString());
                    ldapuser.setSn(attributes.get("sn").get().toString());
                    ldapuser.setUsername(attributes.get("uid").get().toString());
                    ldapuser.setPassword(attributes.get("userPassword").get().toString());
                    return ldapuser;
                });
        if (userDetails.size() > 0)
            return userDetails.get(0);
        return null;
    }

    public void deleteUser(String uid) {
        Name userDn = LdapNameBuilder.newInstance(BASE_DN)
                .add("uid", uid)
                .build();
        ldapTemplate.unbind(userDn);
    }

    public void updateUser(LdapUser ldapUser) {
//        ldapTemplate.update(ldapUser);
//        ldapTemplate.rebind(BASE_DN,null, ldapUser.toAttributes());
        ldapTemplate.modifyAttributes("uid=" + ldapUser.getUsername() + "," +BASE_DN, getModificationItems(ldapUser));
    }

    private ModificationItem[] getModificationItems(LdapUser user) {
        List<ModificationItem> modificationItems = new ArrayList<>();

        if (user.getCn() != null) {
            modificationItems.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute("cn", user.getCn())));
        }
        if (user.getSn() != null) {
            modificationItems.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute("sn", user.getSn())));
        }
        if (user.getPassword() != null) {
            modificationItems.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute("userPassword", user.getPassword())));

        }
        if (user.getUsername() != null) {
            modificationItems.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute("uid", user.getUsername())));

        }
        return modificationItems.toArray(new ModificationItem[0]);
    }
}
