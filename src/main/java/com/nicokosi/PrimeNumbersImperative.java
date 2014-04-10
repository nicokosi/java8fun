package com.nicokosi;

public final class PrimeNumbersImperative {

    static int[] primeNumbers_imperative(final int max) {

        // init array for potential primes
        boolean potentialPrimes[] = new boolean[max];
        for (int a = 0; a < max; a++)
            potentialPrimes[a] = true;

        // mark not-primes, iteratively
        for (int i = 2; i < Math.sqrt(max); i++) {
            if (potentialPrimes[i]) {
                int n = 0;
                for (int j = i * i; j < max; j = i * i + n * i) {
                    potentialPrimes[j] = false;
                    n++;
                }
            }
        }
        // filter primes
        int nbPrimes = 0;
        for (int n = 2; n < max; n++)
            if (potentialPrimes[n]) nbPrimes++;
        int[] primes = new int[nbPrimes];
        int i = 0;
        for (int n = 2; n < max && i < nbPrimes; n++) {
            if (potentialPrimes[n]) {
                primes[i] = n;
                i++;
            }
        }
        return primes;
    }

}