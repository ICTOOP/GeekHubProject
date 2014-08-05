/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitnessmember;

import Fitnessmember.controllers.AddmemberJpaController;
import Fitnessmember.entities.Addmember;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Owner
 */
public class formmem extends javax.swing.JPanel {

    /**
     * Creates new form
     *
     */
    Addmember con;

    AddmemberJpaController addmemberJpaController;
    form parent;

    public formmem() {
        initComponents();
    }

    public formmem(form parent) {

        initComponents();
        this.parent = parent;
        addmemberJpaController = new AddmemberJpaController(Datamember.getInstance().getEmf());
        refreshTable();

        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {

                if (lse.getValueIsAdjusting() && jTable3.getSelectedRow() != -1) {

                    int row = jTable3.getSelectedRow();
                    con = ((MemberTableModel) jTable3.getModel()).getMembers().get(row);
                    Addmember c = con;

                    Firstname.setText(c.getFirstname());
                    Lastname.setText(c.getLastname());
                    Address.setText(c.getAddress());
                    Phone.setText(c.getPhone());
                    try {
                        if (c.getGander().equalsIgnoreCase("men")) {
                            men.setSelected(true);
                            women.setSelected(false);
                        } else {
                            women.setSelected(true);
                            men.setSelected(false);
                        }
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }

                }

            }
        });

    }

    public void refreshTable() {

        MemberTableModel tableModel = new MemberTableModel();

        java.util.List<Addmember> members = addmemberJpaController.findAddmemberEntities();

        tableModel.setMembers(members);

        jTable3.setModel(tableModel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formmem = new javax.swing.JPanel();
        Firstname = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        men = new javax.swing.JRadioButton();
        women = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Lastname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Phone");

        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });

        Phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        men.setText("Male");
        men.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menActionPerformed(evt);
            }
        });

        women.setText("Female");
        women.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                womenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Gander");

        jScrollPane3.setViewportView(jTable3);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("ข้อมูลสมาชิก");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Firstname");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Lastname");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Address");

        javax.swing.GroupLayout formmemLayout = new javax.swing.GroupLayout(formmem);
        formmem.setLayout(formmemLayout);
        formmemLayout.setHorizontalGroup(
            formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formmemLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formmemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formmemLayout.createSequentialGroup()
                        .addComponent(men)
                        .addGap(18, 18, 18)
                        .addComponent(women))
                    .addComponent(Firstname, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(Phone, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(Lastname))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formmemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addGap(128, 128, 128))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        formmemLayout.setVerticalGroup(
            formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formmemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formmemLayout.createSequentialGroup()
                        .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formmemLayout.createSequentialGroup()
                                .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(men, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(women, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formmemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        add(formmem, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int row = jTable3.getSelectedRow();
        con = ((MemberTableModel) jTable3.getModel()).getMembers().get(row);
        Addmember c = this.con;

        c.setFirstname(Firstname.getText());
        c.setLastname(Lastname.getText());
        c.setAddress(Address.getText());
        c.setPhone(Phone.getText());
        c.setGander(gander);

        try {
            addmemberJpaController.edit(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void womenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_womenActionPerformed
        // TODO add your handling code here:
        gander = "women";
    }//GEN-LAST:event_womenActionPerformed

    private void menActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menActionPerformed
        // TODO add your handling code here:
        gander = "men";
    }//GEN-LAST:event_menActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        Addmember c = new Addmember();

        c.setFirstname(Firstname.getText());

        c.setLastname(Lastname.getText());
        c.setAddress(Address.getText());
        c.setPhone(Phone.getText());
        c.setGander(gander);

        {
            JOptionPane.showMessageDialog(null, "Save");
        }

        addmemberJpaController.create(c);

        refreshTable();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void PhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            // TODO add your handling code here:
            int row = jTable3.getSelectedRow();
            con = ((MemberTableModel) jTable3.getModel()).getMembers().get(row);
            addmemberJpaController.destroy(con.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JTextField Firstname;
    private javax.swing.JTextField Lastname;
    private javax.swing.JTextField Phone;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel formmem;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JRadioButton men;
    private javax.swing.JButton updateButton;
    private javax.swing.JRadioButton women;
    // End of variables declaration//GEN-END:variables
    private String gander;
}
