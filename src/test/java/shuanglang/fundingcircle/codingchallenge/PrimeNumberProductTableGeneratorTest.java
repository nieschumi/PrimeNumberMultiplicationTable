package shuanglang.fundingcircle.codingchallenge;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.InputMismatchException;


@RunWith(DataProviderRunner.class)
public class PrimeNumberProductTableGeneratorTest {

    PrimeNumberProductTableGenerator generator = new PrimeNumberProductTableGenerator();

    /**
     * Invalid input test data, numbers of prime number to be found is -1 and 0.
     *
     * @return Object array contains numbers of prime number to be found
     */
    @DataProvider
    public static Object[][] invalidInputData() {
        return new Object[][]{
                {-1},
                {0}
        };
    }

    /**
     * Valid input test data, numbers of prime number to be found is 1 and 2, with their corresponding expected product table.
     *
     * @return Object array contains numbers of prime number to be found and expected product table
     */
    @DataProvider
    public static Object[][] validInputData() {
        BigInteger[][] tableWithOnePrime = new BigInteger[][]{
                {BigInteger.ZERO, BigInteger.valueOf(2)},
                {BigInteger.valueOf(2), BigInteger.valueOf(4)}
        };

        BigInteger[][] tableWithTwoPrime = new BigInteger[][]{
                {BigInteger.ZERO, BigInteger.valueOf(2), BigInteger.valueOf(3)},
                {BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6)},
                {BigInteger.valueOf(3), BigInteger.valueOf(6), BigInteger.valueOf(9)}
        };

        return new Object[][]{
                {1, tableWithOnePrime},
                {2, tableWithTwoPrime}
        };
    }

    @Test(expected = InputMismatchException.class)
    @UseDataProvider("invalidInputData")
    public void testCalculateProductTableWithInvalidInput(int N) {
        generator.calculateProductTable(N);

    }

    @Test
    @UseDataProvider("validInputData")
    public void testCalculateProductTableWithValidInput(int N, BigInteger[][] expectedTable) {
        BigInteger[][] actualTable = generator.calculateProductTable(N);
        for (int i = 0; i < actualTable.length; i++) {
            Assert.assertArrayEquals(actualTable[i], expectedTable[i]);
        }
    }

}
