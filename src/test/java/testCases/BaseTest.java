package testCases;

import com.leadconsult.pages.ContactUs;
import com.leadconsult.pages.EventsPage;
import com.leadconsult.pages.NavigationPage;

import com.leadconsult.utils.UserActions;
import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest extends NavigationPage {
//    UploadDemo uploadDemo = new UploadDemo();
    EventsPage eventsPage = new EventsPage();
    ContactUs contactUs = new ContactUs();



    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("base.url");
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }
}
