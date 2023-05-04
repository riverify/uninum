package org.rivor.validation;

import junit.framework.TestCase;
import org.rivor.conversion.number.RomanConvert;
import org.rivor.validation.number.RomanValidate;

import java.util.Random;

/**
 * FileName: RomanValidateTest.java
 * Date: 5/4/2023
 * Time: 2:55 PM
 * Author: river
 */
public class RomanValidateTest extends TestCase {

    public void testIsRomanNumeral() {
        Random random = new Random();
        int arabicNumber;
        String romanNumber = null;
        for (int i = 0; i < 10000000; i++) {
            // get a random number between 1 and 3999
            arabicNumber = random.nextInt(3999) + 1;
            romanNumber = RomanConvert.arabicToRoman(arabicNumber);
            assertTrue(RomanValidate.isRomanNumeral(romanNumber));
        }


        assertFalse(RomanValidate.isRomanNumeral("IIII"));
        assertFalse(RomanValidate.isRomanNumeral("XXXX"));
        assertFalse(RomanValidate.isRomanNumeral("CCCC"));
        assertTrue(RomanValidate.isRomanNumeral("MMMM"));
        assertFalse(RomanValidate.isRomanNumeral("VV"));
        assertFalse(RomanValidate.isRomanNumeral("LL"));
        assertFalse(RomanValidate.isRomanNumeral("DD"));
        assertFalse(RomanValidate.isRomanNumeral("IIV"));
        assertFalse(RomanValidate.isRomanNumeral("IIX"));
        assertFalse(RomanValidate.isRomanNumeral("IIL"));
        assertFalse(RomanValidate.isRomanNumeral("IIC"));

        System.out.println(RomanValidate.isRomanNumeral(null));

    }

}