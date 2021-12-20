/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author buffa
 */
public class DbManager {

    private Connection db;
    private Statement s;
    private ResultSet rs;


    public DbManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://localhost:3307/WebProyectoFinal", "root", "1234");
            s = db.createStatement();
        } catch (Exception e) {
            System.out.println("Excepcion:" + e.toString());
        }
    }

    public ResultSet selectResultSet(String query) throws SQLException {
        rs = s.executeQuery(query);
        return rs;
    }
    
    public boolean insertObject(String query){
        try{
            rs = s.executeQuery(query);
            return true;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
        
    }
    
   
}
