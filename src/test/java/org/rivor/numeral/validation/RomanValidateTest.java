package org.rivor.numeral.validation;

import junit.framework.TestCase;
import org.rivor.numeral.conversion.RomanConvert;

import java.util.Random;

/**
 * FileName: RomanValidateTest.java
 * Date: 5/4/2023
 * Time: 2:55 PM
 * Author: river
 */
public class RomanValidateTest extends TestCase {

    public void testIsRomanNumeral() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        int arabicNumber;
        String romanNumber = null;
        for (int i = 0; i < 10000000; i++) {
            // get a random numeral between 1 and 3999
            arabicNumber = random.nextInt(3999) + 1;
            romanNumber = RomanConvert.arabicToRoman(arabicNumber);
            assertTrue(RomanValidate.isRomanNumeral(romanNumber));
        }

        System.out.println("testIsRomanNumeral() took " + (System.currentTimeMillis() - start) + " ms");

    }

}