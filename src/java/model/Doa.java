/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.*;
import java.io.*;
/**
 *
 * @author faiz
 */
public class Doa implements Serializable{
    private Doa() { }
    private static Doa md= null;
    public static Doa getInstance(){
        if(md==null){
            md= new Doa();
        }
        return md;
    }
    public Statement getConnection(String url, String user, String password) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,user,password);
       return con.createStatement();
    }
    public void storeData(Statement st, String query)throws SQLException{
        st.execute(query);
    }
    public ResultSet fetchData(Statement st, String query) throws SQLException{
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
}
