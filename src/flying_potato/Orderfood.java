/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package flying_potato;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Rameshwar
 */
public final class Orderfood extends javax.swing.JFrame {


    /**
     * Creates new form Orderfood
     */
    public Orderfood() {
        initComponents();
        this.setTitle("Order Food");
        this.setLocationRelativeTo(null);
        this.pack();
        searchfull();
        checkout.setVisible(false);
        ordermenuitem.setVisible(false);
        billframe.setVisible(false);
        name.setText(new temp().name);
        
        
    }
    private String c_id=new temp().id;
    private String i_id;
    private int sum=0;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void billview()
    {
         try
        {
            String sql = "select * from costumer_order;";
            String url = "jdbc:mysql://localhost:3306/flyingpotato";
            Connection con=DriverManager.getConnection(url, "root","root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                DefaultTableModel model = (DefaultTableModel)btable.getModel();
                int add=(rs.getInt("Half_price")*rs.getInt("H_Unit"))+(rs.getInt("Full_price")*rs.getInt("F_Unit"));
                sum=(rs.getInt("Half_price")*rs.getInt("H_Unit"))+(rs.getInt("Full_price")*rs.getInt("F_Unit"));
                 model.addRow(new Object[]{
                    rs.getString("Item_Name"),rs.getInt("Half_price"),rs.getInt("H_Unit"),rs.getInt("Full_price"),rs.getInt("F_Unit"),add
                    });
                while(rs.next())
                {
                    add=(rs.getInt("Half_price")*rs.getInt("H_Unit"))+(rs.getInt("Full_price")*rs.getInt("F_Unit"));
                    sum+=(rs.getInt("Half_price")*rs.getInt("H_Unit"))+(rs.getInt("Full_price")*rs.getInt("F_Unit"));
                    model.addRow(new Object[]{
                    rs.getString("Item_Name"),rs.getInt("Half_price"),rs.getInt("H_Unit"),rs.getInt("Full_price"),rs.getInt("F_Unit"),add
                    });
                }
                total.setText("Rs "+String.valueOf(sum));
            }
            
        }
        catch(SQLException e)
        {
        }
    }
    public void searchfull(){
        try
        {
            String sql = "select * from menuitem order by Half_Price asc;";
            String url = "jdbc:mysql://localhost:3306/flyingpotato";
            Connection con=DriverManager.getConnection(url, "root","root");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                DefaultTableModel model = (DefaultTableModel)tab.getModel();
                 model.addRow(new Object[]{
                    rs.getString("Item_Name"),rs.getString("Half_price"),rs.getString("Full_price")
                    });
                while(rs.next())
                {
                    model.addRow(new Object[]{
                    rs.getString("Item_Name"),rs.getString("Half_price"),rs.getString("Full_price")
                    });
            }
            }
            
        }
        catch(SQLException e)
        {
            
        }
    }
        
     public void search(){
        try
        {
            String sql = "select * from menuitem where Item_Name=?;";
            String url = "jdbc:mysql://localhost:3306/flyingpotato";
            Connection con=DriverManager.getConnection(url, "root","root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,itemsearch.getText());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                ordermenuitem.setVisible(true);
                checkout.setVisible(false);
                i_id=rs.getString("I_ID");
                name1.setText(rs.getString("Item_Name"));
                hprice1.setText(rs.getString("Half_price"));
                fprice1.setText(rs.getString("Full_price"));
                image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flying_potato/itemimage/"+rs.getString("Image_Location"))));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Item Not Found.");
                itemsearch.setText(null);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        itemsearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        searchname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        back = new javax.swing.JButton();
        billframe = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        total = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        btable = new javax.swing.JTable();
        ordermenuitem = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hprice1 = new javax.swing.JLabel();
        hunit = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        fprice1 = new javax.swing.JLabel();
        funit = new javax.swing.JSpinner();
        order1 = new javax.swing.JButton();
        cancle1 = new javax.swing.JButton();
        image1 = new javax.swing.JLabel();
        checkout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Sanskrit Text", 0, 16)); // NOI18N
        jLabel6.setText("Enter Item Name");

        itemsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemsearchKeyReleased(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchnameMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sanskrit Text", 1, 20)); // NOI18N
        jLabel1.setText("Order Menu");

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Half Price", "Full Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab.setEnabled(false);
        jScrollPane2.setViewportView(tab);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        billframe.setFocusable(false);
        billframe.setPreferredSize(new java.awt.Dimension(240, 290));
        billframe.setVisible(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total:");

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        name.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Your Current Bill");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Name:");

        btable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Half", "Unit", "Full", "Unit", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        btable.setEnabled(false);
        btable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(btable);

        javax.swing.GroupLayout billframeLayout = new javax.swing.GroupLayout(billframe.getContentPane());
        billframe.getContentPane().setLayout(billframeLayout);
        billframeLayout.setHorizontalGroup(
            billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billframeLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(billframeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(billframeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(billframeLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        billframeLayout.setVerticalGroup(
            billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billframeLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(billframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billframeLayout.createSequentialGroup()
                    .addGap(0, 97, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ordermenuitem.setPreferredSize(new java.awt.Dimension(240, 290));

        name1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Half:");

        hprice1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        hunit.setMinimumSize(new java.awt.Dimension(50, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Full:");

        fprice1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        funit.setMinimumSize(new java.awt.Dimension(50, 22));

        order1.setText("Order");
        order1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order1ActionPerformed(evt);
            }
        });

        cancle1.setText("Cancel");

        image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image1.setAlignmentX(0.5F);
        image1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ordermenuitemLayout = new javax.swing.GroupLayout(ordermenuitem);
        ordermenuitem.setLayout(ordermenuitemLayout);
        ordermenuitemLayout.setHorizontalGroup(
            ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordermenuitemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ordermenuitemLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ordermenuitemLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(funit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ordermenuitemLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(hprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(hunit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(order1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancle1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(image1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ordermenuitemLayout.setVerticalGroup(
            ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordermenuitemLayout.createSequentialGroup()
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(order1)
                    .addComponent(hunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordermenuitemLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(hprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancle1)
                    .addComponent(funit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ordermenuitemLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ordermenuitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(fprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );

        checkout.setText("Check Out");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ordermenuitem, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(searchname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(itemsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(246, Short.MAX_VALUE)
                    .addComponent(billframe, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(back))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(checkout)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel6)))
                .addGap(0, 0, 0)
                .addComponent(searchname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ordermenuitem, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 106, Short.MAX_VALUE)
                    .addComponent(billframe, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemsearchKeyReleased
        try
        {
            String sql = "SELECT Item_Name FROM menuitem WHERE Item_Name LIKE CONCAT('%%',?,'%%') ;";
            String url = "jdbc:mysql://localhost:3306/flyingpotato";
            Connection con=DriverManager.getConnection(url, "root","root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,itemsearch.getText());
            ResultSet rs=ps.executeQuery();
            if(itemsearch.getText().length()>=2)
            {
                if(rs.next())
                {
                    searchname.setText(rs.getString("Item_Name"));
                }
                else
                {
                    searchname.setText("Not Found.");
                }
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_itemsearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        search();
        itemsearch.setText(null);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchnameMouseClicked
        itemsearch.setText(searchname.getText());
        search();
        searchname.setText(null);
        itemsearch.setText(null);
    }//GEN-LAST:event_searchnameMouseClicked

    private void order1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order1ActionPerformed
        
        if(!"0".equals(hunit.getValue().toString()) || !"0".equals(funit.getValue().toString()))
        {
            ordercollection oc=new ordercollection(c_id,name1.getText(),hprice1.getText(),hunit.getValue().toString(),fprice1.getText(),funit.getValue().toString());
            ordermenuitem.setVisible(false);
            billview();
            checkout.setVisible(true);
            billframe.setVisible(true);
            hunit.setValue(0);
            funit.setValue(0);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Select Number of Order.");
        }
    }//GEN-LAST:event_order1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        new homepage().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        try
        {
            new homepage().setVisible(true);
            this.dispose();
            String sql = "delete from costumer_order;";
            String url = "jdbc:mysql://localhost:3306/flyingpotato";
            Connection con=DriverManager.getConnection(url, "root","root");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        }
        catch(SQLException ex)
        {
            
        }
    }//GEN-LAST:event_checkoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Orderfood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orderfood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orderfood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orderfood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orderfood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JInternalFrame billframe;
    public javax.swing.JTable btable;
    private javax.swing.JButton cancle1;
    private javax.swing.JButton checkout;
    private javax.swing.JLabel fprice1;
    private javax.swing.JSpinner funit;
    private javax.swing.JLabel hprice1;
    private javax.swing.JSpinner hunit;
    private javax.swing.JLabel image1;
    private javax.swing.JTextField itemsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JButton order1;
    private javax.swing.JPanel ordermenuitem;
    private javax.swing.JLabel searchname;
    private javax.swing.JTable tab;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}