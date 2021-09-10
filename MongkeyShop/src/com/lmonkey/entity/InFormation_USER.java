package com.lmonkey.entity;

public class InFormation_USER {
    private String id;
    private String name;
    private String phone;
    private  String birthday;
    private String sex;
    private String salary;
    private String address;
    private String email;
    private String PermanentAddress;


    public InFormation_USER(String ID, String NAME, String PHONE,
                            String BIRTHDAY,  String SEX, String SALARY,
                            String ADDRESS, String EMAIL, String PERMANENTADDRESS)
    {
        super();
        id=ID;
        name=NAME;
        phone=PHONE;
        birthday=BIRTHDAY;
        sex=SEX;
        salary=SALARY;
        address=ADDRESS;
        email=EMAIL;
        PermanentAddress=PERMANENTADDRESS;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
    }
}
