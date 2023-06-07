package testCases;

import org.junit.Test;

public class ContactUsTest extends BaseTest{

    @Test
    public void submitContactForm() {
        contactUs.submitForm();
        contactUs.assertSubmitForm();
    }
}
