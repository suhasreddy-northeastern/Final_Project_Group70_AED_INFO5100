package ui.BuildingTeam;

import business.Business;
import business.Enterprise.BuildingTeamEnterprise;
import business.Enterprise.Enterprise;
import business.Organisation.Organisation;
import business.UserAccount.UserAccount;
import business.WorkQueue.ServiceWorkRequest;
import business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suhasreddybr
 */
public class SecurityWorkArea extends javax.swing.JPanel {

    Business business;
    JPanel userProcessContainer;
    UserAccount account;
    BuildingTeamEnterprise par;

    /**
     * Creates new form SecurityWorkArea
     */
    public SecurityWorkArea(Business business) {
        this.business = business; // Initialize the business variable
        initComponents();         // Initialize the UI components
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSecurity = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        txtAptNo = new javax.swing.JTextField();
        txtPurpose = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        jComboBoxFromTime = new javax.swing.JComboBox<>();
        to = new javax.swing.JLabel();
        jComboBoxToTime = new javax.swing.JComboBox<>();
        lblName = new javax.swing.JLabel();
        lblAptNo = new javax.swing.JLabel();
        lblPurpose = new javax.swing.JLabel();
        btnSubmitVisitor = new javax.swing.JButton();

        tblSecurity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Apt", "Time", "Purpose", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblSecurity);

        lblTime.setText("Time:");

        jComboBoxFromTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFromTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFromTimeActionPerformed(evt);
            }
        });

        to.setText("to");

        jComboBoxToTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblName.setText("Name:");

        lblAptNo.setText("Apt. No:");

        lblPurpose.setText("Purpose:");

        btnSubmitVisitor.setText("Submit");
        btnSubmitVisitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitVisitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAptNo)
                                    .addComponent(lblName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAptNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPurpose)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSubmitVisitor)
                                    .addComponent(txtPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblTime)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(to)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxToTime, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAptNo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxToTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(to)
                            .addComponent(lblTime))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPurpose))
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmitVisitor)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFromTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFromTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFromTimeActionPerformed

    private void btnSubmitVisitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitVisitorActionPerformed
        // Get input data from the form
        String visitorName = txtName.getText();
        String apartmentNumber = txtAptNo.getText();
        String purpose = txtPurpose.getText();
        String fromTime = (String) jComboBoxFromTime.getSelectedItem();
        String toTime = (String) jComboBoxToTime.getSelectedItem();

        // Validate that all fields are filled
        if (visitorName.isEmpty() || apartmentNumber.isEmpty() || purpose.isEmpty() || fromTime.isEmpty() || toTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new work request for the visitor
        ServiceWorkRequest visitorRequest = new ServiceWorkRequest();
        visitorRequest.setType("Visitor");
        visitorRequest.setMessage(apartmentNumber); // Use apartment number as the message
        visitorRequest.setPurpose(purpose);
        visitorRequest.setVisitorName(visitorName);
        visitorRequest.setTime(fromTime + " to " + toTime);
        visitorRequest.setStatus("Pending");

        // Add to the respective resident's work queue
        boolean residentFound = false;
        // Iterate through all enterprises in the Business object
        for (Enterprise enterprise : business.getEnterpriseDirectory().getEnterpriseList()) {
            // Loop through all organizations in the enterprise
            for (Organisation organisation : enterprise.getOrganisationDirectory().getOrganisationList()) {
                // Loop through all user accounts in the organisation
                for (UserAccount residentAccount : organisation.getUserAccountDirectory().getUserAccountList()) {
                    // Check if the apartment number matches the resident's ID
                    if (residentAccount.getId() == Integer.parseInt(apartmentNumber)) {

                        // Add the visitor request to the resident's work queue
                        residentAccount.getWorkQueue().getWorkRequestList().add(visitorRequest);
                        residentFound = true;
                        break;  // Exit the loop once the resident is found
                    }
                }
                if (residentFound) {
                    break;  // Exit the organisation loop if the resident was found
                }
            }
            if (residentFound) {
                break;  // Exit the enterprise loop if the resident was found
            }
        }

        // Display appropriate message based on whether the resident was found or not
        if (residentFound) {
            JOptionPane.showMessageDialog(this, "Visitor request sent to resident.");
            // Refresh the Security table to show the updated request
            populateSecurityTable();
        } else {
            JOptionPane.showMessageDialog(this, "No resident found for the specified apartment number.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear the input fields
        txtName.setText("");
        txtAptNo.setText("");
        txtPurpose.setText("");
        jComboBoxFromTime.setSelectedIndex(0);
        jComboBoxToTime.setSelectedIndex(0);
    }//GEN-LAST:event_btnSubmitVisitorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitVisitor;
    private javax.swing.JComboBox<String> jComboBoxFromTime;
    private javax.swing.JComboBox<String> jComboBoxToTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAptNo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPurpose;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblSecurity;
    private javax.swing.JLabel to;
    private javax.swing.JTextField txtAptNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPurpose;
    // End of variables declaration//GEN-END:variables
private void populateSecurityTable() {
        DefaultTableModel model = (DefaultTableModel) tblSecurity.getModel();
        model.setRowCount(0);

        // Ensure the business object is properly initialized
        if (business == null || business.getEnterpriseDirectory() == null) {
            JOptionPane.showMessageDialog(this, "Business object or EnterpriseDirectory is not initialized.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Loop through all enterprises in the EnterpriseDirectory
        for (Enterprise enterprise : business.getEnterpriseDirectory().getEnterpriseList()) {
            // Loop through all organizations in the enterprise
            for (Organisation organisation : enterprise.getOrganisationDirectory().getOrganisationList()) {
                // Loop through all user accounts in the organization
                for (UserAccount residentAccount : organisation.getUserAccountDirectory().getUserAccountList()) {
                    // Loop through all work requests for the resident account
                    for (WorkRequest request : residentAccount.getWorkQueue().getWorkRequestList()) {
                        // Check if the work request is a visitor request
                        if (request instanceof ServiceWorkRequest && "Visitor".equals(request.getType())) {
                            ServiceWorkRequest visitorRequest = (ServiceWorkRequest) request;

                            // Populate the table row with visitor request details
                            Object[] row = new Object[5];
                            row[0] = visitorRequest.getVisitorName();  // Visitor Name
                            row[1] = visitorRequest.getMessage();      // Apartment Number
                            row[2] = visitorRequest.getTime();         // Time Slot
                            row[3] = visitorRequest.getPurpose();      // Purpose
                            row[4] = visitorRequest.getStatus();       // Status (Pending, Approved, Rejected)

                            model.addRow(row);  // Add row to the table model
                        }
                    }
                }
            }
        }
    }

}
