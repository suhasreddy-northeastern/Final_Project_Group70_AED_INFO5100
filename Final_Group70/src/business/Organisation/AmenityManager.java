package business.Organisation;

import java.util.ArrayList;
import java.util.List;

public class AmenityManager {

    public List<String> getAvailableAmenities() {

        List<String> amenities = new ArrayList<>();
        amenities.add("Gym");
        amenities.add("Pool");
        amenities.add("Conference Room");
        amenities.add("Tennis Court");
        amenities.add("Sauna");
        return amenities;
    }

}
