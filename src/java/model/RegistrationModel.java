package model;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alkahaifalam
 */
public class RegistrationModel implements ModelInterface{
    public void doBusiness(HttpServletRequest request, HttpServletResponse response,ServletContext ctx){
        

            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String mobileno = request.getParameter("mobileno");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String gender = request.getParameter("Gender");
            String dob = request.getParameter("dob");    
           
           try(PrintWriter out = response.getWriter()) {
           Doa md = Doa.getInstance();
           String getUid = "SELECT MAX(uid) FROM user_table";
           String queryLogin = "INSERT INTO login_table(email,password,status) VALUES (' "+email+" ', ' "+pass+" ' , 0)";
           Statement  st = md.getConnection("jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false", "faiz","integral");
           int g= -1;
           if(gender.equals("Male")) g=1;
           else if(gender.equals("Female")) g=0;
           ResultSet rs = st.executeQuery(getUid);
           int u =0;
           while(rs.next())
               u= rs.getInt(1);
           u++;
           md.storeData(st, queryLogin);
           String queryUser= "INSERT INTO user_table(uid, firstname,lastname, dob, mobile_no, gender , email) VALUES (' "+u+" ' , ' "+fname+" ', ' "+lname+" ', ' "+dob+" ', ' "+mobileno+ " ', ' " +g+" ', ' "+email+" ')";
           md.storeData(st, queryUser);
           
           
           MailSender ms = new MailSender();
           ms.sendMail(email);
           
           request.getRequestDispatcher("/WEB-INF/pages/afterLogin.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }
    
}