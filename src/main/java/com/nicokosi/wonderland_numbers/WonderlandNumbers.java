package com.nicokosi.wonderland_numbers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

public class WonderlandNumbers {

    public static void main(String[] args) {
        final long t1 = System.currentTimeMillis();
        out.println(
                range(100_000, 10_000_000)
                    .boxed()
                    .filter(WonderlandNumbers::isMagicNumber)
                    .parallel() // 4 s sur mon Mac, sinon 10 s
                    .collect(toSet())
        );
        final long t2 = System.currentTimeMillis();
        out.println("Duration: " + (t2 - t1) + " ms");
    }

    private static boolean isMagicNumber(final Integer number) {
        return range(2, 6)
                .map(n -> n * number)
                .allMatch(n -> digits(n).equals(digits(number)));
    }

    private static List<Byte> digits(final Integer number) {
        final byte[] bytes = String.valueOf(number).getBytes();
        final List<Byte> byteArrays = new ArrayList<>();
        for (final byte b : bytes) {
            byteArrays.add(new Byte(b));
        }
        return byteArrays.stream()
                .sorted()
                .collect(toList());
    }

}
