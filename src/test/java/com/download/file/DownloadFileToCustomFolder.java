package com.download.file;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileToCustomFolder {
    public static void main(String[] args) {
        // path for your custom download folder
        String downloadFolderPath = "C:\\selenium-testng\\Testingselenium\\framework\\JenkinsDownloads";
        File jenkinsDownloadDir = new File(downloadFolderPath);

        if (!jenkinsDownloadDir.exists()) {
            System.out.println("Jenkins folder not present, creating it...");
            if (jenkinsDownloadDir.mkdir()) {
                System.out.println("Created Jenkins download directory!");
            } else {
                System.out.println("Failed to create directory — check permissions.");
            }
        } else {
            System.out.println("Jenkins folder already exists.");
        }

        // Chrome preferences
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("download.default_directory", downloadFolderPath);
        preferences.put("download.prompt_for_download", false);
        preferences.put("safebrowsing.enabled", "true");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", preferences);

        // specify your ChromeDriver executable path (adjust path if needed)
        WebDriver wd = new ChromeDriver(chromeOptions);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://get.jenkins.io/war-stable/2.528.1/jenkins.war");
        System.out.println("Browser launched and navigating to Jenkins download URL.");
    }
}
