package manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import modelContact.Contacts;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddForm(){
        click((By.xpath("//a[@href='/add']")));
    }

    public void clickBySave() {
        click(By.xpath("//button[2]"));
    }

    public void fillNewContactForm(Contacts contacts) {
        type(By.xpath("//input[@placeholder='Name']"), contacts.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contacts.getDescription());

    }
    public String contackIsExist(){
        String nameNewContakt = wd.findElement(By.xpath("//h2")).getText();
        return nameNewContakt;
    }
}
