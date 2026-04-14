/*package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class App {

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();

            // STEP 1: Open website
            driver.get("https://automationexercise.com");
            System.out.println("Opened website");
            sleep(2000);

            // STEP 2: Remove ad iframes
            List<WebElement> iframes = driver.findElements(By.cssSelector("iframe"));
            for (WebElement frame : iframes) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].style.display='none';", frame);
            }
            System.out.println("Removed ads");
            sleep(2000);

            // STEP 3: Click Products
            WebElement products = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
            highlight(driver, products);
            sleep(1000);
            products.click();
            System.out.println("Clicked Products");
            sleep(3000);

            // STEP 4: Wait for products page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items")));

            // STEP 5: Select first product
            WebElement firstProduct = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
            sleep(1000);

            highlight(driver, firstProduct);
            sleep(1000);

            // Click using JS (bypass ad overlay issues)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
            System.out.println("Clicked Add to Cart");
            sleep(3000);

            // STEP 6: Click Continue Shopping
            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue Shopping')]")));

            highlight(driver, continueBtn);
            sleep(1000);
            continueBtn.click();

            System.out.println("Clicked Continue Shopping");
            sleep(3000);

            System.out.println("✅ ALL STEPS COMPLETED SUCCESSFULLY");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sleep(5000); // keep browser open so you SEE result
            driver.quit();
        }
    }
}
*/

package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class App {

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {

        // ✅ HEADLESS CONFIG FOR JENKINS
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // STEP 1: Open website
            driver.get("https://automationexercise.com");
            System.out.println("Opened website");
            sleep(2000);

            // STEP 2: Remove ad iframes
            List<WebElement> iframes = driver.findElements(By.cssSelector("iframe"));
            for (WebElement frame : iframes) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].style.display='none';", frame);
            }
            System.out.println("Removed ads");
            sleep(2000);

            // STEP 3: Click Products
            WebElement products = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
            highlight(driver, products);
            sleep(1000);
            products.click();
            System.out.println("Clicked Products");
            sleep(3000);

            // STEP 4: Wait for products page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items")));

            // STEP 5: Select first product
            WebElement firstProduct = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
            sleep(1000);

            highlight(driver, firstProduct);
            sleep(1000);

            // Click using JS (bypass ad overlay issues)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
            System.out.println("Clicked Add to Cart");
            sleep(3000);

            // STEP 6: Click Continue Shopping
            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue Shopping')]")));

            highlight(driver, continueBtn);
            sleep(1000);
            continueBtn.click();

            System.out.println("Clicked Continue Shopping");
            sleep(3000);

            System.out.println("✅ ALL STEPS COMPLETED SUCCESSFULLY");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sleep(2000); // reduced wait for Jenkins
            driver.quit();
        }
    }
}
