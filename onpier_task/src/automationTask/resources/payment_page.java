package automationTask.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;


public class payment_page {

    public static void uploadFilePageShouldBeLoaded (WebDriver driver, String text){
        String actualText = driver.findElement(By.xpath("//app-step1[@class='ng-star-inserted']//h2[1]")).getText();
        Assert.assertEquals(text, actualText); 
    }

    public static void uploadFile (WebDriver driver, String fieldName){
        driver.findElement(By.xpath("(//span[text()='"+fieldName+"']/following::input)[1]")).sendKeys("<FILD-PATH>");
        // please give the file path that needs to uploaded. Replace <FILD-PATH> to file path
    }

    public static void paymentDetailsPageShouldBeLoaded (WebDriver driver, String text){
        String actualText = driver.findElement(By.xpath("//h2[text()='"+text+"']")).getText();
        Assert.assertEquals(text, actualText); 
    }

    public static void selectPicklistFieldValue(WebDriver driver, String option){
        driver.findElement(By.xpath("//div[@class='mat-mdc-select-value ng-tns-c153-4']/following-sibling::div[1]")).click();
        driver.findElement(By.xpath("//span[text()='"+option+"']")).click();
    }

    
    public static void inputTextIntoField(WebDriver driver, String fieldLabel, String value){
        driver.findElement(By.xpath("(//label[text()='"+fieldLabel+"']/following::input)[1]")).sendKeys(value);
    }

    public static void clickOnButton(WebDriver driver, String btnName, int index){
        driver.findElement(By.xpath("(//div[text()='"+btnName+" ']//ancestor::button)["+index+"]")).click();
    }

    public static void inputFieldValueShouldBe(WebDriver driver, String fieldName, String value){
        String actualText = driver.findElement(By.xpath("//td[text()='"+fieldName+"']/following-sibling::td")).getText();
        Assert.assertEquals(value, actualText); 
    }

    public static void selectCheckBoxField(WebDriver driver, int index){
        driver.findElement(By.xpath("(//input[@type='checkbox'])["+index+"]")).click();
    }

    public static void formSubmittionSuccessMessage(WebDriver driver, String successMessage){
        String actualText = driver.findElement(By.xpath("//p[contains(@class,'p-0 m-0')]/following-sibling::p[1]")).getText();
        Assert.assertEquals(successMessage, actualText); 
    }
} 
