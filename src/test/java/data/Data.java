package data;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "data-provider")
    public static Object[] countryData()
    {
        return new Object[] { "UKR" };
    }
}
