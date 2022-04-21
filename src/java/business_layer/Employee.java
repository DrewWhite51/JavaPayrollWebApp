/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer;

/**
 *
 * @author drewm
 */
public abstract class Employee {
//    Attributes of the employee class
     public String firstName;
     public String lastName;
     public int employeeId;
     public double socialSecurityNumber;
     public String userID;
     public String password;
     
//     Constructor for the Employee class
    public Employee(String firstName, String lastName, int employeeId, double socialSecurityNumber, String userID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.socialSecurityNumber = socialSecurityNumber;
        this.userID = userID;
        this.password = password;

    }
// Getter for EmployeeId
    public double getEmployeeId() {
        return employeeId;
    }
// Getter for SSN
    public double getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
// Setter method for setting employeeId
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
// Setter for SSN
    public void setSocialSecurityNumber(double socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
//    Getter for first name
    public String getFirstName() {
        return firstName;
    }
//Getter for last name
    public String getLastName() {
        return lastName;
    }
// Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
// Setter for last ame
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
// Getter for userID
    public String getUserID() {
        return userID;
    }
// Getter for password
    public String getPassword() {
        return password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", employeeId=" + employeeId + ", socialSecurityNumber=" + socialSecurityNumber + ", userID=" + userID + ", password=" + password + '}';
    }
    
    

    
    
    
}