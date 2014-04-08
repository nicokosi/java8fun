package com.nicokosi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public final class PrimeNumbersDeclarative {

    static int[] primeNumbers_declarative(final int max) {

        final class PotentialPrime {
            private final int number;
            private boolean isPrime;

            PotentialPrime(final int n) {
                number = n;
                isPrime = true;
            }
        }

        // init potential primes
        final List<PotentialPrime> potentialPrimes = new ArrayList<PotentialPrime>(max);
        IntStream.range(0, max).forEachOrdered(
                i -> potentialPrimes.add(new PotentialPrime(i)));

        // mark not-primes, iteratively
        potentialPrimes.stream()
                .filter(p -> p.number > 1 && p.number < Math.sqrt(max))
                .forEach(p -> {
                    final int i = p.number;
                    int n = 0;
                    for (int j = i * i; j < potentialPrimes.size(); j = i * i + n * i) {
                        potentialPrimes.get(j).isPrime = false;
                        n++;
                    }
                });

        // filter primes
        return potentialPrimes.stream()
                .filter(p -> p.isPrime && p.number > 1)
                .mapToInt(p -> p.number)
                .toArray();
    }

}