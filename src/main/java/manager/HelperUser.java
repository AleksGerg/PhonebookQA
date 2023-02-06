package manager;

import modelContact.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {
      public boolean isErrorMessageDisplayed(String massege){
         // Alert alert = wd.switchTo().alert();
          Alert alert = new WebDriverWait(wd, Duration.ofSeconds(3))
                  .until(ExpectedConditions.alertIsPresent());
          String text = alert.getText();
          alert.accept();
          return text.equals(massege);
      }

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath("//a[@href='/login']"));//LOGIN
    }

    public void fillLoginRegistrationForm(String email, String password) {
       // type(By.xpath("//input[position()=1]"), email);
        type(By.name("email"),email);
        type(By.xpath("//input[position()=2]"), password);

    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void submitLogin() {
        // click(By.cssSelector("a[href='/login']"));
        click(By.xpath("//button[@name='login']"));
        // pause(1000);
    }


    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        if(list.size()>0){
            return true;
        }
        return false;
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[starts-with(text(),'Registration')]"));
    }


    public void login(User user) {
        pause(500);
        openLoginRegistrationForm();
        pause(500);
        fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        pause(500);
        submitLogin();
    }

}
