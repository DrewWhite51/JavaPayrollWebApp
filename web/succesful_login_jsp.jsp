<%-- 
    Document   : newjsp
    Created on : Mar 6, 2022, 10:47:01 AM
    Author     : drewm
--%>



<%@page import="data_access_layer.EmployeeDatabase"%>
<%@page import="business_layer.Employee"%>
<%@page import="business_layer.HourlyEmployee"%>
<html>
<head>
    <meta charset="utf-8">
    <title>CIS640 Assignment 1</title>
    <link rel="stylesheet" href="css/jsp_styles.css" type="text/css"/>    
    <style>
        body {background-color: #e9ecef;}
        h1   {text-align: center; margin-left:5rem; margin-right:5rem;}
        table{border-collapse:collapse;border:1px solid #FF0000;}
        .btnDiv{
            display: flex;
            justify-content: center;
        }
        .btn{
            padding-left: 1.5rem;
            padding-right: 1.5rem;
        }       
        .btn {
            transition-duration: 0.4s;
        }
        .btn:hover {
          background-color: #4CAF50; /* Green */
          color: white;
        }
        .btnSpan{
            margin-left: 20px;
        }
    </style>
    
    
</head>
<body>


        <%
            HttpSession httpSession = request.getSession(false); 
            //False because we do not want it to create a new session if it does not exist.
            Employee user = null;
            if(httpSession != null){
                user = (Employee)httpSession.getAttribute("currentUser");                
            }
            if(user!=null){
                // Do stuff here
            }
            
        %>
        
        <h1>
            Employee Name:
            <%
                out.println(user.firstName + " " + user.lastName);
            %>
        </h1>
        
        <h1>
            Employee ID:
            <%
                out.println(user.employeeId);
            %>
        </h1>
        
        <h1>
            <%
                if (EmployeeDatabase.check_hourly_employee(user) == true) {
                    out.println("Hourly employee verified, timecard functionality available.");
                } else {
                    out.println("Timecard functionality disabled, salaried employee.");
                }
            %>
        </h1>

        

        

        <%
            String pageName = "timecard.jsp";
            String payrollPageName = "payroll_calculation.jsp";
        %>
        <div class="btnDiv">
                
            <button class="btn" action="timecard" type="button" onclick="redirectPage('<%=pageName%>')">Add/Update Timecards</button>
            
            <span class="btnSpan"></span>
            <button class="btn" action="payroll" type="button" name="back" onclick="redirectPage('<%=payrollPageName%>')">Calculate Payroll</button>
            <span class="btnSpan"></span>
            <input class="btn" type="button" value="Exit" onclick="window.location='index.html'" >
        </div>
        

        
        
        

    <script>
        function optionUnavailable() {
          alert("That option is not available yet.");
        }
        function redirectPage(pageName){
            window.location.href=pageName;
        }
       
        
    </script>

</body>
</html>