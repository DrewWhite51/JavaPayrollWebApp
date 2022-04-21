<%-- 
    Document   : payroll_calculation
    Created on : Apr 20, 2022, 4:04:13 PM
    Author     : drewm
--%>

<%@page import="data_access_layer.TimeCardDatabase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business_layer.Timecard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
                        
            table {  
                border: solid;  
                text-align:center;  
                border-collapse: collapse;
            }
            table td{
                border:solid;
            }
            table th {
                border:solid;
            }
            #firstPayPeriodDiv{
                display: flex;
                flex-wrap: wrap;  
                justify-content: center;
                margin-top: 3rem;
                border-bottom: solid;
                padding-bottom: 3rem;
            }
                        
            #secondPayPeriodDiv{
                display: flex;
                flex-wrap: wrap;  
                justify-content: center;
                padding-bottom: 3rem;
                border-bottom: solid;
                padding-top: 3rem;
            }

                        
            #thirdPayPeriodDiv{
                display: flex;
                flex-wrap: wrap;  
                justify-content: center;
                padding-bottom: 3rem;
                border-bottom: solid;
                padding-top: 3rem;
            }
            #payPeriodStats{ 
                display: flex;
                flex-direction: column;
                padding-bottomt: 2rem;
            }


        </style>
    </head>
    <body>                
        <h1>Pay history for: ${currentUser.firstName} ${currentUser.lastName}</h1>
                                
        <form action="payroll" method="post" class="calcPayrollTable">
                                        
            <td><input class="button" type="submit" value="Calculate" name="calc"></td>

        </form>
            
        <div id="firstPayPeriodDiv">
            <table class="table" id="firstPayPeriodTable">  
                <thead>  
                    <tr>
                        <th scope="col">Timecard</th>
                        <th scope="col">Date</th>
                        <th scope="col">Hours Worked</th>
                        <th scope="col">Overtime Hours</th>
                    </tr>    
                </thead>    
                <tbody>
                    <c:forEach items="${firstPayPeriod}" var="timecard" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${timecard.date}</td>
                            <td>${timecard.hoursWorked}</td>
                            <td>${timecard.overtimeHours}</td></td>
                        </tr>
                    </c:forEach>
                </tbody>  
            </table>
            

            <div id="payPeriodStats">
                <h3>---Pay period stats---</h3>
                <h4>Regular hours: ${regularHoursFirstPayPeriod}. Overtime hours: ${overtimeHoursFirstPayPeriod}.</h4>
                <h4>Total pay this period: ${totalPayFirstPeriod}</h4>
            </div>
            
            
        </div>
        
                
        <div id="secondPayPeriodDiv">
            
            <table class="table" id="secondPayPeriodTable">  
                <thead>  
                    <tr>
                        <th scope="col">Timecard</th>
                        <th scope="col">Date</th>
                        <th scope="col">Hours Worked</th>
                        <th scope="col">Overtime Hours</th>
                    </tr>    
                </thead>    
                <tbody>
                    <c:forEach items="${secondPayPeriod}" var="timecard" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${timecard.date}</td>
                            <td>${timecard.hoursWorked}</td>
                            <td>${timecard.overtimeHours}</td></td>
                        </tr>
                    </c:forEach>
                </tbody>  
            </table>
                        

                     
            <div id="payPeriodStats">
                <h3>---Pay period stats---</h3>
                <h4>Regular hours: ${regularHoursSecondPayPeriod}. Overtime hours: ${overtimeHoursSecondPayPeriod}.</h4>
                <h4>Total pay this period: ${totalPaySecondPeriod}</h4>
            </div>
        </div>
                
            
         
            
        <div id="thirdPayPeriodDiv">
          <table class="table" id="thirdPayPeriodTable">  
            <thead>  
                <tr>
                    <th scope="col">Timecard</th>
                    <th scope="col">Date</th>
                    <th scope="col">Hours Worked</th>
                    <th scope="col">Overtime Hours</th>
                </tr>    
            </thead>    
            <tbody>
                <c:forEach items="${thirdPayPeriod}" var="timecard" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${timecard.date}</td>
                        <td>${timecard.hoursWorked}</td>
                        <td>${timecard.overtimeHours}</td></td>
                    </tr>
                </c:forEach>
            </tbody>  
        </table>  
                         
            <div id="payPeriodStats">
                <h3>---Pay period stats---</h3>
                <h4>Regular hours: ${regularHoursThirdPayPeriod}. Overtime hours: ${overtimeHoursThirdPayPeriod}.</h4>
                <h4>Total pay this period: ${totalPayThirdPeriod}</h4>
            </div>
        </div>
        

        
        
        
        


        
    </body>
</html>
