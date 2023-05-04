package org.rivor.conversion.numeral;

import junit.framework.TestCase;

/**
 * FileName: RomanConvertTest.java
 * Date: 5/4/2023
 * Time: 4:19 PM
 * Author: river
 */
public class RomanConvertTest extends TestCase {

    public void testRomanToArabic() {
        String roman = "MCMXCIX";
        System.out.println(RomanConvert.romanToArabic(roman));
    }

    public void testArabicToRoman() {
        int arabic = 4;
        System.out.println(RomanConvert.arabicToRoman(arabic));

        String arabicStr = "4";
        System.out.println(RomanConvert.arabicToRoman(arabicStr));
    }


}