package com.newweb.model.base;

import javax.persistence.*;

@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private String type;

    @Column(name="linkid")
    private int linkid;

    @Column
    private String lastLoginTime;

    @Column(columnDefinition="int default 0")
    private int loginCount;

    @Column(columnDefinition="boolean default true")
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLinkid() {
        return linkid;
    }

    public void setLinkid(int linkid) {
        this.linkid = linkid;
    }
}
