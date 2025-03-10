package business.Role;

import business.Business;
import business.Enterprise.MaintenanceTeamEnterprise;
import business.Enterprise.Enterprise;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.MaintenanceTeam.CleaningWorkArea;

public class CleaningRole extends Role {

    public CleaningRole() {
        this.type = Role.RoleType.Cleaning;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise organization, Business business) {
        this.type = Role.RoleType.Cleaning;
        return new CleaningWorkArea(userProcessContainer, account, (MaintenanceTeamEnterprise) organization, business);
    }

}
