package com.example.demo;

public class Employee {
    private Long empId;
    private  String Ename;
    private String email;
    private int tel;
    private Department department;

    public void setEmpId(Long empId)
    {
        this.empId=empId;
    }
    public void setEname(String ename)
    {
        this.Ename=ename;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setTel(int tel)
    {
        this.tel=tel;
    }
    public void setDepartment(Department d)
    {
        this.department=d;
    }


    public Long getEmpId()
    {
        return empId;
    }

    public String getEname()
    {
        return Ename;
    }
    public String getEmail()
    {
        return email;
    }
    public int getTel()
    {
        return tel;
    }

    public Department getDepartment()
    {
        return department;
    }

}
