import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GItHubSolutions {

    @BeforeAll
    static void beforall(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
    }

    @Test
    void testGitHubSolutions(){
        open("https://github.com/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

    }
}
