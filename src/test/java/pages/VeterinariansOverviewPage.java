package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class VeterinariansOverviewPage {

    public static String AddNewVetButton = ".addVet";
    public static String HomeButton = ".returnHome";
    public static String VeterinariansNamesCollection = ".vetFullName>a";


    public static void FoundYourVeterinarians(){
        $$("vetFullName").find(text("New Veterinarian"));
    }

}
