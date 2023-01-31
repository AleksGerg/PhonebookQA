package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import modelContact.Contacts;
import org.openqa.selenium.WebElement;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openAddForm() {
        click((By.xpath("//a[@href='/add']")));
    }

    public void clickBySave() {
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public void fillNewContactForm(Contacts contacts) {
        type(By.xpath("//input[@placeholder='Name']"), contacts.getName());

        type(By.xpath("//input[@placeholder='Last Name']"), contacts.getLastName());

        type(By.cssSelector("input[placeholder='Phone']"), contacts.getPhone());

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
        if (isErrorMessageDisplayed(massege))
            return true;

        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return wd.findElements(By.cssSelector("a.active[href='/add']")).size() > 0;
    }

    public boolean isContactAddedByEmail(String email) {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        for (WebElement el : list) {
            el.click();
            String text = wd.findElement((By.cssSelector(".contact-item-detailed_card__50dTS"))).getText();
            if (text.contains(email)) {
                return true;
            }
        }
        return false;
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);

        String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        logger.info("The deleted number is " + phone);
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
        int countAfter = countOfContacts();
        logger.info("Number of contacts after is " + countBefore);
        return countBefore - countAfter;
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
}
