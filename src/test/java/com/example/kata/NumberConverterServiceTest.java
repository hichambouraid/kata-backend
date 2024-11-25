package com.example.kata;

import com.example.kata.service.NumberConverterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterServiceTest {

    @InjectMocks
    private NumberConverterService numberConverterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertNumberDivisibleBy3() {
        assertEquals("FOOFOO", numberConverterService.convertNumber(3));
        assertEquals("FOO", numberConverterService.convertNumber(6));
        assertEquals("FOO", numberConverterService.convertNumber(9));
    }

    @Test
    void convertNumberDivisibleBy5() {
        // Test numbers divisible by 5 (should return "BAR")
        assertEquals("BARBAR", numberConverterService.convertNumber(5));
        assertEquals("BAR", numberConverterService.convertNumber(10));
        assertEquals("BAR", numberConverterService.convertNumber(20));
    }

    @Test
    void convertNumberDivisibleByBoth3And5() {
        // Test numbers divisible by both 3 and 5 (should return "FOOBAR")
        assertEquals("FOOBARBAR", numberConverterService.convertNumber(15));
        assertEquals("FOOBARFOO", numberConverterService.convertNumber(30));
    }

    @Test
    void convertNumberContains3() {
        assertEquals("FOO", numberConverterService.convertNumber(13));
        assertEquals("FOO", numberConverterService.convertNumber(23));
        assertEquals("FOOFOOFOO", numberConverterService.convertNumber(33));
    }

    @Test
    void convertNumberContains5() {
        assertEquals("FOOBAR", numberConverterService.convertNumber(51));
        assertEquals("BAR", numberConverterService.convertNumber(52));
        assertEquals("BARBAR", numberConverterService.convertNumber(25));
    }

    @Test
    void convertNumberContains7() {
        assertEquals("QUIX", numberConverterService.convertNumber(17));
        assertEquals("FOOQUIX", numberConverterService.convertNumber(27));
        assertEquals("BARQUIX", numberConverterService.convertNumber(70));
    }

    @Test
    void convertNumberDivisibleBy3AndContains5() {
        assertEquals("BARFOOBAR", numberConverterService.convertNumber(35));
        assertEquals("BARFOO", numberConverterService.convertNumber(53));
    }

    @Test
    void convertNumberDivisibleBy5AndContains3() {
        assertEquals("BARFOO", numberConverterService.convertNumber(53));
        assertEquals("BARFOOBAR", numberConverterService.convertNumber(35));
    }

    @Test
    void convertNumberWithout3or5or7() {
        assertEquals("1", numberConverterService.convertNumber(1));
        assertEquals("2", numberConverterService.convertNumber(2));
        assertEquals("4", numberConverterService.convertNumber(4));
        assertEquals("8", numberConverterService.convertNumber(8));
    }
}
