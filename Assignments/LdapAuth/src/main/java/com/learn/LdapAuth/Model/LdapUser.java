package com.learn.LdapAuth.Model;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;

public class LdapUser {
    private String cn;
    private String sn;
    private String username; //uid
    private String password;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Attributes toAttributes(){
        Attributes attributes=new BasicAttributes();
        attributes.put("objectClass","inetOrgPerson");
        attributes.put("cn",cn);
        attributes.put("sn",sn);
        attributes.put("uid",username);
        attributes.put("userPassword",password);
        return attributes;
    }
}
