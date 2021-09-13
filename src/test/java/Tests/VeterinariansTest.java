package Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class VeterinariansTest {

    @BeforeAll
    static void beforeAll() {
        open("");
    }

    @Test
    void VerifyNavBarButtonsAreWorking() {
        $(NavBarTools.ButtonHome).shouldBe(Condition.visible).click();
    NavBarTools.goToAllOwners();
    NavBarTools.goToAddOwner();
    NavBarTools.goToVeterinariansAll();
    NavBarTools.goToVeterinarianAdd();
        $(NavBarTools.ButtonSpecialties).shouldBe(Condition.visible).click();
        $(NavBarTools.ButtonSpecialties).shouldBe(Condition.visible).click();
    }




    @Test
    void AddNewVetFunctionality() {
        Configuration.holdBrowserOpen = true;

       NavBarTools.goToVeterinariansAll();
       $(VeterinariansOverviewPage.AddNewVetButton).click();
       $(CreateVeterinarianPage.firstNameField).setValue("New");
       $(CreateVeterinarianPage.lastNameField).setValue("Veterinarian");
       $(CreateVeterinarianPage.typeField).selectOptionContainingText("equine heart surgeon");
      // $(CreateVeterinarianPage.saveVeterinarianButton).click();
       $(CreateVeterinarianPage.goBackButton).click();
       VeterinariansOverviewPage.FoundYourVeterinarians();

    }

    @Test
    void ChangeVeterinarianData() {
        Configuration.holdBrowserOpen = true;
        NavBarTools.goToVeterinariansAll();

        $(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[54]/td[3]/button[1]")).click();
        $(EditVeterinariansPage.EditFirstName).setValue("ChangedName");
        $(EditVeterinariansPage.EditLastName).setValue("ChangedVeterinarian");
        EditVeterinariansPage.EditSpecialtiesDropdownMenu();
        EditVeterinariansPage.EquineHeartSurgeonSpecialtie();
        EditVeterinariansPage.EquineSpecialtie();
        $(EditVeterinariansPage.EditSaveVetButton).click();
        webdriver().shouldHave(urlContaining("petclinic/vets"));
        $$("vetSpecialty").shouldHave(text("equine"));

    }
}
