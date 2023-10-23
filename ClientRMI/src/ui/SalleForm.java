/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import config.Config;
import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sun.font.FontManagerNativeLibrary.load;

/**
 *
 * @author Ouardine
 */
public class SalleForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form SalleForm
     */
    DefaultTableModel model = null;
    IDao<Machine> dao = null;
    IDao<Salle> dao2 = null;
    int id = -1;
    private static SalleForm sf;

    public SalleForm() {
       try {
            initComponents();
            dao2 = (IDao<Salle>) Naming.lookup("rmi://" + Config.ip + ":" + Config.port + "/dao2");
            dao = (IDao<Machine>) Naming.lookup("rmi://" + Config.ip + ":" + Config.port + "/dao");
            model = (DefaultTableModel) tableSalle.getModel();
            load();
        } catch (NotBoundException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static SalleForm getInstance() {
        if (sf == null) {
            sf = new SalleForm();
        }
        return sf;
    }

    public void load() {
        try {
            model.setRowCount(0);
            for (Salle s : dao2.findAll()) {
                model.addRow(new Object[]{
                    s.getId(),
                    s.getCode()
                });
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        BnAjouter = new javax.swing.JButton();
        BnModifier = new javax.swing.JButton();
        BnSupprimer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSalle = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("G Salle"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("informations salle"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Code :");

        BnAjouter.setBackground(new java.awt.Color(102, 102, 255));
        BnAjouter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BnAjouter.setForeground(new java.awt.Color(242, 242, 242));
        BnAjouter.setText("Ajouter");
        BnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnAjouterActionPerformed(evt);
            }
        });

        BnModifier.setBackground(new java.awt.Color(102, 102, 255));
        BnModifier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BnModifier.setForeground(new java.awt.Color(242, 242, 242));
        BnModifier.setText("Modifier");
        BnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnModifierActionPerformed(evt);
            }
        });

        BnSupprimer.setBackground(new java.awt.Color(102, 102, 255));
        BnSupprimer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BnSupprimer.setForeground(new java.awt.Color(242, 242, 242));
        BnSupprimer.setText("Supprimer");
        BnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(BnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BnAjouter)
                    .addComponent(BnModifier)
                    .addComponent(BnSupprimer))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tableSalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code"
            }
        ));
        tableSalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSalle);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnSupprimerActionPerformed
        // TODO add your handling code here:
          try {
            if (id != -1) {
                Salle salle = dao2.findByID(id);

                if (salle != null) {
                    int machineCount = countMachinesInSalle();
                    String message;
                    if (machineCount > 0) {
                        JOptionPane.showMessageDialog(this, "La salle contient " + machineCount + " machine(s), vous ne pouvez pas supprimer cette salle.");
                    } else {
                        message = "Voulez-vous vraiment supprimer cette salle ?";
                        int response = JOptionPane.showConfirmDialog(this, message, "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            dao2.delete(salle);
                            load();
                            id=-1;
                            JOptionPane.showMessageDialog(this, "La salle a été supprimée");
                        }
                    }
                } 
            } else {
                JOptionPane.showMessageDialog(this, "Vous devez sélectionner une salle dans la liste.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BnSupprimerActionPerformed

    private void BnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnAjouterActionPerformed
        // TODO add your handling code here:
         String code = txtCode.getText();
        try {
            dao2.create(new Salle(code));
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
        JOptionPane.showMessageDialog(this, "La salle a été ajoutée");
    }//GEN-LAST:event_BnAjouterActionPerformed

    private void BnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnModifierActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String code = txtCode.getText();
            Salle updatedSalle = new Salle(code);
            updatedSalle.setId(id);
            dao2.update(updatedSalle);
            load();
            JOptionPane.showMessageDialog(this, "La salle a été modifiée");
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BnModifierActionPerformed

    private void tableSalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSalleMouseClicked
        // TODO add your handling code here:
      
        int selectedRow = tableSalle.getSelectedRow();
        if (selectedRow != -1) {
            try {
                id = Integer.parseInt(tableSalle.getValueAt(selectedRow, 0).toString());
                txtCode.setText(dao2.findByID(id).getCode());
            } catch (RemoteException ex) {
                Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableSalleMouseClicked
 private int countMachinesInSalle() throws RemoteException {
        Salle salle = dao2.findByID(id);
        int count = 0;
        if (salle != null) {
            for (Machine machine : dao.findAll()) {
                Salle machineSalle = machine.getSalle();
                if (machineSalle != null && machineSalle.getId() == salle.getId()) {
                    count++;
                }
            }
        }

        return count;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BnAjouter;
    private javax.swing.JButton BnModifier;
    private javax.swing.JButton BnSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSalle;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
