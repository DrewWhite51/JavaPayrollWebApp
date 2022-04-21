/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import business_layer.Employee;
import business_layer.HourlyEmployee;
import business_layer.Timecard;
import data_access_layer.EmployeeDatabase;
import data_access_layer.TimeCardDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginProcessor extends HttpServlet {
    
       protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
          
//           Getting the input from the login page
           String userID = request.getParameter("userID");
           String password = request.getParameter("password");
           
//           Init the data from the SQL database
           EmployeeDatabase.init();
           TimeCardDatabase.init();
           
           
           EmployeeDatabase.readEmployeeDatabase();
           
//           Testing employee database CRUD methods
           
//           EmployeeDatabase.deleteEmployee("Test", "Emp", 
//                   99, 1234567, "USER87", "user87", 5, 10, 0);
//           
//           EmployeeDatabase.createEmployee("Test12", "Emp12", 
//                   50, 98765, "USER99", "user99", 0, 0, 1000);
           
           
           
           

           

//           String URLS to send valid or invalid logins tt
           String successUrl = "/succesful_login_jsp.jsp";
           String unsuccesfulUrl = "/unsuccesful_login_jsp.jsp";
            
//           Creating employee object and setting it to null until login info is verified
            Employee currentUser = null;
//            Setting boolean used in loop to false
            boolean found = false;
//            Looping through the database of employees and checking if the username and 
//            Password match for any of the employees
            for (int i = 1; i <= EmployeeDatabase.get_employees().size(); i++){
                 if (userID.equals(EmployeeDatabase.get_employee_by_id(i).userID) && password.equals(EmployeeDatabase.get_employee_by_id(i).password)) {
//                     If passwords match, boolean set to true
                     found = true;
//                     Set the current user to the employee by ID number
                     currentUser = EmployeeDatabase.get_employee_by_id(i);
//                    Setting timecards for the current user
                     ArrayList<Timecard> empTimeCards = TimeCardDatabase.get_timecards_by_employee_id(currentUser.employeeId);
                    
//                     Create a sesssion for the user
                     HttpSession httpSession = request.getSession();
//                     Setting currentUser attribute
                     httpSession.setAttribute("currentUser", currentUser);
                     httpSession.setAttribute("empTimeCards", empTimeCards);
//                     Forwarding the info to the valid login page
                     getServletContext().getRequestDispatcher(successUrl).forward(request, response);
                     break;
                 }
            }
            if (!found) {
                getServletContext().getRequestDispatcher(unsuccesfulUrl).forward(request, response);
            }
            
            
            

            
       }
}