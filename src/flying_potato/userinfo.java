/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flying_potato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rameshwar
 */
public class userinfo {
    String cid;
    String uname;
    public void logininfo(String lid,String lpass)
    {
            try
            {            
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/flyingpotato", "root", "root");
            PreparedStatement ps=con.prepareCall("select * from costumer where Email=? and Passwords=?");
            ps.setString(1, lid);
            ps.setString(2, lpass);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                cid=rs.getString("C_ID");
                uname=rs.getString("First_NAme");
            }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }
    
}
