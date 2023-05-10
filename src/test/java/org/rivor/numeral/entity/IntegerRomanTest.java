package org.rivor.numeral.entity;

import junit.framework.TestCase;

/**
 * IntegerRomanTest - Test
 *
 * @author riverify
 */
public class IntegerRomanTest extends TestCase {

    public static void main(String[] args) {
//        IntegerRoman roman = new IntegerRoman("X");
//        System.out.println(roman.getValue());
//
//        roman.setValue(399);
//        System.out.println(roman);
//
//        roman.add(1);
//        System.out.println(roman.getValue());
    }

    public void testMul() {
        IntegerRoman r1 = new IntegerRoman(3999);

        r1.mul(1);
    }
}