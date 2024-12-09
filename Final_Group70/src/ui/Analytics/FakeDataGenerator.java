package ui.Analytics;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeDataGenerator {

    public static void main(String[] args) {
        // Initialize Faker
        Faker faker = new Faker();

        // Create a list to store WorkRequests
        List<JsonObject> workRequests = new ArrayList<>();

        // Generate 100 fake WorkRequests
        for (int i = 0; i < 100; i++) {
            JsonObject workRequest = new JsonObject();

            workRequest.addProperty("requestId", i + 1);
            workRequest.addProperty("type", "maintenance");
            workRequest.addProperty("status", "pending");
            workRequest.addProperty("message", faker.lorem().sentence());
            workRequest.addProperty("requestDate", faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toString());
            workRequest.addProperty("resolveDate", faker.date().future(365, java.util.concurrent.TimeUnit.DAYS).toString());
            workRequest.addProperty("sender", faker.name().fullName());
            workRequest.addProperty("receiver", faker.name().fullName());

            // Add workRequest to the list
            workRequests.add(workRequest);
        }

        // Convert list of WorkRequests to JSON
        JsonArray jsonArray = new JsonArray();

        // Add each workRequest to the JsonArray
        for (JsonObject workRequest : workRequests) {
            jsonArray.add(workRequest);
        }

        // Write the JSON data to a file
        try (FileWriter fileWriter = new FileWriter("src/ui/Analytics/WorkRequest.json")) {
            fileWriter.write(new Gson().toJson(jsonArray));
            System.out.println("Fake data generated and saved to WorkRequest.json.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
