package org.rivor.numeral.utils;

import org.rivor.numeral.conversion.RomanConvert;
import org.rivor.numeral.entity.IntegerRoman;
import org.rivor.numeral.validation.ArabicValidate;
import org.rivor.numeral.validation.RomanValidate;

/**
 * FileName: NumeralUtil.java
 * Date: 5/4/2023
 * Time: 11:24 PM
 * Author: riverify
 */
public class NumeralUtil {

    /**
     * This method is to convert any supported numeral to IntegerRoman
     *
     * @param num the numeral to be converted
     * @return the Roman numeral, and it is a String type
     */
    // TODO: 5/10/2023 I do not think this method should be exist in the utils class.
    public static IntegerRoman toRoman(Object num) {

        // if the num is an Integer, we only need to convert it to Roman numeral
        if (num instanceof Integer) {
            return new IntegerRoman((Integer) num);
        }

        // if the num is a String
        if (num instanceof String) {

            // if the num is a String, judge if it is a Roman numeral or Arabic numeral
            if (ArabicValidate.isArabicNaturalNumeral((String) num)) {
                return new IntegerRoman(Integer.parseInt((String) num));
            }

            if (RomanValidate.isRomanNumeral((String) num)) {
                return new IntegerRoman((String) num);
            }
        }

        // if the num is an IntegerRoman
        if (num instanceof IntegerRoman) {
            return (IntegerRoman) num;
        }

        throw new IllegalArgumentException("The type of num has not be supported to convert to Roman numeral yet.");
    }


    /**
     * Convert any supported numeral to Integer
     *
     * @param num the numeral to be converted
     * @return Integer
     */
    public static Integer toInteger(Object num) {

        // if the num is an Integer, return it directly
        if (num instanceof Integer) {
            return (Integer) num;
        }


        // if the num is a String
        if (num instanceof String) {

            // if the num is a String, judge if it is a Roman numeral or Arabic numeral
            if (ArabicValidate.isArabicNaturalNumeral((String) num)) {
                return Integer.parseInt((String) num);
            }

            if (RomanValidate.isRomanNumeral((String) num)) {
                return RomanConvert.romanToArabic((String) num);
            }
        }

        // if the num is IntegerRoman
        if (num instanceof IntegerRoman) {
            return ((IntegerRoman) num).getValue();
        }

        throw new IllegalArgumentException("The type of num has not be supported to convert to Integer yet.");
    }
}
