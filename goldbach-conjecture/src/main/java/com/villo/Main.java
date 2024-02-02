package com.villo;

public class Main {
    private final static int SMALLEST_PRIME_NUMBER = 2;

    public static void main(String[] args) throws Exception {
        for (var i = 4; i < 1000; i = i + 2) {
            var solution = goldbachConjecture(i);
            System.out.println(i + " = " + solution[0] + " + " + solution[1]);
        }
    }

    private static int[] goldbachConjecture(int number) throws Exception {
        if (number < 4)
            throw new Exception("number must not be less than 4.");

        if (number % 2 != 0)
            throw new Exception("number must not be odd.");

        for (int i = SMALLEST_PRIME_NUMBER; i <= number - SMALLEST_PRIME_NUMBER; i++)
            if (isPrimeNumber(i) && isPrimeNumber(number - i))
                return new int[]{i, number - i};

        throw new Exception("Goldbach's conjecture has just been disproven!");
    }

    private static boolean isPrimeNumber(int number) {
        if (number < SMALLEST_PRIME_NUMBER)
            return false;

        for (int i = SMALLEST_PRIME_NUMBER; i < number; i++)
            if (number % i == 0)
                return false;

        return true;
    }
}