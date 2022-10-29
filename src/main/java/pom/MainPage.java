package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";                               // URL главной страницы
    private final By questionsDiv = By.className("Home_FourPart__1uthg");                                 // Контейнер с вопросами
    private final By accordionButton0 = By.id("accordion__heading-0");                                    // Первая кнопка
    private final By textUnderButton0 = By.xpath(".//div[@id='accordion__panel-0']/p");       // Текст под первой кнопкой
    private final By accordionButton1 = By.id("accordion__heading-1");                                    // Вторая кнопка
    private final By textUnderButton1 = By.xpath(".//div[@id='accordion__panel-1']/p");       // Текст под второй кнопкой
    private final By accordionButton2 = By.id("accordion__heading-2");                                    // Третья кнопка
    private final By textUnderButton2 = By.xpath(".//div[@id='accordion__panel-2']/p");       // Текст под третьей кнопкой
    private final By accordionButton3 = By.id("accordion__heading-3");                                    // Четвертая кнопка
    private final By textUnderButton3 = By.xpath(".//div[@id='accordion__panel-3']/p");       // Текст под четвертой кнопкой
    private final By accordionButton4 = By.id("accordion__heading-4");                                    // Пятая кнопка
    private final By textUnderButton4 = By.xpath(".//div[@id='accordion__panel-4']/p");       // Текст под пятой кнопкой
    private final By accordionButton5 = By.id("accordion__heading-5");                                    // Шестая кнопка
    private final By textUnderButton5 = By.xpath(".//div[@id='accordion__panel-5']/p");       // Текст под шестой кнопкой
    private final By accordionButton6 = By.id("accordion__heading-6");                                    // Седьмая кнопка
    private final By textUnderButton6 = By.xpath(".//div[@id='accordion__panel-6']/p");       // Текст под седьмой кнопкой
    private final By accordionButton7 = By.id("accordion__heading-7");                                    // Восьмая кнопка
    private final By textUnderButton7 = By.xpath(".//div[@id='accordion__panel-7']/p");       // Текст под восьмой кнопкой

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открываем браузер
    public void openUrl() {
        driver.get(url);
    }

    // Скроллим к нужному элементу (добавил ожидание, потому что иногда при скролле не успевала исчезать картинка с самокатом и клик происходил на неё)
    public void scrollToQuestions(By accordionButton) {
        WebElement element = driver.findElement(questionsDiv);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionButton));
    }

    // Кликаем на кнопку с вопросом и ждём появления ответа
    public void clickButtonAndWait(By accordionButton, By textUnderButton) {
        driver.findElement(accordionButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(textUnderButton));
    }

    // Метод, вызывающий другие методы, в зависимости от переданного параметра из теста, и возвращающий фактический текст ответа
    public String startCheckTextUnderButton(int questionNumber) {
        if (questionNumber == 1) {
            return getTextUnderButton0();
        } else if (questionNumber == 2) {
            return getTextUnderButton1();
        } else if (questionNumber == 3) {
            return getTextUnderButton2();
        } else if (questionNumber == 4) {
            return getTextUnderButton3();
        } else if (questionNumber == 5) {
            return getTextUnderButton4();
        } else if (questionNumber == 6) {
            return getTextUnderButton5();
        } else if (questionNumber == 7) {
            return getTextUnderButton6();
        } else {
            return getTextUnderButton7();
        }
    }

    // Ниже - методы, получающие текст из элемента и возвращающие его
    public String getTextUnderButton0() {
        openUrl();
        scrollToQuestions(accordionButton0);
        clickButtonAndWait(accordionButton0, textUnderButton0);
        return driver.findElement(textUnderButton0).getText();
    }

    public String getTextUnderButton1() {
        openUrl();
        scrollToQuestions(accordionButton1);
        clickButtonAndWait(accordionButton1, textUnderButton1);
        return driver.findElement(textUnderButton1).getText();
    }

    public String getTextUnderButton2() {
        openUrl();
        scrollToQuestions(accordionButton2);
        clickButtonAndWait(accordionButton2, textUnderButton2);
        return driver.findElement(textUnderButton2).getText();
    }

    public String getTextUnderButton3() {
        openUrl();
        scrollToQuestions(accordionButton3);
        clickButtonAndWait(accordionButton3, textUnderButton3);
        return driver.findElement(textUnderButton3).getText();
    }

    public String getTextUnderButton4() {
        openUrl();
        scrollToQuestions(accordionButton4);
        clickButtonAndWait(accordionButton4, textUnderButton4);
        return driver.findElement(textUnderButton4).getText();
    }

    public String getTextUnderButton5() {
        openUrl();
        scrollToQuestions(accordionButton5);
        clickButtonAndWait(accordionButton5, textUnderButton5);
        return driver.findElement(textUnderButton5).getText();
    }

    public String getTextUnderButton6() {
        openUrl();
        scrollToQuestions(accordionButton6);
        clickButtonAndWait(accordionButton6, textUnderButton6);
        return driver.findElement(textUnderButton6).getText();
    }

    public String getTextUnderButton7() {
        openUrl();
        scrollToQuestions(accordionButton7);
        clickButtonAndWait(accordionButton7, textUnderButton7);
        return driver.findElement(textUnderButton7).getText();
    }

}
