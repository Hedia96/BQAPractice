import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;

public class CrossBrowserTest {

    Playwright pw;
    Page page;
    Browser browser;

    @BeforeTest
    public void setup() {
        pw = Playwright.create();
    }

    @Test(dataProvider = "browsers")
    public void navigateTest(String browserType) {
        if (browserType.equals("Chrome")) {
            browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));


        } else if (browserType.equals("Edge")) {
            {
                browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));

            }
            page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com");
            try {
                Thread.sleep(Long.parseLong("8000"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    @DataProvider(name = "browsers")
    public String[] browsers () {
        return new String[]{"Chrome"};
    }

//        @AfterClass
//        public void teardown () {
//            page.close();
//            browser.close();
//            pw.close();
//        }

//    @AfterTest
//    public void everybrowser () {
//        page.close();
//        browser.close();
//        pw.close();
//    }
    }
