package com.example.entering_back;

import com.example.entering_back.exception.WrongNumberOfArgumentsException;
import com.example.entering_back.util.Algorithm;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTest {
    private final Algorithm algorithm = new Algorithm();

    @ParameterizedTest
    @MethodSource("algorithmTestArgsProvider")
    public void algorithmTest(String str, String expected) {
        String actual = algorithm.middleElement(str);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("wrongNumberOfArgumentsTestArgsProvider")
    public void wrongNumberOfArgumentsTest(String str, String expected) {
        Exception exception = assertThrows(WrongNumberOfArgumentsException.class, () -> algorithm.middleElement(str));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    @ParameterizedTest
    @MethodSource("notNumberArgumentsTestArgsProvider")
    public void notNumberArgumentsTest(String str, String expected) {
        Exception exception = assertThrows(NumberFormatException.class, () -> algorithm.middleElement(str));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expected));
    }

    static Stream<Arguments> algorithmTestArgsProvider() {
        return Stream.of(
                Arguments.of("1 2 3", "2"),
                Arguments.of("3 1 2", "2")
        );
    }

    static Stream<Arguments> wrongNumberOfArgumentsTestArgsProvider() {
        return Stream.of(
                Arguments.of("3 1 2 5", "Should be exactly 3 arguments"),
                Arguments.of("3 1", "Should be exactly 3 arguments")
        );
    }

    static Stream<Arguments> notNumberArgumentsTestArgsProvider() {
        return Stream.of(
                Arguments.of("a s d", "For input string: \"a\""),
                Arguments.of("asd ds a", "For input string: \"asd\"")
        );
    }
}
