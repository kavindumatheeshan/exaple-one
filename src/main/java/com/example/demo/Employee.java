package com.example.demo;

public class Employee {
    private Long empId;
    private String Ename;
    private String email;
    private int tel;
    private Department department;
    private int age;

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public void setEname(String ename) {
        this.Ename = ename;
    }

    public void setEmail(String email) {
        if (!email.contains("@") || !email.contains(".com")) {
            System.out.println("this is the wrong type of email");
        }
        this.email = email;
    }


    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setDepartment(Department d) {
        this.department = d;
    }

    public void setAge(int age)
    {
        if(age>100)
        {
            System.out.println("this person old than too much ");
        }
        if(age<=0)
        {
            System.out.println("this is the invalid age ");

        }
        this.age=age;
    }


    public Long getEmpId() {
        return empId;
    }

    public String getEname() {
        return Ename;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public Department getDepartment() {
        return department;
    }
    public int getAge()
    {
        return age;
    }

}
