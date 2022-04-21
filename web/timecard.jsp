<%-- 
    Document   : timecard
    Created on : Mar 20, 2022, 8:29:33 PM
    Author     : drewm
--%>

<%@page import="data_access_layer.TimeCardDatabase"%>
<%@page import="business_layer.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timecard Page</title>
        <style>
            
            body {background-color: #e9ecef;}
            
            
            .button input {
                border: 1px solid; /* Green border */
                color: white; /* White text */
                cursor: pointer; /* Pointer/hand icon */
                display: block; /* Make the buttons appear below each other */
            }

            .btn-group input:not(:last-child) {
                 border-bottom: none; /* Prevent double borders */
            }
            
            
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
            .editTable {
                display:flex;
                flex-direction: row;
            } 
            .tableDivOne {
                display: flex;
                justify-content: center; /* align horizontal */
                align-items: center; /* align vertical */
                padding: 20px;
            }
            .tableDivTwo {
                padding: 20px;
            }
            .tableDivThree {
                padding: 20px;
            }
        </style>
    </head>
    <body>
        

        <h1>Displaying time cards for: </h1>
        <h1>${currentUser.firstName} ${currentUser.lastName}</h1>
        
        
       
        
        <form action="timecard" method='post' class="btn-group" class="editTable">
            <div class="tableDivOne">
                <table class="table" id="timeCardTable">
                    <thead>
                      <tr>
                        <th scope="col">Timecard</th>
                        <th scope="col">Date</th>
                        <th scope="col">Hours Worked</th>
                        <th scope="col">Overtime Hours</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${empTimeCards}" var="timecard" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${timecard.date}</td>
                            <td>${timecard.hoursWorked}</td>
                            <td>${timecard.overtimeHours}</td>
                            <td><input class="button" type="submit" value="Delete" name="deleteRow${loop.index}"></td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tableDivTwo">
                <table align="center" cellpadding="6">
                    <tr>
                        <td>
                            Enter date:
                        </td>
                        <td>
                            <input type="text" id="date" name="date">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter hours worked:
                        </td>
                        <td>
                            <input type="text" id="empHoursWorked" name="empHoursWorked">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter overtime hours worked:
                        </td>
                        <td>
                            <input type="text" id="empOverTimeHours" name="empOverTimeHours">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Add record:
                        </td>
                        <td>
                            <input class="button" type="submit" value="Add" name="addTimecard">
                        </td>
                    </tr>
                </table>
            </div>
            <div class="tableDivThree">
                <table align="center" cellpadding="6">
                    <tr>
                        <td>
                            Enter timecard number to update:
                        </td>
                        <td>
                            <input type="text" id="editTimecardNumber" name="editTimecardNumber">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter date:
                        </td>
                        <td>
                            <input type="text" id="editDate" name="editDate">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter hours worked:
                        </td>
                        <td>
                            <input type="text" id="editEmpHoursWorked" name="editEmpHoursWorked">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Enter overtime hours worked:
                        </td>
                        <td>
                            <input type="text" id="editEmpOverTimeHours" name="editEmpOverTimeHours">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Edit record:
                        </td>
                        <td>
                            <input class="button" type="submit" value="Edit" name="editTimecard">
                        </td>
                    </tr>
                </table>
            </div>
            
        </form>
        
        <c:set var="totalHoursWorked" value="${0}"/>
        <c:forEach var="timecard" items="${empTimeCards}">
            <c:set var="totalHoursWorked" value="${totalHoursWorked + timecard.hoursWorked}" />
        </c:forEach>
        
        <h1>Total hours for ${currentUser.firstName} ${currentUser.lastName}:  ${totalHoursWorked}</h1>
        
        <c:set var="totalOverTimeHours" value="${0}"/>
        <c:forEach var="timecard" items="${empTimeCards}">
            <c:set var="totalOverTimeHours" value="${totalOverTimeHours + timecard.overtimeHours}" />
        </c:forEach>
        
        <h1>Total hours for ${currentUser.firstName} ${currentUser.lastName}:  ${totalOverTimeHours}</h1>
        
 

        
        
        
    </body>
</html>
