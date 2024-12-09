package ui.BuildingTeam;

import business.Business;
import business.EmailAlert.EmailAlert;
import business.Enterprise.BuildingTeamEnterprise;
import business.Organisation.Lease;
import business.Organisation.Organisation;
import business.Role.Role;
import business.UserAccount.UserAccount;
import business.WorkQueue.ServiceWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class LeasingTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private BuildingTeamEnterprise ent;
    private Business business;
    private UserAccount userAccount;

    public LeasingTeamWorkAreaJPanel(JPanel workArea, UserAccount account, BuildingTeamEnterprise ent, Business business) {
        initComponents();

        this.workArea = workArea;
        this.ent = ent;
        this.business = business;
        this.userAccount = account;
        populateLease();
        populate();
    }

    public void populateLease() {
        DefaultTableModel model = (DefaultTableModel) tblLease.getModel();
        model.setRowCount(0);

        for (WorkRequest work : ent.getWorkQueue().getWorkRequestList()) {
            if (work.getStatus().equals("sent")) {
                if (work.getType().equals("lease")) {
                    Object[] row = new Object[4];
                    row[0] = work;
                    row[1] = work.getSender().getId();

                    row[2] = work.getStatus();

                    model.addRow(row);
                }
            }
        }

    }

    public void populate() {
        DefaultTableModel model = (DefaultTableModel) tblResidents.getModel();
        model.setRowCount(0);

        for (Organisation org : ent.getOrganisationDirectory().getOrganisationList()) {
            for (UserAccount usracc : org.getUserAccountDirectory().getUserAccountList()) {
                if (usracc.getRole().type.equals(Role.RoleType.Residents)) {
                    Object[] row = new Object[4];
                    row[0] = usracc.getId();
                    row[1] = usracc.getUsername();
                    row[2] = usracc.isValidate(); // Fetch validate field from UserAccount
                    row[3] = usracc.getLease().getLeaseStatus(); // Fetch lease status

                    model.addRow(row);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Reports = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        leasedoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLease = new javax.swing.JTable();
        btnApproveLease = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRejectLease = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        resp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResidents = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnReports = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        Reports.setBackground(new java.awt.Color(204, 255, 204));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Total Residents", "Active leases", "Pending Leases", "Expiring Leases"
            }
        ));
        jScrollPane3.setViewportView(tblReport);

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        add(Reports, "card3");

        leasedoc.setBackground(new java.awt.Color(255, 204, 204));

        tblLease.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Resident", "ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblLease);

        btnApproveLease.setText("Approve Residents Lease Docs");
        btnApproveLease.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnApproveLease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveLeaseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Lease Docs Submitted by -");

        btnRejectLease.setText("Reject Residents Lease Docs");
        btnRejectLease.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRejectLease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectLeaseActionPerformed(evt);
            }
        });

        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leasedocLayout = new javax.swing.GroupLayout(leasedoc);
        leasedoc.setLayout(leasedocLayout);
        leasedocLayout.setHorizontalGroup(
            leasedocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leasedocLayout.createSequentialGroup()
                .addGroup(leasedocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leasedocLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                        .addGap(143, 143, 143))
                    .addGroup(leasedocLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton7))
                    .addGroup(leasedocLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(leasedocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leasedocLayout.createSequentialGroup()
                                .addComponent(btnApproveLease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)
                                .addComponent(btnRejectLease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(126, 126, 126))
        );
        leasedocLayout.setVerticalGroup(
            leasedocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leasedocLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(leasedocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproveLease, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRejectLease, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton7)
                .addGap(88, 88, 88))
        );

        add(leasedoc, "card4");

        resp.setBackground(new java.awt.Color(255, 204, 204));

        tblResidents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "AptNo.", "Resident", "Lease Approved"
            }
        ));
        jScrollPane2.setViewportView(tblResidents);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel2.setText("Residents");

        jButton9.setText("Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout respLayout = new javax.swing.GroupLayout(resp);
        resp.setLayout(respLayout);
        respLayout.setHorizontalGroup(
            respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respLayout.createSequentialGroup()
                .addGroup(respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(respLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton9))
                    .addGroup(respLayout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addGroup(respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(respLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(597, Short.MAX_VALUE))
        );
        respLayout.setVerticalGroup(
            respLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(78, 78, 78))
        );

        add(resp, "card5");

        jPanel1.setBackground(new java.awt.Color(253, 211, 191));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Leasing Team Work Area");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReports.setBackground(new java.awt.Color(204, 102, 255));
        btnReports.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnReports.setText("Reports");
        btnReports.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton2.setText("Lease Documentation");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton3.setText("Residents Portal");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(327, 327, 327)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGap(417, 417, 417)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(249, 249, 249)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(332, 332, 332)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addGap(303, 303, 303)))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel1.setVisible(false);
        Reports.setVisible(false);
        resp.setVisible(true);
        leasedoc.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.setVisible(false);
        Reports.setVisible(false);
        resp.setVisible(false);
        leasedoc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnApproveLeaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveLeaseActionPerformed
        // Get the selected row index
        int selectedRowIndex = tblLease.getSelectedRow();

        if (selectedRowIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) tblLease.getModel();
            WorkRequest w = (WorkRequest) model.getValueAt(selectedRowIndex, 0);

            // Approve the lease
            w.setStatus("approved");
            UserAccount sender = w.getSender();

            // Set lease details using the Lease class
            Lease lease = sender.getLease();
            lease.setValidated(true);  // Mark lease as validated
            sender.setValidate(true);  // Ensure UserAccount validate flag is also updated
            lease.setLeaseStartDate(new Date()); // Start date as today
            lease.setLeaseEndDate(new Date(System.currentTimeMillis() + (365L * 24 * 60 * 60 * 1000))); // 1 year
            lease.updateLeaseStatus();

            // Now, populate tblResidents to get the Apartment Number
            String aptNumber = null;
            DefaultTableModel residentModel = (DefaultTableModel) tblResidents.getModel();

            // Loop through the residents table to find the apartment number
            for (int i = 0; i < residentModel.getRowCount(); i++) {
                // Get the resident ID from the table row
                Object residentId = residentModel.getValueAt(i, 0); // Assuming it's in the first column (AptNo.)
                if (residentId != null && residentId.equals(sender.getId())) {
                    // Get the apartment number from the appropriate column (AptNo.)
                    aptNumber = String.valueOf(residentModel.getValueAt(i, 0)); // Assuming apartment number is in the first column
                    break;
                }
            }

            // Check if email exists before sending
            String email = sender.getEmail(); // Assuming the sender is the resident

            // Skip email sending if no email is found
            if (email != null && !email.isEmpty()) {
                // Send email to resident after approval
                String approverName = userAccount.getUsername();  // Corrected: Use userAccount instead of account
                EmailAlert emailAlert = new EmailAlert();
                emailAlert.sendLeaseStatusEmail(email, "Lease Approved", "Your lease for Apartment " + aptNumber + " has been approved by " + approverName + ".");
            } else {
                // Log or inform that the email could not be sent because it's empty or null
                System.out.println("No email found for the resident. Skipping email notification.");
            }

            JOptionPane.showMessageDialog(null, "Approved documents");
            populateLease();
            populate();  // Update residents table
        } else {
            JOptionPane.showMessageDialog(null, "Select a Row");
        }
    }//GEN-LAST:event_btnApproveLeaseActionPerformed

    private void populateReportTable() {
        DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
        model.setRowCount(0);

        int totalResidents = 0;
        int activeLeases = 0;
        int pendingLeases = 0;
        int expiringLeases = 0;

        Date currentDate = new Date();
        long thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000;

        // Iterate through residents and calculate metrics
        for (Organisation org : ent.getOrganisationDirectory().getOrganisationList()) {
            for (UserAccount usracc : org.getUserAccountDirectory().getUserAccountList()) {
                if (usracc.getRole().type.equals(Role.RoleType.Residents)) {
                    totalResidents++;

                    // Update lease status dynamically
                    Lease lease = usracc.getLease();
                    lease.updateLeaseStatus();

                    // Count active, pending, and expiring leases
                    if ("Active".equals(lease.getLeaseStatus())) {
                        activeLeases++;

                        // Check if the lease is expiring within the next 30 days
                        if (lease.getLeaseEndDate() != null
                                && lease.getLeaseEndDate().getTime() - currentDate.getTime() <= thirtyDaysInMillis) {
                            expiringLeases++;
                        }
                    } else if ("Pending".equals(lease.getLeaseStatus())) {
                        pendingLeases++;
                    }
                }
            }
        }

        // Add data to the report table
        model.addRow(new Object[]{totalResidents, activeLeases, pendingLeases, expiringLeases});
    }


    private void btnRejectLeaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectLeaseActionPerformed
        // Get the selected row index
        int selectedRowIndex = tblLease.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex != -1) { // -1 indicates no row is selected
            // Get the data from the selected row in the model
            DefaultTableModel model = (DefaultTableModel) tblLease.getModel();
            WorkRequest w = (WorkRequest) model.getValueAt(selectedRowIndex, 0);

            // Reject the lease
            w.setStatus("rejected");
            UserAccount sender = w.getSender();

            // Set lease details using the Lease class
            Lease lease = sender.getLease();
            lease.setValidated(false);  // Mark lease as not validated
            sender.setValidate(false);  // Ensure UserAccount validate flag is also updated

            // Now, populate tblResidents to get the Apartment Number
            String aptNumber = null;
            DefaultTableModel residentModel = (DefaultTableModel) tblResidents.getModel();

            // Loop through the residents table to find the apartment number
            for (int i = 0; i < residentModel.getRowCount(); i++) {
                // Get the resident ID from the table row
                Object residentId = residentModel.getValueAt(i, 0); // Assuming it's in the first column (AptNo.)
                if (residentId != null && residentId.equals(sender.getId())) {
                    // Get the apartment number from the appropriate column (AptNo.)
                    aptNumber = String.valueOf(residentModel.getValueAt(i, 0)); // Assuming apartment number is in the first column
                    break;
                }
            }

            // Check if email exists before sending
            String email = sender.getEmail(); // Assuming the sender is the resident

            // Skip email sending if no email is found
            if (email != null && !email.isEmpty()) {
                // Send email to resident after rejection
                String approverName = userAccount.getUsername();  // Corrected: Use userAccount instead of account
                EmailAlert emailAlert = new EmailAlert();
                emailAlert.sendLeaseStatusEmail(email, "Lease Rejected", "Your lease for Apartment " + aptNumber + " has been rejected by " + approverName + ".");
            } else {
                // Log or inform that the email could not be sent because it's empty or null
                System.out.println("No email found for the resident. Skipping email notification.");
            }

            JOptionPane.showMessageDialog(null, "Rejected documents");
            populateLease();
            populate();  // Update residents table
        } else {
            JOptionPane.showMessageDialog(null, "Select a Row");
        }
    }//GEN-LAST:event_btnRejectLeaseActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        leasedoc.setVisible(false);
        jPanel1.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Reports.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        resp.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        jPanel1.setVisible(false);
        Reports.setVisible(true);
        resp.setVisible(false);
        leasedoc.setVisible(false);

        // Populate the report table
        populateReportTable();
    }//GEN-LAST:event_btnReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Reports;
    private javax.swing.JButton btnApproveLease;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRejectLease;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel leasedoc;
    private javax.swing.JPanel resp;
    private javax.swing.JTable tblLease;
    private javax.swing.JTable tblReport;
    private javax.swing.JTable tblResidents;
    // End of variables declaration//GEN-END:variables

}
