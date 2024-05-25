/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flying_potato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rameshwar
 */
public class temp {
    
    public String id;
    public String name;
    public String email;
    
    public temp(){
        try
        {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flyingpotato", "root", "root");
            PreparedStatement ps=con.prepareCall("select * from temp");
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                id=rs.getString("ID");
                name=rs.getString("Name");
                email=rs.getString("Email");
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void drop()
    {
        try
        {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flyingpotato", "root", "root");
            PreparedStatement ps=con.prepareCall("drop table temp;");
            ps.execute();
        }
        catch(SQLException e)
        {
            
        }
    }
}
