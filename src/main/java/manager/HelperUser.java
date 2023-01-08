package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {

        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[position()=1]"), email);
        type(By.xpath("//input[position()=2]"), password);

    }

    public void submitLogin() {
        click(By.xpath("//button[starts-with(text(),'Login')]"));
    }

}
