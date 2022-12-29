package com.anurag.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

//Stream.of()        -- > Use to create streams of certain values passed to this method
//Stream.generate()  -- > Use to create infinite Streams
//Stream.iterate()   -- > Use to create infinite Streams
public class StreamOfGenerateIterateFactoryMethod {
	public static void main(String[] args) {

		Stream<String> of = Stream.of("anurag", "upadhyay", "bunty");
		of.forEach(System.out::println);

		Stream.iterate(1, a -> a * 2).limit(5).forEach(System.out::println);

		Supplier<Integer> randomSupplier = new Random()::nextInt;
		Stream.generate(randomSupplier).limit(5).forEach(System.out::println);
	}
}
