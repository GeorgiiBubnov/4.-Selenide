import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest extends TestBase {
    @Test
    void GutHubTest() {
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("a[href^=\"/selenide/selenide\"]").click();
        $("#wiki-tab").click();
        $("div.wiki-rightbar").$(byText("SoftAssertions")).shouldNotBe(visible);
        $(byText("Show 3 more pages…")).click();
        $("a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
}
