package Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HeaderBlock;
import pages.OwnersOverviewPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class  OwnersTests {
    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void searchForSpecificOwner() {
        open("");
    $(HeaderBlock.ownerTab).shouldBe(visible).click();
    $(HeaderBlock.ownerTabAllButton).shouldBe(visible).click();
    webdriver().shouldHave(urlContaining("petclinic/owners"));
    $$(OwnersOverviewPage.ownerNamesCollection).should(CollectionCondition.sizeGreaterThanOrEqual(1));
    $(OwnersOverviewPage.addOwnerButton).click();
    webdriver().shouldHave(urlContaining("petclinic/owners/add"));
    String firstName = "Neo";
    String lastName = "Neovich";
    $("button.addOwner").shouldBe(disabled);
    $("#firstName").setValue("Neo");
    $("#lastName").setValue("Neovich");
    $("#address").setValue("1 str.");
    $("#city").setValue("Machine City");
    $("#telephone").setValue("0987654321");
    $("button.addOwner").shouldBe(enabled);
    //$("#telephone").pressEnter();
    $("button.goBack").click();
    //$$(".ownerFullName>a").shouldHave(CollectionCondition.itemWithText("Neo Neovich"));

    }
    @ParameterizedTest
    @ValueSource(strings = {"rat", "equine", "lynx"})

    void addNewPetTool(String petType) {
        HeaderBlock.goToOwnersOverviewPageViaHeader();
        $$(".ownerFullName>a").get(76).click();
        String customerName = $(".ownerFullName>b").getText();
        $(".addNewPet").click();
        $("#owner_name").shouldHave(value(customerName));
        $("#owner_name").shouldHave(attribute("name", "owner_name"));
        $("#type").selectOptionContainingText("equine");
    }
}
