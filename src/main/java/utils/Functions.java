package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Functions {

    // Method to start and stop the Allure server
    public static void startAndStopAllureServe() throws IOException, InterruptedException {
        // Construct the Maven command for running Allure serve
        String mavenCommand = "allure serve \"target/allure-results\"";
        String projectpath = Paths.get("").toAbsolutePath().toString();
        // Start the Allure server process using ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", mavenCommand);
        processBuilder.directory(new java.io.File(projectpath)); // Set project directory

        // Start the Allure server
        Process allureProcess = processBuilder.start();

        // Capture the output from the server process
        BufferedReader reader = new BufferedReader(new InputStreamReader(allureProcess.getInputStream()));

        // Start a thread to read and display the output from the Allure server
        Thread outputThread = new Thread(() -> {
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Print the output from the server
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        outputThread.start();

        // Simulate some work or delay (e.g., let the server run for 10 seconds)
        Thread.sleep(10000); // You can adjust the time duration here

        // Stop the Allure server
        if (allureProcess.isAlive()) {
            allureProcess.destroy();  // Gracefully stop the process
            System.out.println("Allure server stopped gracefully.");
        } else {
            System.out.println("No Allure server process to stop.");
        }

    }

}
