package org.rivor.numeral.conversion;

import org.rivor.numeral.exception.NoSuchNumberException;
import org.rivor.numeral.validation.ArabicValidate;
import org.rivor.numeral.validation.RomanValidate;

/**
 * FileName: RomanConvert.java
 * Date: 5/4/2023
 * Time: 9:57 AM
 * Author: river
 * Description: This is a class to convert Arabic numeral to Roman numeral
 */
public class RomanConvert {

    private static final int[] ARABIC_NUMBERS = {1000, 500, 100, 50, 10, 5, 1};
    private static final String[] ROMAN_NUMBERS = {"M", "D", "C", "L", "X", "V", "I"};


    /**
     * This method is to convert Arabic numeral to Roman numeral, the Arabic numeral should be between 1 and 3999
     *
     * @param arabicNumber the Arabic numeral to be converted
     * @return the Roman numeral, and it is a String type
     */
    public static String arabicToRoman(int arabicNumber) {

        if (arabicNumber < 1 || arabicNumber > 3999) {
            throw new NoSuchNumberException(arabicNumber + " can not be converted to Roman numeral.(1-3999)");
        }

        StringBuilder romanNumber = new StringBuilder();

        int i = 0;
        while (arabicNumber > 0) {
            if (arabicNumber >= ARABIC_NUMBERS[i]) {
                romanNumber.append(ROMAN_NUMBERS[i]);
                arabicNumber -= ARABIC_NUMBERS[i];
            } else if (i % 2 == 0 && i < 6 && arabicNumber >= ARABIC_NUMBERS[i] - ARABIC_NUMBERS[i + 2]) {
                romanNumber.append(ROMAN_NUMBERS[i + 2]).append(ROMAN_NUMBERS[i]);
                arabicNumber -= ARABIC_NUMBERS[i] - ARABIC_NUMBERS[i + 2];
                i++;
            } else if (i % 2 == 1 && i < 6 && arabicNumber >= ARABIC_NUMBERS[i] - ARABIC_NUMBERS[i + 1]) {
                romanNumber.append(ROMAN_NUMBERS[i + 1]).append(ROMAN_NUMBERS[i]);
                arabicNumber -= ARABIC_NUMBERS[i] - ARABIC_NUMBERS[i + 1];
                i++;
            } else {
                i++;
            }
        }

        return romanNumber.toString();
    }


    public static String arabicToRoman(String arabicNumber) {

        // judge if the Arabic numeral is correct
        if (!ArabicValidate.isArabicNaturalNumeral(arabicNumber)) {
            throw new NoSuchNumberException(arabicNumber + " is not a Arabic numeral.");
        }

        return arabicToRoman(Integer.parseInt(arabicNumber));
    }


    /**
     * This method is to convert Roman numeral to Arabic numeral, the Roman numeral should be between 'I' and 'MMMCMXCIX',
     * due to that it is almost impossible to use that large Roman numeral, more than this range may cause some potential problems
     *
     * @param romanNumber the Roman numeral to be converted
     * @return the Arabic numeral, and it is an Integer type
     */
    public static Integer romanToArabic(String romanNumber) {

        // judge if the Roman numeral is correct
        if (!RomanValidate.isRomanNumeral(romanNumber)) {
            throw new NoSuchNumberException(romanNumber + " is not a Roman numeral.");
        }

        int arabicNumber = 0;
        int i = 0;

        while (i < romanNumber.length()) {
            char romanChar = romanNumber.charAt(i);
            int arabicChar = getArabicChar(romanChar);
            if (i == romanNumber.length() - 1) {
                arabicNumber += arabicChar;
                break;
            }
            char nextRomanChar = romanNumber.charAt(i + 1);
            int nextArabicChar = getArabicChar(nextRomanChar);
            if (arabicChar < nextArabicChar) {
                arabicNumber += nextArabicChar - arabicChar;
                i += 2;
            } else {
                arabicNumber += arabicChar;
                i++;
            }
        }

        if (arabicNumber < 1 || arabicNumber > 3999) {
            throw new NoSuchNumberException(romanNumber + " can not be converted to Arabic numeral.(1-3999)");
        }

        return arabicNumber;

    }

    /**
     * This is a private method to get the Arabic value of a Roman character
     */
    private static int getArabicChar(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
