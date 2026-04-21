package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JavaSingleton {
    private static JavaSingleton instance;
    public String value;

    private String username;
    private String password;
    private CustomerInfo info;

    public CustomerInfo getInfo() {
        return info;
    }

    public void setInfo(CustomerInfo info) {
        this.info = info;
    }

    private WebDriver driver;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep_wait(int miliseconds){
        try {
            Thread.sleep(miliseconds); // duerme el hilo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void TypeSlowly(WebElement element, String text, long delayMs){
        Actions actions = new Actions(getDriver());

        try{
            for (char c : text.toCharArray()) {
                actions.sendKeys(element, String.valueOf(c))
                        .pause(java.time.Duration.ofMillis(delayMs))
                        .perform();
            }

        }catch(Exception e){
            System.out.println("Error TypeSlowly-->: " + e.getMessage());
        }
    }


    private JavaSingleton(){

    }

    public static JavaSingleton getInstance() {
        // Check if the instance is null (not yet created)
        if (instance == null) {
            // If null, create a new instance
            instance = new JavaSingleton();
        }
        // Return the existing or newly created instance
        return instance;
    }
}
