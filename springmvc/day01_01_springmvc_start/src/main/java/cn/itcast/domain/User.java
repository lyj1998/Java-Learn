package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String uname;
    private Integer age;
    private Date date;

    public String getUname() {
        return uname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
