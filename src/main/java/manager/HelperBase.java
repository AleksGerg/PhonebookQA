package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.sendKeys(Keys.CONTROL+"a");
        element.sendKeys(Keys.BACK_SPACE);

        if(text != null){
            element.sendKeys(text);
        }
        /*if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }*/
    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
    public boolean isErrorMessageDisplayed(String massege){
        //Alert alert = wd.switchTo().alert();
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(9))
                .until(ExpectedConditions.alertIsPresent());
        String text = alert.getText().trim();

        //click ok
        alert.accept();
        //click cansel
        //alert.dismiss();
        //alert.sendKeys("hello");
        return text.contains(massege);
    }

}
