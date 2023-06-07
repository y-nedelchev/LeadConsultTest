package com.leadconsult.pages;

public class EventsPage extends NavigationPage{

    public void readEvents(){

        actions.assertPageNavigated("https://www.leadconsult.eu/");
        actions.waitForElementPresentTillTimeout("leadconsult.logo",2000);
        actions.moveToNewsroom("newsroom.dropdown");
        actions.clickElement("events.dropdown");
        actions.clickElement("read.more");

        // ---- Please pay attention on this link ----
        actions.clickElement("here.book.demo.link");

    }
}
