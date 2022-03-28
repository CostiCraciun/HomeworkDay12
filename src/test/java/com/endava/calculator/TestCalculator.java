package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations b = new Basic(3);
        System.out.println(b.add(2, 3, 4, 5));
        System.out.println(b.substract(2));
        System.out.println(b.multiply(2, 6));
        System.out.println(b.devide(10, 3));
        System.out.println(b.devide(5, 0));
        System.out.println(b.multiply(3.5, 2.3));
        System.out.println(b.multiply(6, 2.1));
        System.out.println(b.devide(3, 1.5));

        System.out.println("=========================");

        ExpertOperations e = new Expert();
        System.out.println(e.pow(2,-5));
        System.out.println(e.root(4));
        System.out.println(e.root(7));
        System.out.println(e.fact(3));

//        System.out.println(e.calculate("22.5 + 33.35 + 5 + 6"));
//        System.out.println(e.calculate("3 + 2 * 4"));
//        System.out.println(e.calculate("-3 - 5 * 3"));
//        System.out.println(e.calculate("2 * (-3 + 2)"));
        System.out.println(e.calculate("(-3 - 5) / 2"));
        System.out.println(e.calculate("2 + (-3 -5) * (-7 - 5)"));
        System.out.println(e.calculate("(3 + 2) / 5 * 5 - (8 / 2)"));
//        System.out.println(e.calculate("(2 * (3 + 7)) + 4 * (5 - 2)"));
    }
}
