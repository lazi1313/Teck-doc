import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EndToEndV2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/dev/webDrivers/chrome/chromedriver.exe");
        // Initialize the browser
        WebDriver driver = new ChromeDriver();
        //Driver gets the AUT link then add implicitlyWait and maximize the window
        driver.get("http://advantageonlineshopping.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.id("speakersImg")).click();
        driver.findElement(By.id("20")).click();
        driver.findElement(By.className("plus")).click();
        driver.findElement(By.name("save_to_cart")).click();
        driver.findElement(By.id("menuCart")).click();
        driver.findElement(By.id("checkOutButton")).click();
        driver.findElement(By.cssSelector("input[name=usernameInOrderPayment]")).sendKeys("KrasimirQAE");
        driver.findElement(By.cssSelector("input[name=passwordInOrderPayment]")).sendKeys("Passw0rd");
        // Put a sleep statement if a problem happen
        Thread.sleep(1000);
        driver.findElement(By.id("login_btnundefined")).click();
        // if (loginButton.isEnabled()) {
        //   loginButton.click();
        //} else {
        //   System.out.println("Login button is not enabled");
        //}
        driver.findElement(By.cssSelector("button#next_btn")).click();
        driver.findElement(By.id("pay_now_btn_MasterCredit")).click();
        //driver.findElement(By.cssSelector("input[name=masterCredit]")).click();
        //driver.findElement(By.id("creditCard")).sendKeys("222233334444");
        // defect with cvv number
        //driver.findElement(By.name("cvv_number")).sendKeys("2405");
        //driver.findElement(By.name("cardholder_name")).sendKeys("Chris");
        //driver.findElement(By.id("pay_now_btn_ManualPayment")).click();
        //WebElement payNowButton = driver.findElement(By.id("login_btnundefined"));
        //if (payNowButton.isEnabled()) {
        //payNowButton.click();
        //} else {
        //System.out.println("Pay Now button is not enabled");
        //}
        // without this sleep value is invisible yet
        Thread.sleep(1000);
        // get the tracking # and print the value trackingNumberLabel
        WebElement trackingNumber = driver.findElement(By.cssSelector("label#trackingNumberLabel"));
        // get the order # and print it with tracking #
        WebElement orderNumber = driver.findElement(By.cssSelector("label#orderNumberLabel"));
        System.out.println("Tracking number is: " + trackingNumber.getText() + "\nOrder number is: " + orderNumber.getText());

        //------------------------------- this is something I added on my own
        String msg = driver.findElement(By.xpath("//*[@id='orderPaymentSuccess']/h2/span")).getText();
        if (msg.equals("Thank you for buying with Advantage"))
            System.out.println("Test PASSED. Value match the text/element as expected");
        else {
            System.out.println("Test FAILED. Value DOES NOT match the text/element as expected");
        }


    }
}
