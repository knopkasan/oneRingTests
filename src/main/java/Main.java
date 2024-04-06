import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Stream<String> passwords = Stream.of("12erw3", "password2", "per342d");
        //passwords.filter(pass -> pass.length() == 7).forEach(System.out::println);

//        Consumer<String> print = System.out::println;
//        print.accept("Hello World");
//
//        Function<String, Integer> length = String::length;
//        System.out.println(length.apply("Hello World"));
//
//        Supplier<Double> random = Math::random;
//        System.out.println(random.get());

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        stream.skip(2).forEach(System.out::println);
        stream.limit(2).forEach(System.out::println);
   

    }
}
