package com.example.streams.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StreamsDemo {
    public static void main(String[] args) {
        show();
    }

        public static void show(){

        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );
//        Imperative programming
        int count = 0;
        for (Movie movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }

            System.out.println(count);

//        Declarative (Functional ) Programming
        var count2 = movies.stream().filter(movie -> {
            return movie.getLikes() > 10;
        }).count();

            System.out.println(count2);

    }


////01  For each method of the stream
//    public static void show(){
//        var list = new ArrayList<>();
//        list.stream();
//
//        int[] nums = {1, 2,3};
//         Arrays.stream(nums).forEach(num -> {
//             System.out.println(num);
//         });
//    }


////02  Limiting
//    public static void show(){
//        var stream = Stream.iterate(1, n -> n + 1);
//        stream.limit(5)
//                .forEach(num -> System.out.println(num));
//    }


////03  Generating random numbers in stream as we want quantity or number
//    public static void show(){
//        var stream = Stream.generate(() -> {
//            return Math.random();
//        });
//
//        stream.limit(5)
//                .forEach(n -> System.out.println(n));
//    }


////04  Mapping
//    public static void show(){
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//
//        movies.stream().map(movie -> movie.getTitle() ).forEach(
//                name -> System.out.println(name)
//        );
//
//        movies.stream().mapToInt(movie -> movie.getLikes() ).forEach(
//                like -> System.out.println(like));
//    }


////05    Mapping two lists to one
//    public static void show(){
//       var stream =  Stream.of(List.of(1, 2, 3), List.of(4, 5,6) );
//        stream.flatMap(list -> list.stream()).
//                forEach(number -> System.out.println(number));
//
//    }


////06    Filtering elements
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//
//
////        movies.stream().filter(movie -> movie.getLikes() > 10)
////                .forEach(popularMovie -> System.out.println(popularMovie.getTitle()) );
//
////        Predicate is used for saving boolean condition in lambda
//        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
////        This expression is the same as above
//        movies.stream().filter(isPopular)
//                .forEach(popularMovie -> System.out.println(popularMovie.getTitle()));
//
//
//    }


////07  Slicing Streams
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//
////        Limiting
//        System.out.println("\n===Limiting===");
//        movies.stream().limit(2).forEach(movie -> System.out.println(movie.getTitle()));
//
////        Skipping
//        System.out.println("\n===Skipping===");
//        movies.stream().skip(1).limit(1).forEach(movie -> System.out.println(movie.getTitle()));
//
////        TakeWhile -> like while iterates for each streams obj and takes all elements after the condition is  satisfied
//        System.out.println("\n===TakeWhile===");
//        movies.stream().takeWhile(movie -> movie.getLikes() < 20).forEach(movie -> System.out.println(movie.getTitle()));
//
//        System.out.println("\n===dropWhile===");
////        dropWhile -> like while iterates for each streams obj and drops all elements after the condition is  satisfied
//        movies.stream().dropWhile(movie -> movie.getLikes() > 10).forEach(movie -> System.out.println(movie.getTitle()));
//
//    }


////08    Sorting Streams
//    public static void show(){
//        List<Movie> movies = List.of(
//                new Movie("b", 10),
//                new Movie("a", 15),
//                new Movie("c", 20)
//        );
//
////        First way
//        movies.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).forEach(movie -> System.out.println(movie.getTitle()));
//
////        Second way
//        movies.stream().sorted(Comparator.comparing(movie -> movie.getTitle())).forEach(movie -> System.out.println(movie.getTitle()));
//
//        movies.stream()
//                .sorted(Comparator.comparing(Movie::getTitle).reversed()) // we cal also use reversed
//                .forEach(movie -> System.out.println(movie.getTitle()));
//
////        Third way -> for using this way we must implement Comparable<T> and override its compareTo method;
//        movies.stream().sorted().forEach(movie -> System.out.println(movie.getTitle()));
//
//    }


////09    Getting Unique Elements
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("a", 10),
//                new Movie("b", 15),
//                new Movie("c", 20)
//        );
//
////        The name of the movie(or any field) will not be duplicated means distinct like SQL
//        movies.stream()
//                .map(movie -> movie.getTitle()).distinct().forEach(System.out::println);
//    }


////10    Peeking Elements
//    public static void show(){
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 20),
//                new Movie("c", 30)
//        );
//
//        movies.stream().filter(m -> m.getLikes() > 10)
//                .peek(m -> System.out.println("Filtered: " + m.getTitle()))  // the difference forEach and peek is peel returns Stream and after
////                peek we can call another method. For each returns void so we cannot use another method to the expression
//                .map(m -> m.getTitle())
//                .peek(t -> System.out.println("Mapped: " + t))
//                .forEach(t -> System.out.println(t));
//
//    }


////11    Simple Reducers
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 20),
//                new Movie("c", 30)
//        );
//
////        MATCHERS
//
//        boolean predicateAnyMatch = movies.stream().anyMatch(m -> m.getLikes() > 20);
//        System.out.println(predicateAnyMatch);
//
//        boolean predicateAllMatch = movies.stream().allMatch(m -> m.getLikes() > 20);
//        System.out.println(predicateAllMatch);
//
//        boolean predicateNoneMatch = movies.stream().noneMatch(m -> m.getLikes() > 30);
//        System.out.println(predicateNoneMatch);
//
////        finding(first, any) min max
//
//        Movie movie = movies.stream().findFirst().get();
////        Movie movie = movies.stream().findAny().get();
//        System.out.println(movie.getTitle());
//
//        Movie maxLikeMovie = movies.stream().max(Comparator.comparing(Movie::getLikes)).get();  // in this method out Movie class
////         do not need to implement Comparable and implement its compareTo method
//        System.out.println(maxLikeMovie.getTitle());
//
//        Movie minLikeMovie = movies.stream().min(Comparator.comparing(Movie::getLikes)).get();
//        System.out.println(minLikeMovie.getTitle());
//
//    }


////12    Reducing a Stream
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 20),
//                new Movie("c", 30)
//        );
//
//        Optional<Integer> optionalSumOfMovieLikes = movies.stream().map(movie -> movie.getLikes()).reduce((a, b) -> a + b);
////        reduce takes [10, 20, 30]
////        [30, 30]
////        [60] does it until value becomes single
//
//        System.out.println(optionalSumOfMovieLikes.orElse(0));
//
//    }


////13    Collectors
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10),
//                new Movie("b", 20),
//                new Movie("c", 30)
//        );
//
//        List<Movie> filteredCollectedMoviesList = movies.stream().filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toList());
//        System.out.println(filteredCollectedMoviesList);
//
//        Set<Movie> filteredCollectedMoviesSet = movies.stream().filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toSet());
//        System.out.println(filteredCollectedMoviesSet);
//
//        Map<String, Integer> filteredCollectedMoviesHashMap = movies.stream().filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toMap(m -> m.getTitle(), m -> m.getLikes()));  // HashMap with title key, likes value
//        System.out.println(filteredCollectedMoviesHashMap);
//
//
//        Integer filteredCollectedAndSumOfLikes = movies.stream().filter(m -> m.getLikes() > 10)
//                .collect(Collectors.summingInt(movie -> movie.getLikes()));  // HashMap with title key, likes value
//        System.out.println(filteredCollectedAndSumOfLikes);
//
//        String collectedMovieTitles = movies.stream().map(m -> m.getTitle()).collect(Collectors.joining(", "));
//        System.out.println(collectedMovieTitles);
//
//    }


////14    Grouping Elements
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10, Genre.THRILLER),
//                new Movie("b", 20, Genre.ACTION),
//                new Movie("c", 30, Genre.ACTION)
//        );
//
//        Map<Genre, List<Movie>> result = movies.stream().collect(Collectors.groupingBy(movie -> movie.getGenre()));
//        var result2 = movies.stream().collect(Collectors.groupingBy(
//                Movie::getGenre,
//                Collectors.toSet()));
//        System.out.println(result);
//        System.out.println(result2);
//
//    }



////15    Partitioning Elements
//    public static void show() {
//        List<Movie> movies = List.of(
//                new Movie("a", 10, Genre.THRILLER),
//                new Movie("b", 20, Genre.ACTION),
//                new Movie("c", 30, Genre.ACTION)
//        );
//
//        Map<Boolean, List<Movie>> partitionedMovies = movies.stream().
//                collect(Collectors.partitioningBy(m -> m.getLikes() > 20));
//
//        System.out.println(partitionedMovies);
//
//        Map<Boolean, String> collect2 = movies.stream().collect(
//                Collectors.partitioningBy(m -> m.getLikes() > 20,
//                        Collectors.mapping(Movie::getTitle,
//                                joining(", ")))
//        );
//
//        System.out.println(collect2);
//    }


////16    Working with primitive types we use IntStream, LongStream, DoubleStream
//    public static void show() {
//
//        IntStream intStream = IntStream.of(1, 2, 3);
//        intStream.forEach(value -> System.out.println(value));
//
//        IntStream.range(1,5).forEach(value -> System.out.println(value  ));
//
//    }


}
