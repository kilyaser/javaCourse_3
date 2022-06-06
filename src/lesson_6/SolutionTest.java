package lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {
    private Solution solutions;
    @BeforeEach
    void init(){
        solutions = new Solution();
    }

    @MethodSource("addTestArgument")
    @ParameterizedTest
    void sortedMassTest(int[] result, int[] mas) {
        Assertions.assertArrayEquals(result, solutions.sortedMass(mas));
    }
    @MethodSource("addArgumentForFalse")
    @ParameterizedTest
    void checkOneOrFour(int[] masfoFalse){
        Assertions.assertFalse(solutions.checkOneOrFour(masfoFalse));
    }



    public static Stream<Arguments> addArgumentForFalse(){
        List<Arguments> arguments = new ArrayList<>();
        int[] one = {10, 12};
        int[] two = {5, 44, 8, 10};
        arguments.add(Arguments.of(one));
        arguments.add(Arguments.of(two));
        return arguments.stream();
    }


    public static Stream<Arguments> addTestArgument(){
        List<Arguments> arguments = new ArrayList<>();
        int[] res = {14, 8};
        int[] sourse = {5, 4, 2, 7, 4, 14, 8};
        int[] res2 = {2, 7, 1, 14, 8};
        int[] sourse2 = {1, 4, 2, 7, 1, 14, 8};
        int[] res3 = {9};
        int[] sourse3 = {1, 9, 2, 7, 1, 4, 9};

        arguments.add(Arguments.of(res, sourse));
        arguments.add(Arguments.of(res2, sourse2));
        arguments.add(Arguments.of(res3, sourse3));

        return arguments.stream();
    }

}
