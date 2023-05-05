package org.rivor.validation;

import junit.framework.TestCase;
import org.rivor.numeral.validation.ArabicValidate;

/**
 * FileName: ArabicValidateTest.java
 * Date: 5/4/2023
 * Time: 3:37 PM
 * Author: river
 */
public class ArabicValidateTest extends TestCase {

    public void testIsArabicNumeral() {
        assertFalse(ArabicValidate.isArabicNaturalNumeral(null));
    }
}