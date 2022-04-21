/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import business_layer.Employee;
import business_layer.HourlyEmployee;
import business_layer.Timecard;
import data_access_layer.TimeCardDatabase;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author drewm
 */
public class CalculatePayroll extends HttpServlet{
    
     protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
     
         HttpSession httpSession = request.getSession(false);
         
         
         String successUrl = "/payroll_calculation.jsp";
         
                     
         HourlyEmployee user = null;
            
         if(httpSession != null){
                user = (HourlyEmployee)httpSession.getAttribute("currentUser");                
            }
            if(user!=null){
                // Do stuff here
            }
         
         ArrayList<Timecard> firstPayPeriod = new ArrayList();
         ArrayList<Timecard> secondPayPeriod = new ArrayList();
         ArrayList<Timecard> thirdPayPeriod = new ArrayList();
         
         double regularHoursFirstPayPeriod;
         double overtimeHoursFirstPayPeriod;
         
         double regularHoursSecondPayPeriod;
         double overtimeHoursSecondPayPeriod;
         
         double regularHoursThirdPayPeriod;
         double overtimeHoursThirdPayPeriod;
         
         
         
         for (int i=0; i<TimeCardDatabase.getTimecards_arr().size(); i++){
             if (TimeCardDatabase.getTimecards_arr().get(i).date.equals("4/9/2022")) {
                 firstPayPeriod.add(TimeCardDatabase.getTimecards_arr().get(i));
             } else if (TimeCardDatabase.getTimecards_arr().get(i).date.equals("4/15/2022")) {
                 secondPayPeriod.add(TimeCardDatabase.getTimecards_arr().get(i)); 
             } else if (TimeCardDatabase.getTimecards_arr().get(i).date.equals("4/21/2022")) {
                 thirdPayPeriod.add(TimeCardDatabase.getTimecards_arr().get(i));
             } else {
                
             }
            
         }
         
         System.out.println(firstPayPeriod);
         httpSession.setAttribute("firstPayPeriod", firstPayPeriod);
         System.out.println(secondPayPeriod);
         httpSession.setAttribute("secondPayPeriod", secondPayPeriod);
         System.out.println(thirdPayPeriod);
         httpSession.setAttribute("thirdPayPeriod", thirdPayPeriod);
         
         double firstPayRegularHoursCounter = 0;
         double firstPayOvertimeHoursCounter = 0;
         for (int i =0;i<firstPayPeriod.size();i++) {
             firstPayRegularHoursCounter += firstPayPeriod.get(i).hoursWorked;
             firstPayOvertimeHoursCounter += firstPayPeriod.get(i).overtimeHours;
         }
         regularHoursFirstPayPeriod = firstPayRegularHoursCounter*user.getHourlyRate();
         overtimeHoursFirstPayPeriod = firstPayOvertimeHoursCounter*user.getOvertimeRate();
         httpSession.setAttribute("regularHoursFirstPayPeriod",regularHoursFirstPayPeriod);
         httpSession.setAttribute("overtimeHoursFirstPayPeriod",overtimeHoursFirstPayPeriod);
         
         double totalPayFirstPeriod = regularHoursFirstPayPeriod + overtimeHoursFirstPayPeriod;
         
                  
         double secondPayRegularHoursCounter = 0;
         double secondPayOvertimeHoursCounter = 0;
         for (int i =0;i<secondPayPeriod.size();i++) {
             secondPayRegularHoursCounter += secondPayPeriod.get(i).hoursWorked;
             secondPayOvertimeHoursCounter += secondPayPeriod.get(i).overtimeHours;
         }
         regularHoursSecondPayPeriod = secondPayRegularHoursCounter*user.getHourlyRate();
         overtimeHoursSecondPayPeriod = secondPayOvertimeHoursCounter*user.getOvertimeRate();
         httpSession.setAttribute("regularHoursSecondPayPeriod",regularHoursSecondPayPeriod);
         httpSession.setAttribute("overtimeHoursSecondPayPeriod",overtimeHoursSecondPayPeriod);
         
         double totalPaySecondPeriod = regularHoursSecondPayPeriod + overtimeHoursSecondPayPeriod;
         
         
                  
         double thirdPayRegularHoursCounter = 0;
         double thirdPayOvertimeHoursCounter = 0;
         for (int i =0;i<thirdPayPeriod.size();i++) {
             thirdPayRegularHoursCounter += thirdPayPeriod.get(i).hoursWorked;
             thirdPayOvertimeHoursCounter += thirdPayPeriod.get(i).overtimeHours;
         }
         regularHoursThirdPayPeriod = thirdPayRegularHoursCounter*user.getHourlyRate();
         overtimeHoursThirdPayPeriod = thirdPayOvertimeHoursCounter*user.getOvertimeRate();
         httpSession.setAttribute("regularHoursThirdPayPeriod",regularHoursThirdPayPeriod);
         httpSession.setAttribute("overtimeHoursThirdPayPeriod",overtimeHoursThirdPayPeriod);
         
         double totalPayThirdPeriod = regularHoursThirdPayPeriod+overtimeHoursThirdPayPeriod;
         
          
         httpSession.setAttribute("totalPayThirdPeriod",totalPayThirdPeriod);  
         httpSession.setAttribute("totalPaySecondPeriod",totalPaySecondPeriod);
         httpSession.setAttribute("totalPayFirstPeriod",totalPayFirstPeriod);
         
                      
         getServletContext().getRequestDispatcher(successUrl).forward(request, response);
         
         

            
         
                     

     
         
     
     
     
     }
    
}
