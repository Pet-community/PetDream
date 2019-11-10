package com.pet.petdream.test.bean;

import com.pet.petdream.base.bean.HttpResponseBean;

/**
 * @author wuyang
 * @create 2019/11/8
 * @Describe
 */
public class Test  {


    /**
     * userid : 1
     * name : admin
     * name_nc : 测试
     * pwd : 123
     * img : null
     * address : 襄阳
     * phone : 2147483647
     * email : 123@qq.com
     */

    private int userid;
    private String name;
    private String name_nc;
    private String pwd;
    private Object img;
    private String address;
    private String phone;
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_nc() {
        return name_nc;
    }

    public void setName_nc(String name_nc) {
        this.name_nc = name_nc;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
