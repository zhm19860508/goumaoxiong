package com.goumaoxiong.dal.object;

import java.io.Serializable;

public class UserDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = 6457740134445982909L;
    private String            userName;
    private Integer           isAdmin;
    private String            password;
    private String            nick;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}
