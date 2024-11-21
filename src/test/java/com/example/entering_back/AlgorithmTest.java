package com.example.entering_back;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTest {
    private final Algorithm algorithm = new Algorithm();

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void test1(String str, String expected) {
        String actual;
        try {
            actual = algorithm.middleElement(str);
            if (expected == null) {
                assertSame(expected, actual);
            } else {
                assertEquals(expected, actual);
            }
        } catch (NumberFormatException exception) {
            assertEquals(expected, "NumberFormatException");
        }

    }

    static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of("1 2 3", "2"),
                Arguments.of("3 1 2", "2"),
                Arguments.of("3 1 2 5", null),
                Arguments.of("3 1", null),
                Arguments.of("a s d", "NumberFormatException")
        );
    }
}
