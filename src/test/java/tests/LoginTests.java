package tests;

import com.sun.source.tree.AssertTree;
import manager.ApplicationManager;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    //HW
    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("benb@gmail.com", "Beny$123456");
        app.getHelperUser().submitLogin();
        app.stop();
    }

    // HW this test failed
    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bengmail.com", "Beny$123456");
        app.getHelperUser().submitLogin();

        Assert.assertNull(app.getHelperUser().findElementforNegativTest(By.xpath("//button[contains(text(),'Sign Out')]")));

    }

    @Test
    public void loginWrongPassword() {

    }

    @Test
    public void loginUnregisterUser() {

    }
}
