/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer;

/**
 *
 * @author Drew White
 */
public class HourlyEmployee extends Employee{
//    Attributes for HourlyEmployee, extends the attributes from Employee class
    public double hourlyRate;
    public double overtimeRate;
// Constructor for Hourly Employee
    public HourlyEmployee(double hourlyRate, double overtimeRate, String firstName, String lastName, int employeeId, double socialSecurityNumber, String userID, String password) {
        super(firstName, lastName, employeeId, socialSecurityNumber,userID,password);
        this.hourlyRate = hourlyRate;
        this.overtimeRate = overtimeRate;
    }
// Getter for hourly pay rate
    public double getHourlyRate() {
        return hourlyRate;
    }
// Getter for overtime pay rate
    public double getOvertimeRate() {
        return overtimeRate;
    }
// Setter for hourly pay rate
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
// Setter for Ot payrate
    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }
// To string method
    @Override
    public String toString() {
        return "HourlyEmployee{" +"firstName=" + firstName + 
                ", lastName=" + lastName + 
                ", employeeId=" + employeeId + 
                ", socialSecurityNumber=" + socialSecurityNumber + 
                ", hourlyRate=" + hourlyRate + 
                ", overtimeRate=" + overtimeRate +
                ", userID=" + userID +
                ", password=" + password +'}';
    }
    
}