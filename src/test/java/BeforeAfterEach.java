import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BeforeAfterEach {

    @BeforeEach
    public void setUp() {
       /* SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));*/
        Configuration.startMaximized = true;

    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
