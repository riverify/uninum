package org.rivor.utils.numeral;

import org.rivor.conversion.numeral.RomanConvert;
import org.rivor.validation.numeral.ArabicValidate;
import org.rivor.validation.numeral.RomanValidate;

/**
 * FileName: NumeralUtil.java
 * Date: 5/4/2023
 * Time: 11:24 PM
 * Author: river
 */
public class NumeralUtil {

    /**
     * This method is to convert any supported numeral to Roman numeral
     *
     * @param num the numeral to be converted
     * @return the Roman numeral, and it is a String type
     */
    public static String toRoman(Object num) {

        // if the num is an Integer, we only need to convert it to Roman numeral
        if (num instanceof Integer) {
            return RomanConvert.arabicToRoman((Integer) num);
        }

        // if the num is a String
        if (num instanceof String) {

            // if the num is a String, judge if it is a Roman numeral or Arabic numeral
            if (ArabicValidate.isArabicNaturalNumeral((String) num)) {
                return RomanConvert.arabicToRoman((String) num);
            }

            if (RomanValidate.isRomanNumeral((String) num)) {
                return (String) num;
            }
        }

        throw new IllegalArgumentException("The type of num has not be supported to convert to Roman numeral yet.");
    }
}
