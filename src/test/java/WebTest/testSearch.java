package WebTest;

import Pages.SearchPage;
import Utils.BaseClass;
import org.testng.annotations.Test;

public class testSearch extends BaseClass {

    @Test
    public void searchSunglasses() throws Exception{
        test = extent.createTest("Search for sunglasses");
        SearchPage.newSearch("sun glasses");
    }
}
