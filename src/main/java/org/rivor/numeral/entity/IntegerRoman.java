package org.rivor.numeral.entity;

import org.rivor.numeral.conversion.RomanConvert;

import java.util.Objects;


/**
 * This is a Roman numeral entity class
 *
 * @author riverify
 * @version JDK 8
 */
public class IntegerRoman {

    private String roman;

    private Integer value;


    // constructors

    public IntegerRoman() {

    }

    public IntegerRoman(String roman) {
        this.roman = roman;
        this.value = RomanConvert.romanToArabic(roman);
    }

    public IntegerRoman(Integer arabic) {
        this.value = arabic;
        this.roman = RomanConvert.arabicToRoman(arabic);
    }


    // getter & setter

    public String getRoman() {
        return roman;
    }

    public void setRoman(String roman) {
        this.roman = roman;
        this.value = RomanConvert.romanToArabic(roman);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer arabic) {
        this.value = arabic;
        this.roman = RomanConvert.arabicToRoman(arabic);
    }


    // override methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerRoman that = (IntegerRoman) o;

        if (!Objects.equals(roman, that.roman)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = roman != null ? roman.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return roman;
    }


    // other methods

    // arithmetic - add
    public void add(IntegerRoman other) {

        // if the value of the IntegerRoman object is null, throw an exception
        if (this.value == null || other.getValue() == null) {
            throw new NullPointerException("The value of the IntegerRoman object is null.");
        }

        // make sure the result of the addition is not greater than 3999
        if (this.value + other.getValue() > 3999) {
            throw new IllegalArgumentException("The result of the addition '" + value + "' is greater than 3999.");
        }

        // add the value of the IntegerRoman object
        this.value += other.getValue();
        this.roman = RomanConvert.arabicToRoman(this.value);

    }

    public void add(Integer other) {
        this.add(new IntegerRoman(other));
    }

    public void add(String other) {
        this.add(new IntegerRoman(other));
    }

}
