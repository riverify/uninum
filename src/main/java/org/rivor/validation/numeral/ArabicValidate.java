package org.rivor.validation.numeral;

/**
 * FileName: ArabicValidate.java
 * Date: 5/4/2023
 * Time: 3:16 PM
 * Author: river
 */
public class ArabicValidate extends NumeralValidate {

    /**
     * The string must begin with one of the '1', '2', '3', '4', '5', '6', '7', '8', or '9' characters,
     * followed by zero or more '0' to '9' characters
     *
     * @param num Arabic numeral
     * @return if it is Arabic numeral
     */
    public static boolean isArabicNaturalNumeral(String num) {
        if (isNullOrEmpty(num)) {
            return false;
        }
        return num.matches("^[1-9]\\d*$");
    }

}
