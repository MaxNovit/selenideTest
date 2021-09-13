package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditVeterinariansPage {

    public static String EditFirstName = "#firstName";
    public static String EditLastName = "#lastName";
    public static void EditSpecialtiesDropdownMenu(){
        $(".mat-select-value").click();
    }

    public static void EquineSpecialtie() {
        $(By.xpath("//*[@id=\"mat-option-80\"]/mat-pseudo-checkbox")).click();
    }
    public static void HeartSpecialtie() {
        $(By.xpath("//*[@id=\"mat-option-61\"]/mat-pseudo-checkbox")).click();
    }
    public static void SurgeonSpecialtie() {
        $(By.xpath("//*[@id=\"mat-option-62\"]/mat-pseudo-checkbox")).click();
    }
    public static void EquineHeartSurgeonSpecialtie() {
        $(By.xpath("//*[@id=\"mat-option-77\"]/mat-pseudo-checkbox")).click();
    }
    public static String EditSaveVetButton = ".saveVet";
    public static String EditGoBackButton = ".goBack";


}
