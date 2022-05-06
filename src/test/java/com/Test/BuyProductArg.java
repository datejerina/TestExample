package com.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BuyProductArg {
	
	private WebDriver driver;
	
	@Test
    public void testMLArg() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chomedriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
        
        String title = driver.getTitle(); 
        
        assertTrue(title.contains("Mercado Libre"));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        WebElement searchBox = driver.findElement(By.name("as_word"));
        WebElement searchButton = driver.findElement(By.className("nav-icon-search"));
        
        searchBox.sendKeys("Iphone 11");
        searchButton.click();
        
    
        WebElement searchItem = driver.findElement(By.className("ui-search-item__title"));
        searchItem.click();
       

        //WebElement cartButton = driver.findElement(By.xpath("//button[text()='Comprar ahora']"));
        WebElement cartButton = driver.findElement(By.cssSelector("button[class='andes-button andes-button--loud']"));

        //WebElement cartButton = driver.findElement(By.xpath("//*[@id="buybox-form"]/div[6]/div/button[1]"));
        //WebElement cartButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div[1]/div[2]/div/div[1]/form/div[6]/div/button[1]"));
        
     // Create instance of JavaScript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
     // now execute query which actually will scroll until that element is not appeared on page.
        
        je.executeScript("arguments[0].scrollIntoView(true);",cartButton);
        
        cartButton.click();
        
        
        WebElement message = driver.findElement(By.className("center-card__title")); 
        String txtMessage = message.getText();
        
        assertTrue(txtMessage.contains("Para comprar, ingresá a tu cuenta"));
        
        driver.quit();
    }
}