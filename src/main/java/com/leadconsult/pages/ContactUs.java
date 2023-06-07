package com.leadconsult.pages;

public class ContactUs extends NavigationPage{

    public void submitForm() {

        actions.assertPageNavigated("https://www.leadconsult.eu/");
        actions.waitForElementPresentTillTimeout("leadconsult.logo",2000);
        actions.clickElement("contact.us");
        actions.typeValueInField("Yordan Nedelchev", "your.name");
        actions.typeValueInField("example.email@example.com", "your.email");
        actions.typeValueInField("+359 123 123 123", "your.phone");
        actions.typeValueInField("It's so nice to see you!@#$%^&*()_+", "your.message");
        actions.clickElement("policy.checkbox");
        actions.clickElement("send.button");


    }

    public void assertSubmitForm() {

        actions.assertElementPresentAfterWait("captcha.error");

    }

}
