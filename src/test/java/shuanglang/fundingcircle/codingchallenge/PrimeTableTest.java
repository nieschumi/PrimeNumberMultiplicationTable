package shuanglang.fundingcircle.codingchallenge;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

@RunWith(DataProviderRunner.class)
public class PrimeTableTest {

    PrintTable printTable = new PrintTable();

    /**
     * System input data that will cause testPrintPrimeProductTableWithInvalidInput to throw an InputMismatchException. Tested input includes empty string, -1 and 0.
     *
     * @return Object array contains test data
     */
    @DataProvider
    public static Object[][] inputMismatchExceptionData() {
        return new Object[][]{
                {""},
                {"-1"},
                {"0"}
        };
    }

    /**
     * System input data that will cause testPrintPrimeProductTableWithInvalidInput throw InputMismatchException. Tested input includes space and non-integer.
     *
     * @return Object array contains test data
     */
    @DataProvider
    public static Object[][] numberFormatExceptionData() {
        return new Object[][]{
                {" "},
                {"test123!"}
        };
    }

    @Test(expected = InputMismatchException.class)
    @UseDataProvider("inputMismatchExceptionData")
    public void testPrintPrimeProductTableWithInputMismatchException(String input) {
        printTable.printPrimeProductTable(input);
    }

    @Test(expected = NumberFormatException.class)
    @UseDataProvider("numberFormatExceptionData")
    public void testPrintPrimeProductTableWithNumberFormatException(String input) {
        printTable.printPrimeProductTable(input);
    }

}
