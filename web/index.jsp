<%-- 
    Document   : index
    Created on : 20-Sep-2023, 2:36:15 PM
    Author     : alkahaifalam jkk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>REGISTRATION FORM</h1>
        <form action="fc/?type=model&page=RegistrationModel" method="POST">
            <ul>
            <li class="formli">Mobile Number :<input type="text" name="mobileno" placeholder="Mobile:"/></li>
            <li class="formli">E-Mail ID :            <input type="email" name="email" placeholder="Email"/></li>
            <li class="formli">Password : <input type="password" name="pass" placeholder="Password"/></li>
            <li class="formli">FirstName : <input type="text" placeholder="firstname" name="fname" /></li>
            <li class="formli">LastName : <input type="text" placeholder="lastname" name="lname" /></li>
            <li>Gender:
                <input type="radio" name="Gender" value="Male"/> Male
                <input type="radio" name="Gender" value="Female"/> Female
                <input type="radio" name="Gender" value="other"/> Others
            </li>
            <li class="formli">Date of Birth:<input type="date" name="dob" /></li>
            <li class="formli"><input type="submit" value="Send"/></li>
            </ul>
        </form>
    </body>
</html>