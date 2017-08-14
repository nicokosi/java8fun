package com.nicokosi.variance_with_animals;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Collections.singleton;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class Animals {

   public static void main(String[] args) {
      out.println("Hello animals!");
      out.println("What's your cry? " + new CryLogger().apply(singleton(new Cat())));
      out.println("Several animals please: " + new GimmePlenty().get());

   }
}

interface Animal {}
interface Vertebrate extends Animal {}
interface Mammal extends Vertebrate {}
class Cat implements Mammal {
   @Override
   public String toString() {
      return "Cat{}";
   }
}
interface Invertabrate extends Animal {}

class CryLogger implements Function<Collection<Animal>, Collection<String>> {
   @Override
   public Collection<String> apply(Collection<Animal> animals) {
      return asList("wof", "maow");
   }
}

class GimmePlenty implements Supplier<Collection<Animal>> {
   @Override
   public Collection<Animal> get() {
      return singleton(new Cat());
   }
}



