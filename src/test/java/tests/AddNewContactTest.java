package tests;

import modelContact.Contacts;
import modelContact.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContactTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(User.builder().email("benb@gmail.com").password("Beny$123456").build());
        }
    }
    @Test(groups = {"smoke"})
    public void addNewContactSuccessAllFields(){
        Random random = new Random();
        int i = random.nextInt(1000);
        Contacts contacts = Contacts.builder()
                .name("Melafifon"+i)
                .lastName("Green")
                .phone("056"+i+"2569")
                .email("melG"+i+"@gmail.com")
                .address("Netanya")
                .description("All fields")
                .build();
        logger.info("Test start with data: "+contacts.toString());
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        //Assert.assertTrue(app.getHelperContact().isContactAddedByName(contacts.getName()));
     //   Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contacts.getPhone()));
      //  Assert.assertTrue(app.getHelperContact().isContactAddedByEmail(contacts.getEmail()));


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
        app.getHelperContact().pause(1000);
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
      //  Assert.assertTrue(app.getHelperContact().isContactAddedByName(contacts.getName()));
       // Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contacts.getPhone()));

    }

    @Test
    public void addNewContactWithoutName(){
        Contacts contacts = Contacts.builder()
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .address("Netanya")
                .description("Without Name")
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
                .description("Without Last Name")
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
                .description("Without Address")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();

        Assert.assertTrue(app.getHelperContact().isContactSaved());

    }
    @Test
    public void addNewContactWithWrongPhone(){

        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .email("tapA@gmail.com")
                .address("Netanya")
                .description("Wrong Phone")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
     //   Assert.assertTrue(app.getHelperContact().getTextfromAlert( "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
       // Assert.assertTrue(app.);

    }
    @Test
    public void addNewContactWithWrongMail() {

        Contacts contacts = Contacts.builder()
                .name("Tapuah")
                .lastName("Adoma")
                .phone("0562365895")
                .email("tapA@gmail.com")
                .address("Netanya")
                .description("Wrong email")
                .build();
        app.getHelperContact().openAddForm();
        app.getHelperContact().fillNewContactForm(contacts);
        app.getHelperContact().clickBySave();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        //Assert.assertTrue(app.getHelperContact().getTextfromAlert("Email not valid: must be a well-formed email address"));

    }
}
