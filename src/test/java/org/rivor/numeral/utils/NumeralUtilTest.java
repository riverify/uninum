package org.rivor.numeral.utils;

import junit.framework.TestCase;
import org.rivor.numeral.entity.IntegerRoman;

/**
 * FileName: NumeralUtilTest.java
 * Date: 5/4/2023
 * Time: 11:55 PM
 * Author: riverify
 */
public class NumeralUtilTest extends TestCase {

    public void testToRoman() {
//        long start = System.currentTimeMillis();
//        Random random = new Random();
//        int arabicNumber;
//        String romanNumber = null;
//        for (int i = 0; i < 10000000; i++) {
//            // get a random numeral between 1 and 3999
//            arabicNumber = random.nextInt(3999) + 1;
//            romanNumber = NumeralUtil.toRoman(arabicNumber);
//            assertTrue(RomanValidate.isRomanNumeral(romanNumber));
//        }
//
//        System.out.println("testToRoman() took " + (System.currentTimeMillis() - start) + " ms");

        assertEquals("XII", NumeralUtil.toRoman("XII"));
        assertEquals("XII", NumeralUtil.toRoman(12));
        assertEquals("XII", NumeralUtil.toRoman("12"));

    }


    public void testToInteger() {
        System.out.println(NumeralUtil.toInteger("XII"));
        System.out.println(NumeralUtil.toInteger("12"));
        System.out.println(NumeralUtil.toInteger(12));
        System.out.println(NumeralUtil.toInteger(new IntegerRoman(12)));
        System.out.println(NumeralUtil.toInteger(new IntegerRoman("XII")));

        IntegerRoman roman = new IntegerRoman();
        System.out.println(NumeralUtil.toInteger(roman));
    }
}