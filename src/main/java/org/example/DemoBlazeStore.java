package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DemoBlazeStore {

    private JavaSingleton singleton = JavaSingleton.getInstance();
    private ChromeDriver driver;
    private WebDriver BrowserDriver;

    public void E2ETest(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Múltiples formas de deshabilitar notificaciones
        options.addArguments("--disable-notifications");           // Principal
        options.addArguments("--disable-popup-blocking");          // Bloquear popups
        options.addArguments("--disable-web-notifications");       // Notificaciones web

        // Configuración adicional recomendada
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        try{

            //System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver-win64/chromedriver.exe");

            driver.get("https://www.demoblaze.com/");
            driver.manage().window().maximize(); // Maximizar ventana

            singleton = JavaSingleton.getInstance();

        }catch(Exception e){
            System.out.println("Error E2ETest --> "+e.getMessage());
            driver.quit();
        }finally {
            singleton.setDriver(driver);
        }

    }

    // Escenario1: Login con usuario y contraseña a la pagina DemoBlaze
    public void Login(String username, String password){

        try{
            singleton.setUsername(username);
            singleton.setPassword(password);

            WebElement loginBtn = driver.findElement(By.xpath("//a[@id='login2']"));
            singleton.sleep_wait(3000);
            loginBtn.click();

            singleton.sleep_wait(4000);
            WebElement loginusername = driver.findElement(By.xpath("//input[@id='loginusername']"));
            loginusername.click();
            //loginusername.sendKeys(singleton.getUsername());
            singleton.TypeSlowly(loginusername,singleton.getUsername(),1000);

            WebElement loginpassword = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            loginpassword.click();
            loginpassword.sendKeys(singleton.getPassword());

            singleton.sleep_wait(2000);
            //WebElement loginbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Log in']"));

            loginbutton.click();

        }catch(Exception e_login){
            System.out.println("Error login() --> "+e_login.getMessage());
            driver.quit();
        }
    }

    //Escenario 2: Agregar 2 productos al carrito de compras
    public void AddCart(){
        try{

            driver.navigate().refresh();

            //Primer Item
            WebElement phones = driver.findElement(By.xpath("//a[text()='Phones']"));
            phones.click();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);"); //esta funcion de javascript hace sroll hacia abajo
            singleton.sleep_wait(3000);
            WebElement item1 = driver.findElement(By.xpath("//img[@src='imgs/xperia_z5.jpg']"));
            singleton.sleep_wait(5000);
            item1.click();
            singleton.sleep_wait(5000);
            Add();


            //Segundo Item
            singleton.sleep_wait(3000);
            WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
            laptops.click();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            singleton.sleep_wait(3000);
            WebElement item2 = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
            item2.click();
            singleton.sleep_wait(5000);
            Add();

        }catch(Exception e_AddCart){
            System.out.println("Error AddCart --> "+e_AddCart.getMessage());
            driver.quit();
        }

    }

    //Agrega el item seleccionado al carrito de compras
    public void Add() {
        WebElement addCartBtn = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        addCartBtn.click();

        // Wait for the alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Get alert text (optional)
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Accept the alert
        alert.accept();

        singleton.sleep_wait(5000);
        WebElement homeBtn = driver.findElement(By.xpath("//a[text()='Home ']"));
        homeBtn.click();
    }

    public void PurchaseItems(){

    }

    //Completar el formulario de compra
    public void FillForm(){

        try{
            singleton.sleep_wait(3000);
            WebElement fullname = driver.findElement(By.xpath("//input[@id='name']"));
            fullname.click();
            fullname.sendKeys(singleton.getInfo().getFullName());

            singleton.sleep_wait(3000);
            WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
            country.click();
            country.sendKeys(singleton.getInfo().getCountry());

            singleton.sleep_wait(3000);
            WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
            city.click();
            city.sendKeys(singleton.getInfo().getCity());

            singleton.sleep_wait(3000);
            WebElement card = driver.findElement(By.xpath("//input[@id='card']"));
            card.click();
            card.sendKeys(singleton.getInfo().getCreditCard());

            singleton.sleep_wait(3000);
            WebElement month = driver.findElement(By.xpath("//input[@id='month']"));
            month.click();
            month.sendKeys(singleton.getInfo().getMonth());

            singleton.sleep_wait(3000);
            WebElement year = driver.findElement(By.xpath("//input[@id='year']"));
            year.click();
            year.sendKeys(String.valueOf(singleton.getInfo().getYear()));

            singleton.sleep_wait(3000);
            WebElement purchase = driver.findElement(By.xpath("//button[text()='Purchase']"));
            purchase.click();

            singleton.sleep_wait(3000);
            WebElement OkBtn = driver.findElement(By.xpath("//button[text()='OK']"));
            OkBtn.click();
            driver.quit();

        }catch(Exception e_fill){
            System.out.println("Error e_fill --> "+e_fill.getMessage());
            driver.quit();
        }
    }

    //Visualizar el carrito de compras
    public void CheckCart(){
        try{

            WebElement viewCart = driver.findElement(By.xpath("//a[@id='cartur']"));
            singleton.sleep_wait(4000);
            viewCart.click();

            WebElement placeOrderBtn = driver.findElement(By.xpath("//button[text()='Place Order']"));
            singleton.sleep_wait(4000);
            placeOrderBtn.click();


        }catch(Exception e_check){
            System.out.println("Error e_check --> "+e_check.getMessage());
            driver.quit();
        }
    }

    public void initCustomer(){
        CustomerInfo info = new CustomerInfo("John Doe",
                "Ecuador",
                "Guayquil",
                "5112540616147899",
                "Junio",
                2026);
        singleton.setInfo(info);
    }

}
