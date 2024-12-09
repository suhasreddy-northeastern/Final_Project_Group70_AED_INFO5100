package business.WorkQueue;

public class DeliveryWorkRequest extends WorkRequest {
// Add specific fields related to delivery

    private String deliveryDetails;

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    @Override
    public String toString() {
        return "DeliveryWorkRequest{"
                + "deliveryDetails='" + deliveryDetails + '\''
                + '}';
    }

}
