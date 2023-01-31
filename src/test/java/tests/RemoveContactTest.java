package tests;

import modelContact.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            //  User user = User.builder().email("benb@gmail.com").password("Beny$123456").build();
            app.getHelperUser().login(User.builder().email("benb@gmail.com").password("Beny$123456").build());
        }
    }
    @Test
    public void removeOneContactSuccess(){
        int result = app.getHelperContact().removeOneContact();
        Assert.assertEquals(result,1);
    }
    @Test
    public void removeAllContacts(){
      //  app.getHelperContact().removeAllContacts();
    }
}
