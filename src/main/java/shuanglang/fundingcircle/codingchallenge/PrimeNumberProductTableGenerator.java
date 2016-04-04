package shuanglang.fundingcircle.codingchallenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class PrimeNumberProductTableGenerator {

    /**
     * Calculate products of numbers in the list, (0,0) element is 0, column 0 and row 0 are prime numbers, the rest of the cells are products of the prime numbers in the corresponding row and column.
     *
     * @param N first N prime numbers to be found
     * @return a BigInteger matrix contains products of numbers in the list
     * @throws InputMismatchException
     */
    public BigInteger[][] calculateProductTable(int N) {
        List<Long> list = firstNPrimes(N);
        BigInteger[][] multiplicationTable = new BigInteger[list.size() + 1][list.size() + 1];

        if (list == null || list.size() == 0) {
            return multiplicationTable;
        }

        multiplicationTable[0][0] = BigInteger.ZERO;

        for (int k = 1; k <= list.size(); k++) {
            multiplicationTable[0][k] = BigInteger.valueOf(list.get(k - 1));
            multiplicationTable[k][0] = BigInteger.valueOf(list.get(k - 1));
        }

        for (int i = 1; i <= list.size(); i++) {
            for (int j = i; j <= list.size(); j++) {
                BigInteger multiplication = BigInteger.valueOf(list.get(i - 1)).multiply(BigInteger.valueOf(list.get(j - 1)));
                multiplicationTable[i][j] = multiplication;
                multiplicationTable[j][i] = multiplication;
            }
        }

        return multiplicationTable;
    }


    /**
     * Returns a list of N prime numbers, N lies in the range from 1 to Integer.MAX_VALUE, if N is smaller than 1, it will throw an InputMismatchException. The Integer.MAX_VALUEth prime number is smaller than Long.MAX_VALUE, so the searching range lies within 2 to Long.MAX_VALUE.
     *
     * @param N number of prime numbers to be found
     * @return a list of N Long represents prime numbers
     */
    private List<Long> firstNPrimes(int N) {

        if (N <= 0) {
            throw new InputMismatchException("Your input is invalid, please enter an integer between 1 and 2,147,483,647");
        }

        List<Long> res = new ArrayList<>();

        if (N == 1) {
            res.add(2L);
            return res;
        }

        long i = 3;
        boolean isPrime = true;

        res.add(2L);
        int count = 1;

        while (true) {
            for (long j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                res.add(i);
                count++;
            }

            if (count == N) {
                break;
            }

            i++;
            isPrime = true;

        }

        return res;
    }
}
