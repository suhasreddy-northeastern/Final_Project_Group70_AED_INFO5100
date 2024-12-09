/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Role;

import business.Business;
import business.Enterprise.Enterprise;
import business.Enterprise.MaintenanceTeamEnterprise;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.MaintenanceTeam.CleaningWorkArea;

public class GeneralMaintenanceRole extends Role {

    public GeneralMaintenanceRole() {
        this.type = Role.RoleType.GenMaint;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise organization, Business business) {
        this.type = Role.RoleType.GenMaint;
        return new CleaningWorkArea(userProcessContainer, account, (MaintenanceTeamEnterprise) organization, business);
    }

}
