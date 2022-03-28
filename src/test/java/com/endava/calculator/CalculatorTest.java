package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.launcher.core.LauncherFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

    private BasicOperations basicCalculator;

    @BeforeAll
    public static void setUpAllTests() {
//        LauncherFactory.create().registerTestExecutionListeners(MyCustomTestListener);
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        basicCalculator = new Basic();
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {
        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(a, b);

        //THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        Long result = basicCalculator.add(-2, -4);

        //THEN
        assertEquals(-7L, result);
        assertTrue(result.equals(-6L));
    }

    //BUG Found: JIRA-78765
    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    @DisplayName("Test that adds a big number as: MAX INT")
    public void shouldAddBigNumbers() {

        assertThrows(AssertionError.class, () -> {

            //GIVEN
//        BasicOperations basicCalculator = new Basic();

            //WHEN
            long result = basicCalculator.add(Integer.MAX_VALUE, 1);

            //THEN
            assertThat(result, is(Integer.MAX_VALUE + 1L));
            assertThat(result, lessThan(0L));
            assertThat(result, notNullValue());
        });
    }

    @Test
    public void shouldAddNoOperands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add();

        //THEN
        assertThat(result, is(0L));
    }

    @Test
    public void shouldAdd1Operand() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(167);

        //THEN
        assertThat(result, is(167L));
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 6", "2, 4, 5, 11"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1, int a2, int a3, Long expected) {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(a1, a2, a3);

        //THEN
        assertThat(result, is(expected));
    }

    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply();

        //THEN
        assertThat(result, is(0L));
    }

    @Test
    public void shouldMultiply1Operand() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(115);

        //THEN
        assertThat(result, is(115L));
    }

    @Test
    public void shouldMultiplyNumbers() {
        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(3, 4);

        //THEN
        assertThat(result, is(12L));
    }

    @Test
    public void shouldMultiplyMoreThan2Operands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(2, 3, 4, 5);

        //THEN
        assertThat(result, is(120L));
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(-2, -4);

        //THEN
        assertThat(result, is(8L));
    }

    @Test
    public void shouldMultiplyBigNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 30L);

        //THEN
        assertThat(result, is(Integer.MAX_VALUE * 30L));
    }

    @Test
    public void shouldMultiplyNumbersGivenOperand0() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(0, 7);

        //THEN
        assertThat(result, is(0L));
    }

    @Test
    public void shouldPowNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, 5);

        //THEN
        assertThat(result, is(32.0));
    }

    @Test
    public void shouldPowNumbersGivenExponent0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, 0);

        //THEN
        assertThat(result, is(1.0));
    }

    @Test
    public void shouldPowNegativeNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(-2, -3);

        //THEN
        assertThat(result, is(-0.125));
    }

    @Test
    public void shouldPowNumbersGivenBase0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(0, 4);

        //THEN
        assertThat(result, is(0.0));
    }

    @Test
    public void shouldPowNumbersGivenNegativeExponent() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, -3);

        //THEN
        assertThat(result, is(0.125));
    }

    @Test
    public void shouldPowBigNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(145, 6);

        //THEN
        assertThat(result, is(9294114390625.0));
    }

    @Test
    public void shouldFactorialNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(4);

        //THEN
        assertThat(result, is(24.0));
    }

    @Test
    public void shouldFactorialNegativeNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(-4);

        //THEN

    }

    @Test
    public void shouldFactorialNumber0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(0);

        //THEN
        assertThat(result, is(1.0));
    }

    @Test
    public void shouldFactorialBigNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(31);

        //THEN
        assertThat(result, is(7.38197504E8));
    }
}
