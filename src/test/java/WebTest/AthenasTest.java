package WebTest;

import Pages.IndexPage;
import Pages.LoginPage;
import Utils.BaseClass;
import Utils.Util;
import org.testng.annotations.Test;

public class AthenasTest extends BaseClass {
    private final int DNINumber = Util.createRandomDNI();
    private final String clientName = "Test" + DNINumber;

    @Test(priority = 1)
    public void createClient() throws Exception {
        test = extent.createTest("Crear Socio");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.createNewClient(clientName,"prueba", String.valueOf(DNINumber));
    }

    @Test(priority = 2)
    public void addCashToClient() throws Exception {
        test = extent.createTest("Agregar dinero al Socio");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.searchClient(String.valueOf(DNINumber));
        IndexPage.addCashToClient("200");
    }


    @Test(priority = 3)
    public void removeCashToClient() throws Exception {
        test = extent.createTest("Quitar dinero del Socio");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.searchClient(String.valueOf(DNINumber));
        IndexPage.removeCashFromClient("50");
    }

    @Test(priority = 4)
    public void editClient() throws Exception {
        test = extent.createTest("Quitar dinero del Socio");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.searchClient(String.valueOf(DNINumber));
        IndexPage.editClient(String.valueOf(DNINumber));
    }

    @Test(priority = 5)
    public void navigateToEGM() throws Exception {
        test = extent.createTest("Ir a Egms");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.navigateToEgm();
    }
    @Test(priority = 6)
    public void navigateToSettings() throws Exception {
        test = extent.createTest("Ir a configuracion");
        LoginPage.Login("teceng","0okmnji9");
        IndexPage.navigateToSettings();
    }



}
