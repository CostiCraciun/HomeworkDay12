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
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtension.class)
public class CalculatorIT {

    private BasicOperations basicCalculator;

    @BeforeAll
    public static void setUpAllITs() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllITs() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachIT() {
        basicCalculator = new Basic();
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDownEachIT() {
        System.out.println("After Each");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {
        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(a, b);

        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(-2, -4);

        //THEN
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddBigNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add();

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAdd1Operand() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(167);

        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
//    @CsvSource({"1, 2, 3", "2, 4, 5"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1, int a2, int a3) {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.add(a1, a2, a3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply();

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiply1Operand() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(115);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumbers() {
        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(3, 4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyMoreThan2Operands() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(2, 3, 4, 5);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(-2, -4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyBigNumbers() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(Integer.MAX_VALUE, 30L);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumbersGivenOperand0() {

        //GIVEN
//        BasicOperations basicCalculator = new Basic();

        //WHEN
        long result = basicCalculator.multiply(0, 7);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, 5);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowNumbersGivenExponent0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, 0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowNegativeNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(-2, -3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowNumbersGivenBase0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(0, 4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowNumbersGivenNegativeExponent() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(2, -3);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldPowBigNumbers() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.pow(145, 6);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldFactorialNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldFactorialNegativeNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(-4);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldFactorialNumber0() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(0);

        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldFactorialBigNumber() {

        //GIVEN
        ExpertOperations expertCalculator = new Expert();

        //WHEN
        double result = expertCalculator.fact(31);

        //THEN
        System.out.println(result);
    }
}
