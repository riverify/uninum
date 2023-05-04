package org.rivor.validation.numeral;

/**
 * FileName: NumeralValidate.java
 * Date: 5/4/2023
 * Time: 3:58 PM
 * Author: river
 */
public class NumeralValidate {


    /**
     * Check if the string num, if the num is null or empty, return false
     *
     * @param num to be checked
     * @return is null or empty : true, else false
     */
    protected static boolean isNullOrEmpty(String num) {
        return num == null || num.length() == 0;
    }
}
