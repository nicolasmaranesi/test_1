package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndexPage extends Base {
    private static By createClientButton = By.xpath("//button[@aria-label='Crear']");
    private static By searchClientButton = By.xpath("//button[@aria-label='Search']");
    private static By fisrtnameField = By.name("Nombre");
    private static By lastnameField = By.name("Apellido");
    private static By DNIField =By.name("DNI");
    private static By saveClientButton = By.xpath("//button[text()='Save']");
    private static By searchBar = By.xpath("//input[@aria-label='Search']");

    private static By selectClientBuuton = By.xpath("//*[@data-testid='VisibilityIcon']");
    private static By editClientButton = By.xpath("//*[@data-testid='EditIcon']");
    private static By balanceField = By.cssSelector("div.MuiBox-root.css-1q5qjiq");
    private static By amountField = By.name("Monto");
    private static By addCashButton = By.xpath("//*[text()='Cargar']");
    private static By removeCashButton = By.xpath("//button[contains(text(),'Descargar')]");

    private static By AcceptButton = By.xpath("//button[text()='OK']");
    private static By clientNameCell = By.cssSelector("td[data-testid='MuiDataTableBodyCell-0-0'] div");

    private static By egmButton = By.xpath("//*[@data-testid='HourglassEmptyIcon']");

    private static By egmTitle = By.xpath("//*[text()='EGMs']");

    private static By settingButton = By.name("Config");
    private static By constructionImage = By.xpath("//img[@alt='Logo']");



    public IndexPage(WebDriver driver) {
        super(driver);
    }
    private static void clickCreateClient() throws Exception{
        WaitTillElementIsClickeable(createClientButton,30);
        Click(createClientButton);
        Wait(10);
    }
    private static void inputClientFirstName(String firstname) throws Exception {
        WaitTillElementIsClickeable(fisrtnameField,5);
        Click(fisrtnameField);
        Type(firstname,fisrtnameField);
        Wait(1);
    }

    private static void inputLastName (String lastname) throws Exception{
        Click(lastnameField);
        Type(lastname,lastnameField);
        Wait(1);
    }

    private static void inputDNI(String DNI) throws Exception{
        Click(DNIField);
        Type(DNI,DNIField);
        Wait(1);
    }
    private static void saveClient() throws Exception{
        Click(saveClientButton);
        Wait(10);
        Sleep(2);
    }
    public static void createNewClient(String firstname, String lastname, String DNI) throws Exception{
        clickCreateClient();
        inputClientFirstName(firstname);
        inputLastName(lastname);
        inputDNI(DNI);
        saveClient();
    }

    private static void clickSearchButton() throws Exception {
        WaitTillElementIsClickeable(searchClientButton,10);
        Click(searchClientButton);
        Wait(2);
    }

    private static void clickSearchBar() throws Exception {
        WaitTillElementIsClickeable(searchBar,10);
        Click(searchBar);
        Wait(2);
    }
    private static void inputClientData(String data) throws Exception {
        WaitTillElementIsClickeable(searchBar,10);
        Type(data,searchBar);
        Wait(15);
    }

    public static void searchClient(String data) throws Exception {
        clickSearchButton();
        clickSearchBar();
        inputClientData(data);
    }

    private static void selectClient() throws Exception{
        WaitTillElementIsClickeable(selectClientBuuton,10);
        Click(selectClientBuuton);
        Wait(10);
    }



    private static void AddMoney(String amountOfMoney)throws Exception{
        WaitTillElementIsClickeable(amountField,20);
        Click(amountField);
        Type(amountOfMoney,amountField);
        Wait(5);
        Click(addCashButton);
        WaitTillElementIsClickeable(AcceptButton,20);
        Click(AcceptButton);
        Sleep(5);

    }

    private static void removeMoney(String removedMoney) throws Exception {
        WaitTillElementIsClickeable(amountField,20);
        Click(amountField);
        Type(removedMoney,amountField);
        Wait(5);
        Click(removeCashButton);
        WaitTillElementIsClickeable(AcceptButton,20);
        Click(AcceptButton);
        Sleep(5);
    }

    private static void validateAddedBalance(String addedMoney) throws Exception{
        int currentMoney = getBalance();
        Assert.assertEquals(currentMoney,Integer.parseInt(addedMoney));
    }

    private static void validateRemovedBalance(int originalBalance, String removedMoney) throws Exception{
        int currentMoney = getBalance();
        int expectedMoney = originalBalance - Integer.parseInt(removedMoney);
        Assert.assertEquals(currentMoney,expectedMoney);
    }

    private static int getBalance() throws Exception {
        return Integer.parseInt(getText(balanceField));
    }

    public static void addCashToClient(String addedMoney) throws Exception {
        selectClient();
        AddMoney(addedMoney);
        validateAddedBalance(addedMoney);
    }
    public static void removeCashFromClient(String removedMoney) throws Exception{
        int originalBalance = getBalance();
        removeMoney(removedMoney);
        validateRemovedBalance(originalBalance,removedMoney);
    }


    private static void editName(String newName) throws Exception{
        WaitTillElementIsClickeable(fisrtnameField,10);
        Clear(fisrtnameField);
        Click(fisrtnameField);
        Type(newName,fisrtnameField);
        Click(saveClientButton);
    }

    private static void clickEditClient() throws Exception {
        WaitTillElementIsClickeable(editClientButton,10);
        Click(editClientButton);
        Wait(10);
    }

    private static String getClientOriginalName() throws Exception {
        return getText(clientNameCell);
    }
    private static void validateEdition(String originalName, String currentName) throws Exception{
        Assert.assertNotEquals(originalName,currentName);
    }
    public static void editClient(String DNI) throws Exception {
        String originalName = getClientOriginalName();
        String newName = "edited" + DNI;
        clickEditClient();
        editName(newName);
        validateEdition(originalName, newName);
    }

    private static void clickOnEGM() throws Exception{
        WaitTillElementIsClickeable(egmButton,10);
        Click(egmButton);
    }

    private static void validateEgmButton() throws Exception{
        WaitTillElementIsLocated(egmTitle,15);
    }

    public static void navigateToEgm()throws Exception{
        clickOnEGM();
        validateEgmButton();
    }

    private static void clickOnSetting() throws Exception{
        WaitTillElementIsClickeable(settingButton,10);
        Click(settingButton);
    }
    private static void validateConstructionImage() throws Exception{
        WaitTillElementIsLocated(constructionImage,15);
    }

    public static void navigateToSettings() throws Exception{
        clickOnSetting();
        validateConstructionImage();
    }









}
