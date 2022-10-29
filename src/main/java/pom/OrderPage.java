package pom;

import org.openqa.selenium.*;

public class OrderPage {

    private final WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";                                                     // URL главной страницы
    private final By orderCreateHeaderButton = By.xpath(".//button[@Class='Button_Button__ra12g']");                // Верхняя кнопка "Заказать"
    private final By divSecondOrderButton = By.xpath(".//div[@Class='Home_RoadMap__2tal_']");                       // Контейнер, в котором отображается вторая кнопка "Заказать"
    private final By orderCreateBottomButton = By.xpath(".//div[@Class='Home_FinishButton__1_cWm']/button");        // Нижняя кнопка "Заказать"
    private final By nameInputField = By.xpath(".//input[@Placeholder='* Имя']");                                   // Поле ввода имени
    private final By familyInputField = By.xpath(".//input[@Placeholder='* Фамилия']");                             // Поле ввода фамилии
    private final By addressInputField = By.xpath(".//input[@Placeholder='* Адрес: куда привезти заказ']");         // Поле ввода адреса
    private final By stationInputField = By.xpath(".//input[@Placeholder='* Станция метро']");                      // Поле ввода станции метро
    private final By telNumberInputField = By.xpath(".//input[@Placeholder='* Телефон: на него позвонит курьер']"); // Поле ввода номера клиента
    private final By nextPageOrderButton = By.xpath(".//div[@Class='Order_NextButton__1_rCA']/button");             // Кнопка перехода на след.страницу оформления заказа
    private final By delivDateInputField = By.xpath(".//input[@Placeholder='* Когда привезти самокат']");           // Поле ввода даты доставки самоката
    private final By periodDropdownField = By.xpath(".//div[@Class='Dropdown-control']");                           // Выпадающее меню срока аренды
    private final By commentInputField = By.xpath(".//input[@Placeholder='Комментарий для курьера']");              // Поле ввода комментария для курьера
    private final By confirmOrderButton = By.xpath(".//div[@Class='Order_Buttons__1xGrp']/button[text()='Заказать']");  // Кнопка "Заказать", подтверждающая заказ
    private final By reconfirmOrderButton = By.xpath(".//button[text()='Да']");                                     // Кнопка "Да", повторно подтверждающая заказ
    private final By createdOrderPopup = By.xpath(".//div[@Class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");  // Всплывающее окно о том, что заказ оформлен

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открываем браузер
    public void openUrl() {
        driver.get(url);
    }


    // Скролл и клик на нижнюю кнопку "Заказать"
    public void clickBottomCreateButton() {
        WebElement element = driver.findElement(divSecondOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderCreateBottomButton).click();
    }

    // Клик на верхнюю кнопку "Заказать"
    public void clickHeaderCreateButton() {
        driver.findElement(orderCreateHeaderButton).click();
    }

    // Ввести имя
    public void inputName(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    // Ввести фамилию
    public void inputFamily(String family) {
        driver.findElement(familyInputField).sendKeys(family);
    }

    // Ввести адрес
    public void inputAddress(String address) {
        driver.findElement(addressInputField).sendKeys(address);
    }

    // Ввести и выбрать станцию метро
    public void inputSubwStation(String subwStation) {
        driver.findElement(stationInputField).sendKeys(subwStation);
        driver.findElement(stationInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(stationInputField).sendKeys(Keys.ENTER);
    }

    // Ввести номер телефона
    public void inputTelNumber(String telNumber){
        driver.findElement(telNumberInputField).sendKeys(telNumber);
    }

    // Перейти на следующую страницу заказа
    public void clickNextPage() {
        driver.findElement(nextPageOrderButton).click();
    }

    // Ввести и выбрать дату доставки
    public void inputDelivDate(String delivDate) {
        driver.findElement(delivDateInputField).sendKeys(delivDate);
        driver.findElement(delivDateInputField).sendKeys(Keys.ENTER);
    }

    // Кликнуть на выпадающее меню и выбрать срок аренды
    public void choisePeriod(String period) {
        driver.findElement(periodDropdownField).click();
        driver.findElement(By.xpath(".//div[text()='"+period+"']")).click();
    }

    // Отметить чек-бокс с цветом самоката
    public void choiseColour(String colour) {
        driver.findElement(By.xpath(".//input[@id='"+colour+"']")).click();
    }

    // Ввести комментарий для курьера
    public void inputComment(String comment) {
        driver.findElement(commentInputField).sendKeys(comment);
    }

    // Подтвердить введённые данные заказа по кнопке "Заказать"
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    // Повторное подтверждение заказа по кнопке "Да"
    public void clickReconfirmOrderButton() {
        driver.findElement(reconfirmOrderButton).click();
    }

    // Проверить отображение окна об успешном заказе
    public void checkCreatedOrderPopup() {
        driver.findElement(createdOrderPopup).isDisplayed();
    }



}
