package tests;

import com.sun.source.tree.AssertTree;
import manager.ApplicationManager;
import manager.DataProviderUser;
import modelContact.User;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("I need logout");
        }
    }
    @DataProvider
    public Iterator<Object[]> loginData(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"benb@gmail.com","Beny$123456"});
        list.add(new Object[]{"ili@gmail.com","IliB$123456"});
        list.add(new Object[]{"benb@gmail.com","Beny$123456"});

        return list.iterator();

    }

    @Test(dataProvider = "loginData")
    public void loginSuccess(String email,String password) {
        logger.info("Login with valid data: email: "+email+" password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Test success");
    }

    @Test(dataProvider = "loginDataCls",dataProviderClass = DataProviderUser.class)
    public void loginSuccess2(String email,String password) {
        logger.info("Login with valid data: email: "+email+" password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
       // Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Test success");
    }
    @Test(invocationCount = 2)
    public void loginSuccessNew() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("ili@gmail.com", "IliB$123456");
        app.getHelperUser().submitLogin();
      //  Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test(dataProvider = "loginDataUser",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test start with user: "+ user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);//????
        app.getHelperUser().submitLogin();
       // Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test(dataProvider = "loginDataUserFromFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelFromFile(User user) {
        logger.info("Test start with user: "+ user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
       // Assert.assertTrue(app.getHelperUser().isLogged());
    }

    // HW this test failed
    @Test(groups = "smoke")
    public void loginWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bengmail.com", "Beny$123456");
        app.getHelperUser().submitLogin();
       // Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));


    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bengmail.com", "Beny$123456");
        app.getHelperUser().submitLogin();
      //  Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }

    @Test
    public void loginUnregisterUser() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("benG@gmail.com.com", "Beny$123456");
        app.getHelperUser().submitLogin();
      //  Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }


}


