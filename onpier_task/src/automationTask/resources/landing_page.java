package automationTask.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.junit.Assert;


public class landing_page {

    public static void navigateToLandingPage( WebDriver driver ) {
        String expectedTitle = "THG Prämie";
        driver.get("https://thg-greenair.dev.wgv.onpier.de/landing");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);  
    }

    public static void headerMenuTextShouldBe( WebDriver driver, String value, Integer index ){
        String actualMenuText = driver.findElement(By.xpath("//div[contains(@class,'flex items-center')]//a[" + index +"]")).getText();
        Assert.assertEquals(value, actualMenuText);
    }

    public static void clickMenuItem (WebDriver driver, int index ) {
        driver.findElement(By.xpath("//div[contains(@class,'flex items-center')]//a[" + index +"]")).click();
    }

    public static void sleep (WebDriver driver, int sleeptime){
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void sctionTitleShouldBePresent(WebDriver driver, String text, int index){
        String actualMenuText = driver.findElement(By.xpath("(//h2[contains(@class,'mb-0 pt-0')])[" + index +"]")).getText();
        Assert.assertEquals(text, actualMenuText);
    }

    public static void sectionContentClickable(WebDriver driver, Integer index ){
        driver.findElement(By.xpath("(//form[contains(@class,'flex flex-col')]//label)[" + index +"]")).click();
    }

    public static void closeBrowser( WebDriver driver){
        driver.quit();
    }

    public static void clickOnButton(WebDriver driver, String btnName){
        driver.findElement(By.xpath("//span[text()=' " + btnName + " ']//ancestor::button")).click();
    }

    public static void contentInPremiumModelShouldBe (WebDriver driver, String title, String price, String content){
        String actualTitle = driver.findElement(By.xpath("//p[contains(@class,'text-xl font-bold')]")).getText();
        Assert.assertEquals(title, actualTitle);
        String actualPrice = driver.findElement(By.xpath("//p[contains(@class,'text-4xl font-bold')]")).getText();
        Assert.assertEquals(price, actualPrice);
        String actualContent = driver.findElement(By.xpath("(//p[@class='p-0']//span)[1]")).getText();
        Assert.assertEquals(content, actualContent);
    }

    
}