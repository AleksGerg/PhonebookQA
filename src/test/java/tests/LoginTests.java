package tests;

import manager.ApplicationManager;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("benb@gmail.com","Beny$123456");
        app.getHelperUser().submitLogin();
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bengmail.com","Beny$123456");
        app.getHelperUser().submitLogin();


    }
    @Test
    public void loginWrongPassword(){

    }

    @Test
    public void loginUnregisterUser(){

    }
}
