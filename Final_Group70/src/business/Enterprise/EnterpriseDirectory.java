package business.Enterprise;

import business.Enterprise.Enterprise.Type;
import business.Organisation.OrganisationDirectory;
import business.Role.ElectricianTeamRole;
import business.Role.Supervisor;
import java.util.ArrayList;

public class EnterpriseDirectory {

    private ArrayList<Enterprise> EnterpriseList;

    public EnterpriseDirectory() {
        EnterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return EnterpriseList;
    }

    public Enterprise createenterprise(Type type) {
        Enterprise Enterprise = null;
        if (type.getValue().equals(Type.Building_Team.getValue())) {
            Enterprise = new BuildingTeamEnterprise();
            EnterpriseList.add(Enterprise);
        } else if (type.getValue().equals(Type.Pest_Control_Organisation.getValue())) {
            Enterprise = new PestControlEnterprise();
            EnterpriseList.add(Enterprise);
        } else if (type.getValue().equals(Type.Maintenance_Team.getValue())) {
            Enterprise = new MaintenanceTeamEnterprise();
            EnterpriseList.add(Enterprise);
        } else if (type.getValue().equals(Type.Packaging_Team.getValue())) {
            Enterprise = new PackagingTeamEnterprise();
            EnterpriseList.add(Enterprise);
        }
        return Enterprise;
    }
}
