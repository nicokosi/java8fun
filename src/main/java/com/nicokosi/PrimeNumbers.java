package com.nicokosi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.nicokosi.PrimeNumbersDeclarative.primeNumbers_declarative;
import static com.nicokosi.PrimeNumbersImperative.primeNumbers_imperative;
import static java.lang.System.out;

public final class PrimeNumbers {

    public static void main(String[] args) {
        out.println("[imperative style]  primes <= 30: " + Arrays.toString(primeNumbers_imperative(30)));
        out.println("[declarative style] primes <= 30: " + Arrays.toString(primeNumbers_declarative(30)));
    }

}
