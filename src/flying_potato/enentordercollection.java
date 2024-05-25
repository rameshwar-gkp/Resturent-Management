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
public class enentordercollection {
    temp t=new temp();
    String id=t.id,uname=t.name;

    public enentordercollection(String event, String total, String paid, String remaning, String date) {
        try
    {
        String sql = "insert into costumer_reservation values(null,?,?,?,?,?,?,default)";
        String url = "jdbc:mysql://localhost:3306/flyingpotato";
        Connection con=DriverManager.getConnection(url, "root","root");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,uname);
        ps.setString(3,total);
        ps.setString(4,paid);
        ps.setString(5,remaning);
        ps.setString(6,date);
        int a=ps.executeUpdate();
        if(a>0)
        {
            JOptionPane.showMessageDialog(null, "Booked Sucessfully");
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
    con.createStatement().execute("CREATE table costumer_reservation(O_ID int auto_increment primary key,Costumer_ID int,Costumer_Name char(25) not null,Total float not null,Paid int ,Remainig float not null,Reservation_Date date, Booking_Date date default(current_date()) not null,FOREIGN KEY (Costumer_ID) REFERENCES costumer(C_ID));");
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
