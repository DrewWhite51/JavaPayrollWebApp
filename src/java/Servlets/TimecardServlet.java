/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import business_layer.Employee;
import business_layer.Timecard;
import data_access_layer.TimeCardDatabase;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TimecardServlet extends HttpServlet {
    
       protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
                       
            String successUrl = "/timecard.jsp";
            
            
 
   
//            GEtting the current session
            HttpSession httpSession = request.getSession(false); 

//            Getting the user in the current session
            Employee user = null;
            if(httpSession != null){
                user = (Employee)httpSession.getAttribute("currentUser");                
            }
            if(user!=null){
                // Do stuff here
            }
            
//          Getting timecards assocaited with the user of this session
//          Setting the arraylist to a new arraylist to edit and add or subtract to
            ArrayList<Timecard> newTime = (ArrayList<Timecard>) request.getSession(false).getAttribute("empTimeCards");
           
            for (int i = 0; i<newTime.size(); i++) {
    //              Strings to read the data from the html JSTL table
                    String str = "deleteRow";
                    String counterStr = Integer.toString(i);
                    if (request.getParameter(str+counterStr) != null){


//                        Deletes the timecard from the sql database
                        TimeCardDatabase.deleteTimecardFromDatabase(newTime.get(i).date,
                                newTime.get(i).employeeId, 
                                newTime.get(i).hoursWorked,
                                newTime.get(i).overtimeHours);
//                        Removes the timecard from the session array
                        newTime.remove(i);
                        
                        TimeCardDatabase.readFullDatabase();
                        System.out.println("---------");
                        

        //              Updating the page
        
                        getServletContext().getRequestDispatcher(successUrl).forward(request, response);

                        break;
                } else if (request.getParameter("addTimecard") != null){
                    
                    String date = request.getParameter("date");
                    int hoursWorked = Integer.parseInt(request.getParameter("empHoursWorked"));
                    int overTimeHours = Integer.parseInt(request.getParameter("empOverTimeHours"));
                    String empIdString = Integer.toString(user.employeeId);
                 
                    Timecard newCard = new Timecard(date,Double.valueOf(empIdString),hoursWorked,overTimeHours);
                    
                   
                    newTime.add(newCard);

                     
                    TimeCardDatabase.createTimecard(date, Double.valueOf(empIdString), hoursWorked, overTimeHours);

                    TimeCardDatabase.readFullDatabase();
                    System.out.println("---------");
                    
                    getServletContext().getRequestDispatcher(successUrl).forward(request, response);

                    
                    break;
                } else if (request.getParameter("editTimecard") != null) {
                                        
                    String timeCardToEdit = request.getParameter("editTimecardNumber");

                    String newDate =  request.getParameter("editDate");
                    String newHoursStr = request.getParameter("editEmpHoursWorked");
                    String newOverTimeStr = request.getParameter("editEmpOverTimeHours");
                    
                    
                    int newHours = Integer.parseInt(newHoursStr);
                    int newOverTimeHours = Integer.parseInt(newOverTimeStr);
                                        
//                    Setting the timecard object to the new values
                                        

                    int editIndex = Integer.parseInt(timeCardToEdit);
                    int arrayIndex = editIndex-1;

                    
                    TimeCardDatabase.updateTimecard(newDate, 
                            newTime.get(arrayIndex).employeeId,
                            newHours, 
                            newOverTimeHours, 
                            newTime.get(arrayIndex).date,
                            newTime.get(arrayIndex).hoursWorked, 
                            newTime.get(arrayIndex).overtimeHours);
                                        

//                    Setting the timecard object to the new values
                    
                    newTime.get(arrayIndex).setDate(newDate);
                    newTime.get(arrayIndex).setHoursWorked(newHours);
                    newTime.get(arrayIndex).setOvertimeHours(newOverTimeHours);
                    
                                       
                    
                    TimeCardDatabase.readFullDatabase();
                    System.out.println("---------");
                    
                    getServletContext().getRequestDispatcher(successUrl).forward(request, response);
                        
                    TimeCardDatabase.readFullDatabase();
                       
                    
                    break;
                    
                }
            }


       
       }
       
       
       
       

}