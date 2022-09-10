/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetManagement;

/**
 *
 * @author luuchibao
 */
import java.time.LocalDate;

public class Employee {
    private String empID;
    private String empName;
    private LocalDate bDate;
    private String role;
    private String sex;
    private String pwd;

    public Employee() {
    }

    public Employee(String empID, String empName, LocalDate bDate, String role, String sex, String pwd) {
        this.empID = empID;
        this.empName = empName;
        this.bDate = bDate;
        this.role = role;
        this.sex = sex;
        this.pwd = pwd;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-25s|%-15s|%-4s|%-7s|%-30s|", 
                empID, empName, bDate, role, sex, pwd);
    }
}

