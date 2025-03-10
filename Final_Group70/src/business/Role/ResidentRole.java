package business.Role;

import business.Business;
import business.Enterprise.BuildingTeamEnterprise;
import business.Enterprise.Enterprise;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.BuildingTeam.ResidentWorkArea;

public class ResidentRole extends Role {

    private static int id = 0;
    private boolean validate;
    private UserAccount userAccount;

    public ResidentRole() {
        this.type = RoleType.Residents;
        this.validate = false; // Set default value for validate to false
        this.userAccount = userAccount;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Getter and Setter for validate
    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public static ResidentRole createResidentRole() {
        ResidentRole residentRole = new ResidentRole();
        residentRole.setId(id++);

        return residentRole;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise organization, Business business) {
        this.type = RoleType.Residents;
        return new ResidentWorkArea(userProcessContainer, account, (BuildingTeamEnterprise) organization, business);
    }
}
