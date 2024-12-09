package business.Organisation;

import java.util.Date;

public class Lease {

    private Date leaseStartDate;
    private Date leaseEndDate;
    private String leaseStatus; // "Pending", "Active", "Expired"
    private boolean isValidated; // Lease approval flag
    private String apartmentNumber;

    public Lease() {
        this.leaseStatus = "Pending"; // Default status
        this.isValidated = false;    // Default is not validated
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    // Getters and Setters
    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public String getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    // Method to update the lease status dynamically
    public void updateLeaseStatus() {
        Date currentDate = new Date();

        if (leaseEndDate != null && leaseEndDate.before(currentDate)) {
            leaseStatus = "Expired";
        } else if (isValidated && leaseStartDate != null && leaseEndDate != null
                && leaseStartDate.before(currentDate) && leaseEndDate.after(currentDate)) {
            leaseStatus = "Active";
        } else {
            leaseStatus = "Pending";
        }
    }

    @Override
    public String toString() {
        return "Lease{"
                + "leaseStartDate=" + leaseStartDate
                + ", leaseEndDate=" + leaseEndDate
                + ", leaseStatus='" + leaseStatus + '\''
                + ", isValidated=" + isValidated
                + ", apartmentNumber='" + apartmentNumber + '\''
                + '}';
    }

}
