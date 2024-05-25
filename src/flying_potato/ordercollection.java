/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flying_potato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rameshwar
 */
public class ordercollection {
    public ordercollection(String c_id,String name,String hprice,String hunit,String fprice,String funit)
    {
    try
    {
        String sql = "insert into costumer_order values(null,?,?,?,?,?,?,default)";
        String url = "jdbc:mysql://localhost:3306/flyingpotato";
        Connection con=DriverManager.getConnection(url, "root","root");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,c_id);
        ps.setString(2,name);
        ps.setString(3,hprice);
        ps.setString(4,hunit);
        ps.setString(5,fprice);
        ps.setString(6,funit);
        int a=ps.executeUpdate();
        if(a>0)
        {
            JOptionPane.showMessageDialog(null, "Order of Placed:\n"+name+"\nHalf: "+hunit+"\nFull: "+funit);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Missing Data..");                       
        }
    }
    catch(SQLException e)
    {
    if(e instanceof SQLSyntaxErrorException)
    {
    try {
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyingpotato","root","root");
    con.createStatement().execute("CREATE table costumer_Order(O_ID int auto_increment primary key,Costumer_ID int,Item_Name char(25) not null,Half_Price float not null,H_Unit int ,Full_Price float not null,F_Unit int, Bookig_Date date default(current_date()) not null,FOREIGN KEY (Costumer_ID) REFERENCES costumer(C_ID));");
    } 
    catch (SQLException ex) {
    JOptionPane.showMessageDialog(null,ex);
    }
    }
    else
    {
    JOptionPane.showMessageDialog(null,e);
    }
    } 
    }
}
