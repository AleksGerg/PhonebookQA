package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import modelContact.Contacts;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        click((By.xpath("//a[@href='/add']")));
    }

    public void clickBySave() {
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public void fillNewContactForm(Contacts contacts) {
        type(By.xpath("//input[@placeholder='Name']"), contacts.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contacts.getDescription());

    }


    public void inerTextForContakt() {
        WebElement element = wd.findElement(By.cssSelector(".active"));
    }


    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }


    public boolean isContactSaved() {
        if (isElementPresent(By.xpath("//input[@placeholder='Name']")))
            return true;
        return false;
    }

   public boolean getTextfromAlert(String massege) {
        if(isErrorMessageDisplayed(massege))
            return true;

       return false;
    }

    /*public boolean isContactAddedByEmail(String email) {
        click(By.xpath("//div/h2[text()='Melafifon']"));
        WebElement text = wd.findElement(By.xpath(("(//img[@alt='media'])[1]")));
        if (text.getText().equals(email)) {
            return true;
        }
        return false;
    }*/
}
