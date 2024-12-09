package ui.Analytics;

import business.Enterprise.MaintenanceTeamEnterprise;
import business.WorkQueue.WorkRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MaintenanceAnalyticsJPanel extends javax.swing.JPanel {

    private MaintenanceTeamEnterprise ent;
    private JPanel userProcessContainer;
    private javax.swing.JPanel chartContainer;
    private JButton btnBack;

    /**
     * Creates new form MaintenanceAnalyticsJPanel
     */
    public MaintenanceAnalyticsJPanel(JPanel userProcessContainer, MaintenanceTeamEnterprise ent) {
        initComponents();
        this.ent = ent;
        this.userProcessContainer = userProcessContainer;

        // Initialize chartContainer
        chartContainer = new javax.swing.JPanel();
        chartContainer.setLayout(new java.awt.CardLayout()); // Add CardLayout to chartContainer

        // Initialize and style the back button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        btnBack.setForeground(Color.WHITE); // Set text color to white
        btnBack.setBackground(new Color(61, 185, 255)); // Set background color
        btnBack.setBorder(new BevelBorder(BevelBorder.RAISED)); // Add bevel border
        btnBack.setFocusPainted(false); // Remove the focus border
        btnBack.setToolTipText("Click to go back to the previous page"); // Add a tooltip
        btnBack.setPreferredSize(new java.awt.Dimension(150, 40)); // Set size of the button
        btnBack.addActionListener(evt -> btnBackActionPerformed(evt));

        showMaintenanceAnalytics();
    }

    public void showMaintenanceAnalytics() {
        // Read JSON data from file with absolute path
        JsonArray workRequests = readWorkRequestsFromFile("src/ui/Analytics/WorkRequest.json");

        // Create a map to store the number of requests per month
        Map<String, Integer> monthlyRequestCount = new HashMap<>();

        // Iterate through all the work requests
        for (int i = 0; i < workRequests.size(); i++) {
            JsonObject workRequest = workRequests.get(i).getAsJsonObject();
            if ("maintenance".equals(workRequest.get("type").getAsString())) {
                String requestDate = workRequest.get("requestDate").getAsString();
                try {
                    // Use SimpleDateFormat to parse the date correctly
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy"); // Example: Thu Dec 07 15:00:00 GMT 2023
                    Date date = formatter.parse(requestDate); // Parse date

                    // Create calendar instance and set the parsed date
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int month = cal.get(Calendar.MONTH); // Get the month
                    int year = cal.get(Calendar.YEAR); // Get the year
                    String monthYear = (year + "-" + (month + 1)); // Format as "yyyy-MM"

                    // Increment the count for this month
                    monthlyRequestCount.put(monthYear, monthlyRequestCount.getOrDefault(monthYear, 0) + 1);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error parsing date: " + requestDate);
                }
            }
        }

        // Prepare dataset for the chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to dataset
        for (Map.Entry<String, Integer> entry : monthlyRequestCount.entrySet()) {
            dataset.addValue(entry.getValue(), "Requests", entry.getKey());
        }

        // Create the chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Monthly Maintenance Requests", // Chart title
                "Month", // X-axis label
                "Number of Requests", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                true, // Include legend
                true, // Tooltips
                false // URLs
        );

        // Create a panel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(false);

        // Add the chart panel to the chartContainer
        chartContainer.removeAll();
        chartContainer.add(chartPanel);
        chartContainer.revalidate();
        chartContainer.repaint();

        // Add the chartContainer and back button to the main layout
        this.setLayout(new java.awt.BorderLayout());
        this.add(chartContainer, java.awt.BorderLayout.CENTER);
        this.add(btnBack, java.awt.BorderLayout.SOUTH);
    }

    private JsonArray readWorkRequestsFromFile(String filename) {
        JsonArray workRequests = new JsonArray();
        try (FileReader reader = new FileReader(filename)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            // Check if the JSON is an array before accessing it
            if (jsonElement.isJsonArray()) {
                workRequests = jsonElement.getAsJsonArray();
            } else {
                System.out.println("Expected JSON array but found: " + jsonElement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workRequests;
    }

    // Back button action handler
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 233, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
