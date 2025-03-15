import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforall(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void selenideActionsDragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        actions().moveToElement(columnB).clickAndHold().moveToElement(columnA).release().perform();
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
    @Test
    void elementToElementDragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        columnA.dragAndDrop(DragAndDropOptions.to(columnB));
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

}
