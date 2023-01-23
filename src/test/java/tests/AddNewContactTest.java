package tests;

import modelContact.Contacts;
import modelContact.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
          //  User user = User.builder().email("benb@gmail.com").password("Beny$123456").build();
            app.getHelperUser().login(User.builder().email("benb@gmail.com").password("Beny$123456").build());
        }
    }
    @Test
    public void addNewContactSuccessAllFields(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contacts contacts = Contacts.builder()
                .name("Melafifon"+i)
                .lastName("Green")
                .phone("056"+i+"2569")
                .email("melG"+i+"@gmail.com")
                .address("Netanya")
                .description("Friend")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contacts.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contacts.getPhone()));
        //Assert.assertTrue(app.getHelperContact().isContactAddedByEmail(contacts.getEmail()));


    }
    @Test
    public void addNewContactSuccessRequiredFields(){
        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .address("Netanya")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contacts.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contacts.getPhone()));

    }

    @Test
    public void addNewContactWithoutName(){
        Contacts contacts = Contacts.builder()
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .address("Netanya")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();

        Assert.assertTrue(app.getHelperContact().isContactSaved());

    }
    @Test
    public void addNewContactWithoutLastName(){
        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .address("Netanya")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();

        Assert.assertTrue(app.getHelperContact().isContactSaved());

    }
    @Test
    public void addNewContactWithoutAddress(){
        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();

        Assert.assertTrue(app.getHelperContact().isContactSaved());

    }
    @Test(enabled = false)
    public void addNewContactWithWrongPhone(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .phone("056"+i)
                .email("tapA@gmail.com")
                .address("Netanya")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        Assert.assertTrue(app.getHelperContact().getTextfromAlert( "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
       // Assert.assertTrue(app.);

    }
    @Test(enabled = false)
    public void addNewContactWithWrongMail() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapAgmail.com")
                .address("Netanya")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        Assert.assertTrue(app.getHelperContact().getTextfromAlert("Email not valid: must be a well-formed email address"));

    }
}
