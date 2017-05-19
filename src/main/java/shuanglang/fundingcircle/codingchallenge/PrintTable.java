package shuanglang.fundingcircle.codingchallenge;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * firstNPrimes runs in O(N^3/2) time, uses O(N) space, calculateProductTable and printAsTable run in O(N^2) time.
 * To scale the project, after calculating N primes, N primes and their products can be cached for future reference, if next N numbers is smaller than cached numbers, result can be found by index without calculating again, if next N is bigger than cached numbers, the code can continue find prime numbers and their products starting from cached result.
 * <p>
 * The project takes input from console, it calculates 1 to 2,147,483,647(Integer.MAX_VALUE) prime numbers and their multiplication table.
 * <p>
 * The project depends on junit-dataprovider, it's been configured in gradle.build, users shouldn't have to install any dependencies manually.
 */
public class PrintTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        PrintTable printTable = new PrintTable();
        printTable.printPrimeProductTable(input);

    }

    /**
     * Valid input is a digit between 1 to 2,147,483,647, otherwise it will throw an InputMismatchException
     *
     * @param input system input, number of prime numbers to be calculated
     * @throws InputMismatchException
     */
    public void printPrimeProductTable(String input) {
        String inputMessage = "Please enter an integer between 1 and 2,147,483,647";
        System.out.println(inputMessage + ": ");

        PrimeNumberProductTableGenerator tableGenerator = new PrimeNumberProductTableGenerator();

        if (input == null || input.length() == 0) {
            throw new InputMismatchException(inputMessage);
        } else {
            BigInteger[][] table = tableGenerator.calculateProductTable(Integer.parseInt(input));
            printAsTable(table);
        }
    }

    void printAsTable(BigInteger[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.format("%1$-8s", table[i][j]);
            }
            System.out.println();
        }
    }
}
