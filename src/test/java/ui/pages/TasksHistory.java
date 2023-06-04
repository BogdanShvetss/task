package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class TasksHistory extends AbstractPage {
    final private String finishedTaskColor = "rgba(0, 221, 0, 1)";
    final private String unfinishedTaskColor = "rgba(255, 0, 0, 1)";


    @Step("Validate that finished today task has expected color")
    public boolean hasFinishedTodayTaskExpectedColor() {
        return getCssValueFromElement(getSelectorOfTodayDate(), "color").equals(finishedTaskColor);
    }

    @Step("Validate that unfinished today task has expected color")
    public boolean hasUnfinishedTodayTaskExpectedColor() {
        return getCssValueFromElement(getSelectorOfTodayDate(), "color").equals(unfinishedTaskColor);
    }

    @Step("Get today date element")
    public By getSelectorOfTodayDate() {
        LocalDate date = LocalDate.now();
        String todayDate =
                String.format("%s %s %s", date.getDayOfMonth(), date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH), date.getYear());

        return By.xpath(String.format("//b[contains(@title, '%s')]", todayDate));
    }
}