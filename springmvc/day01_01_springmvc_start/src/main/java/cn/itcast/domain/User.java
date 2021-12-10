package cn.itcast.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uname;
    private String age;
    public Integer getUname() {
        return uname;
    }

    public void setUname(Integer uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname=" + uname +
                ", age='" + age + '\'' +
                '}';
    }
}
