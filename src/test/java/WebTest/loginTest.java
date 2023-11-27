package WebTest;

import Pages.LoginPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class loginTest extends BaseClass {

    @Test
    public void EmptyLoginToAthenas() throws Exception {
        test = extent.createTest("Login vacio");
        LoginPage.Login("","");
    }

    @Test
    public void EmptyPasswordLoginToAthenas() throws Exception {
        test = extent.createTest("Login clave vacia");
        LoginPage.Login("teceng","");
    }

    @Test
    public void EmptyUsernameLoginToAthenas() throws Exception {
        test = extent.createTest("Login usuario vacio");
        LoginPage.Login("","asdasd");
    }

    @Test
    public void incorrectLoginToAthenas() throws Exception {
        test = extent.createTest("Login con clave incorrecta");
        LoginPage.Login("teceng","asdasd");
    }

    @Test
    public void loginToAthenas() throws Exception {
        test = extent.createTest("Login exitoso a la plataforma");
        LoginPage.Login("teceng","0okmnji9");
    }

}
