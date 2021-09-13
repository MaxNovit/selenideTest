package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class NavBarTools {

    public static String ButtonHome = ".glyphicon-home";
    public static String ButtonOwnerTab = ".ownerTab";
    public static String ButtonOwnersAll = "a[routerlink='/owners']";
    public static String ButtonOwnerAdd = "a[routerlink='/owners/add']";
    public static void goToAllOwners(){
        $(".ownerTab").shouldBe(visible).click();
        $("a[routerlink='/owners']").shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("petclinic/owners"));
    }
    public static void goToAddOwner(){
        $(".ownerTab").shouldBe(visible).click();
        $("a[routerlink='/owners/add']").shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("petclinic/owners/add"));
    }
    public static String ButtonVeterinariansTab = ".vetsTab";
    public static String ButtonVeterinariansAll = "a[routerlink='/vets']";
    public static String ButtonVeterinarianAdd = "a[routerlink='/vets/add']";
    public static void goToVeterinariansAll(){
        $(".vetsTab").shouldBe(visible).click();
        $("a[routerlink='/vets']").shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("petclinic/vets"));
    }
    public static void goToVeterinarianAdd(){
        $(".vetsTab").shouldBe(visible).click();
        $("a[routerlink='/vets/add']").shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("petclinic/vets/add"));
    }
    public static String ButtonPetTypes = "a[routerlink='/pettypes']";
    public static String ButtonSpecialties = "a[routerlink='/specialties']";

}
