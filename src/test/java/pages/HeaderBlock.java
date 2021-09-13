package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class HeaderBlock {

    public static String ownerTab = ".ownerTab";
    public static String ownerTabAllButton = "a[routerlink='/owners']";

    public static void goToOwnersOverviewPageViaHeader(){
        open("");
        $(".ownerTab").shouldBe(visible).click();
        $("a[routerlink='/owners']").shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("petclinic/owners"));
    }



}
