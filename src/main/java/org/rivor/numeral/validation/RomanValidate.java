package org.rivor.numeral.validation;

/**
 * FileName: RomanValidate.java
 * Date: 5/4/2023
 * Time: 2:42 PM
 * Author: river
 */
public class RomanValidate extends NumeralValidate {


    /**
     * The string must begin with one of the 'M', 'D', 'C', 'L', 'X', or 'I' characters, followed by zero or more 'M' characters.
     * Next, the string must contain either 'C' and 'M' characters, or 'D' and 'C' characters, or zero to three 'C' characters.
     * Then, the string must contain 'X' and 'C' characters, or 'L' and 'X' characters, or zero to three 'X' characters.
     * Finally, the string must contain 'I' and 'X' characters, or 'V' and 'I' characters, or zero to three 'I' characters.
     * If the string matches this regular expression, it is a Roman numeral.
     * Also, if the string is empty or null, it is not a Roman numeral
     *
     * @param num Roman numeral
     * @return if it is Roman numeral
     */
    public static boolean isRomanNumeral(String num) {
        if (isNullOrEmpty(num)) {
            return false;
        }
        return num.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

}
