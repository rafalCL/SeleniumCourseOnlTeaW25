package pl.coderslab.test.zad1;

import org.openqa.selenium.WebElement;

public class Utils {
    public static void setCheckbox(WebElement checkbox, boolean state) {
        boolean currentState = checkbox.isSelected();
        if(currentState != state) {
            checkbox.click();
        }
    }
}
