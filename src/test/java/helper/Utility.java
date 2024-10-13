package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }
    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }
    public static WebDriver driver;
    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public static void quitDriver(){
        driver.quit();
    }

    public static List <String> productName(By lokasiProduk) {
        List<WebElement> elements = driver.findElements(lokasiProduk);
        List<String> productNames = new ArrayList<>();
        for (WebElement element : elements) {
            String namaProd = element.getText();
            productNames.add(namaProd);
        }
        return productNames;
    }
    public static double getSumAllItem() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double[] allItemPrice = new double[elements.size()];
        for (int i = 0; i < elements.size(); i++){
            allItemPrice[i] = Double.parseDouble(elements.get(i).getText());
        }
        double sumTotal = CountPrice.jumlahkan(allItemPrice);
        return sumTotal;
//        List<Double> prodPrice = new ArrayList<>();
//        for (WebElement element : elements) {
//            Double hargaProd = Double.parseDouble(element.getText());
//            prodPrice.add(hargaProd);
//        }
    }
}
