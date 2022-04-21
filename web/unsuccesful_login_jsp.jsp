<%-- 
    Document   : unsuccesful_login_jsp
    Created on : Mar 6, 2022, 5:06:58 PM
    Author     : drewm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unsuccesful Login</title>
        <link rel="stylesheet" href="/css/jsp_styles.css" type="text/css"/>
    </head>
    <body>
        <h1>Error with your login information, go to the previous page to try again.</h1>
        <h2>Click this button to go back.</h2>
        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
