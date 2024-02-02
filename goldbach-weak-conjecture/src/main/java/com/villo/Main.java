package com.villo;

public class Main {
    private final static int SMALLEST_PRIME_NUMBER = 2;

    public static void main(String[] args) throws Exception {
        for (var i = 7; i < 1000; i = i + 2) {
            var solution = goldbachWeakConjecture(i);
            System.out.println(i + " = " + solution[0] + " + " + solution[1] + " + " + solution[2]);
        }
    }

    private static int[] goldbachWeakConjecture(int number) throws Exception {
        if (number < 7)
            throw new Exception("number must not be less than 7.");

        if (number % 2 == 0)
            throw new Exception("number must not be even.");

        for (int i = SMALLEST_PRIME_NUMBER; i <= number - SMALLEST_PRIME_NUMBER * 2; i++)
            if (isPrimeNumber(i))
                for (int j = SMALLEST_PRIME_NUMBER; j <= number - i - SMALLEST_PRIME_NUMBER; j++)
                    if (isPrimeNumber(j) && isPrimeNumber(number - i - j))
                        return new int[]{i, j, number - i - j};

        throw new Exception("Goldbach's weak conjecture has just been disproven!");
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