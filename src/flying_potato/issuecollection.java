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
public class issuecollection {
    temp t=new temp();
    String id=t.id;
    String mail=t.email;
    
    public void bug(String email, String issue, String description) {
        try
    {
        String sql = "insert into costumer_issue values(null,?,?,?,?,?,default)";
        String url = "jdbc:mysql://localhost:3306/flyingpotato";
        Connection con=DriverManager.getConnection(url, "root","root");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,"Bug");
        ps.setString(3,email);
        ps.setString(4,issue);
        ps.setString(5,description);
        int a=ps.executeUpdate();
        if(a>0)
        {
            JOptionPane.showMessageDialog(null, "Noted Sucessfully");
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
    con.createStatement().execute("CREATE table costumer_issue(O_ID int auto_increment primary key,Costumer_ID int,Regarding char(25) not null,Email char(25) null,Issue char(20) null,Description char(255) not null, Date date default(current_date()) not null);");
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
    public void complain(String item, String description) {
        try
    {
        String sql = "insert into costumer_issue values(null,?,?,?,null,?,default)";
        String url = "jdbc:mysql://localhost:3306/flyingpotato";
        Connection con=DriverManager.getConnection(url, "root","root");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,"Complain");
        ps.setString(3, mail);
        ps.setString(4,description);
        int a=ps.executeUpdate();
        if(a>0)
        {
            JOptionPane.showMessageDialog(null, "Noted Sucessfully");
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
    con.createStatement().execute("CREATE table costumer_issue(O_ID int auto_increment primary key,Costumer_ID int,Regarding char(25) not null,Email char(25) null,Issue char(20) null,Description char(255) not null, Date date default(current_date()) not null);");
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
