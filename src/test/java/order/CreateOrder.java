package order;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CreateOrder {
    private WebDriver driver;
    private final String name;
    private final String family;
    private final String address;
    private final String subwStation;
    private final String telNumber;
    private final String delivDate;
    private final String period;
    private final String colour;
    private final String comment;

    public CreateOrder (String name, String family, String address, String subwStation, String telNumber, String delivDate, String period, String colour, String comment) {
        this.name = name;
        this.family = family;
        this.address = address;
        this.subwStation = subwStation;
        this.telNumber = telNumber;
        this.delivDate = delivDate;
        this.period = period;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Иосиф", "Сталин", "Большая Никитская 8", "Охотный Ряд", "+79990001212", "12.12.2022", "сутки", "grey", "Нужен самый быстрый"},
                {"Ли", "Юх", "Санитарная 1", "Бульвар Рокоссовского", "79635550987", "31.12.2022", "двое суток", "grey", ""},
                {"Артём", "Банин", "Темная", "Черкизовская", "89990001212", "01.01.2023", "трое суток", "grey", "Нужен самый быстрый"},
                {"Саша", "Говорун", "Борисо-глебская", "ЗИЛ", "+79990001212", "12.12.2022", "четверо суток", "black", ""},
                {"Миша", "Зябликов", "Ворсистая", "Улица 1905 года", "+79990001212", "12.12.2022", "пятеро суток", "black", "Нужен самый быстрый"},
                {"Маша", "Подымалкина", "1945 года", "Юго-Западная", "+33430001212", "12.12.2022", "шестеро суток", "black", "Нужен самый быстрый"},
                {"Света", "Запыхалкина", "Степано-разинская 50", "Библиотека имени Ленина", "+79990001212", "12.12.2022", "семеро суток", "black", ""},
        };
    }

    @Test
    public void createOrderTestHeaderButton() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        OrderPage objOrderPage = new OrderPage(driver);

        objOrderPage.openUrl();                         // Открываем браузер и нужный адрес
        objOrderPage.clickHeaderCreateButton();         // Кликаем верхнюю кнопку "Заказать"
        objOrderPage.inputName(name);                   // Вводим имя
        objOrderPage.inputFamily(family);               // Вводим фамилию
        objOrderPage.inputAddress(address);             // Вводим адрес
        objOrderPage.inputSubwStation(subwStation);     // Вводим станцию метро
        objOrderPage.inputTelNumber(telNumber);         // Вводим номер телефона клиента
        objOrderPage.clickNextPage();                   // Переходим на следующую страницу
        objOrderPage.inputDelivDate(delivDate);         // Вводим дату доставки
        objOrderPage.choisePeriod(period);              // Выбираем период аренды
        objOrderPage.choiseColour(colour);              // Выбираем цвет
        objOrderPage.inputComment(comment);             // Вводим комментарий для курьера
        objOrderPage.clickConfirmOrderButton();         // Подтверждаем ввод данных в заказе
        objOrderPage.clickReconfirmOrderButton();       // Повторное подтверждение
        objOrderPage.checkCreatedOrderPopup();          // Проверяем, что отображается окно о том, что заказ совершён
    }

    @Test
    public void createOrderTestBottomButton() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        OrderPage objOrderPage = new OrderPage(driver);

        objOrderPage.openUrl();                         // Открываем браузер и нужный адрес
        objOrderPage.clickBottomCreateButton();         // Скроллим страницу и кликаем нижнюю кнопку "Заказать"
        objOrderPage.inputName(name);                   // Вводим имя
        objOrderPage.inputFamily(family);               // Вводим фамилию
        objOrderPage.inputAddress(address);             // Вводим адрес
        objOrderPage.inputSubwStation(subwStation);     // Вводим станцию метро
        objOrderPage.inputTelNumber(telNumber);         // Вводим номер телефона клиента
        objOrderPage.clickNextPage();                   // Переходим на следующую страницу
        objOrderPage.inputDelivDate(delivDate);         // Вводим дату доставки
        objOrderPage.choisePeriod(period);              // Выбираем период аренды
        objOrderPage.choiseColour(colour);              // Выбираем цвет
        objOrderPage.inputComment(comment);             // Вводим комментарий для курьера
        objOrderPage.clickConfirmOrderButton();         // Подтверждаем ввод данных в заказе
        objOrderPage.clickReconfirmOrderButton();       // Повторное подтверждение
        objOrderPage.checkCreatedOrderPopup();          // Проверяем, что отображается окно о том, что заказ совершён
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
