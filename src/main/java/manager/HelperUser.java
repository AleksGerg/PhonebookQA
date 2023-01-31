package manager;

import modelContact.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {
  /*  public boolean isErrorMessageDisplayed(String massege){
        Alert alert = wd.switchTo().alert();
        String text = alert.getText();

        //click ok
        alert.accept();
        //click cansel
        //alert.dismiss();
        //alert.sendKeys("hello");
        return text.equals(massege);
    }
*/
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath("//a[@href='/login']"));//LOGIN
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[position()=1]"), email);
        type(By.xpath("//input[position()=2]"), password);

    }

    public void submitLogin() {
        click(By.cssSelector("a[href='/login']"));
       // click(By.xpath("//button[@name='login']"));
       // pause(1000);
    }


    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[starts-with(text(),'Registration')]"));
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        submitLogin();
    }

}
