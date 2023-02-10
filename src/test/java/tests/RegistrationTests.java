package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(groups = {"smoke","test"})
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(100);
        String email = "oMg"+i+"@gmail.com";

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, "Beny$123456");
        app.getHelperUser().submitRegistration();
       // Assert.assertTrue(app.getHelperUser().isLogged());
        //logout for jenkins
    }

    @Test
    public void registrationWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("omggmail.com", "Be$123654");
        app.getHelperUser().submitRegistration();
      //  Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }
    @Test
    public void registrationWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("omgR@gmail.com", "Be");
        app.getHelperUser().submitRegistration();
       // Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }
    @Test
    public void registrationUserAlreadyExist(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bengmail.com", "Beny$123456");
        app.getHelperUser().submitRegistration();
       // Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }
}
