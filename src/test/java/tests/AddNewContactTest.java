package tests;

import modelContact.Contacts;
import modelContact.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;



public class AddNewContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            User user = User.builder().email("benb@gmail.com").password("Beny$123456").build();
            app.getHelperUser().login(user);
        }
    }
    public void addNewContactSuccess(){
        Contacts contacts = Contacts.builder()
                .name("Melafifon")
                .lastName("Green")
                .phone("0562365897")
                .email("melG@gmail.com")
                .address("Netanya")
                .description("Friend")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();

        Assert.assertEquals(app.getHelperContact().contackIsExist(),contacts.getName());


    }
}
