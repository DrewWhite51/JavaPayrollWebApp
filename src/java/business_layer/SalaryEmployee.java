/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer;

/**
 *
 * @author drewm
 */
public class SalaryEmployee extends Employee {
//    Adding salary employee attribute and extending the employee class
    private double annualSalary;
// Constructor for the Salary Employee
    public SalaryEmployee(double annualSalary, String firstName, String lastName, int employeeId, double socialSecurityNumber, String userID, String password) {
        super(firstName, lastName, employeeId, socialSecurityNumber, userID, password);
        this.annualSalary = annualSalary;
    }


//    Getter for annual salary
    public double getAnnualSalary() {
        return annualSalary;
    }
// Setter for annual salary
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
//    To string for salary employee
    @Override
    public String toString() {
        return "SalaryEmployee{" + "firstName=" + firstName + 
                ", lastName=" + lastName + 
                ", employeeId=" + employeeId + 
                ", socialSecurityNumber=" + socialSecurityNumber + 
                ", annualSalary=" + annualSalary + 
                ", userID=" + userID +
                ", password=" + password +'}';
    }
    
}

