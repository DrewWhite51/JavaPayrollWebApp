<%-- 
    Document   : editTable.jsp
    Created on : Mar 24, 2022, 11:38:09 AM
    Author     : drewm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Testing....</h1>
        <h1>${currentUser.firstName}</h1>
        <h1>${empTimeCards}</h1>
        
        
        
        <table class="table" id="newTimeCards">
            <thead>
              <tr>
                <th scope="col">Timecard</th>
                <th scope="col">Date</th>
                <th scope="col">Hours Worked</th>
                <th scope="col">Overtime Hours</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${newTime}" var="timecard" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${timecard.date}</td>
                    <td>${timecard.hoursWorked}</td>
                    <td>${timecard.overtimeHours}</td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
    </body>
    
    
    
</html>
