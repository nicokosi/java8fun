package com.nicokosi.prime_numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class PrimeNumbersDeclarative {

    final static class PotentialPrime {
        private final int number;
        private boolean isPrime;

        PotentialPrime(final int n) {
            number = n;
            isPrime = true;
        }
    }

    static int[] primeNumbers_declarative(final int max) {

        // init potential primes
        final List<PotentialPrime> potentialPrimes = new ArrayList<>(max);
        IntStream.range(0, max).forEachOrdered(
                i -> potentialPrimes.add(new PotentialPrime(i)));

        // mark not-primes, iteratively
        potentialPrimes.stream()
                .filter(p -> p.number > 1 && p.number < Math.sqrt(max))
                .forEach(p -> markNotPrimes(p, potentialPrimes));

        // filter primes
        return potentialPrimes.stream()
                .filter(PrimeNumbersDeclarative::primesAbove1)
                .mapToInt(p -> p.number)
                .toArray();
    }

    private static boolean primesAbove1(final PotentialPrime p) {
        return p.isPrime && p.number > 1;
    }

    private static void markNotPrimes(final PotentialPrime p, final List<PotentialPrime> potentialPrimes) {
        final int i = p.number;
        int n = 0;
        for (int j = i * i; j < potentialPrimes.size(); j = i * i + n * i) {
            potentialPrimes.get(j).isPrime = false;
            n++;
        }
    }

}
