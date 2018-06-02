/**
 * 
 */
package com.ammarsamater.translators_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ammarsamater.translators.HashDigitTranslator;



/**
 * @author Ammar Samater
 * @version 1.0 created on 2018/06/02
 */
public class HashDigitTranslatorTest {

	private static HashDigitTranslator hashDigitTranslator;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hashDigitTranslator = new HashDigitTranslator();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_allDigits() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("1234567890");
		assertEquals("", "١٢٣٤٥٦٧٨٩٠", arabicDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withNonDigitCharacters() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("10/5/2017");
		assertEquals("", "١٠/٥/٢٠١٧", arabicDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withEmptyStringAsInput() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("");
		assertEquals("", "", arabicDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withArabicDigits() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("١٠/٥/٢٠١٧");
		assertEquals("", "١٠/٥/٢٠١٧", arabicDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withDecimalSeprator() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("17.20");
		assertEquals("", "١٧٫٢٠", arabicDigit);
	}
	
	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withDecimalSepratorInNonNumaricalString() {
		String arabicDigit = hashDigitTranslator.toArabicDigits("17.20 sam.tom");
		assertEquals("", "١٧٫٢٠ sam.tom", arabicDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toArabicDigits_withNullParameter() {
		thrown.expect(IllegalArgumentException.class);
		hashDigitTranslator.toArabicDigits(null);
	}

	
	
	
	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toLatinDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLatinDigits_allDigits() {
		String latinDigit = hashDigitTranslator.toLatinDigits("١٢٣٤٥٦٧٨٩٠");
		assertEquals("", "1234567890", latinDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toLatinDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLatinDigits_withNonDigitCharacters() {
		String latinDigit = hashDigitTranslator.toLatinDigits("١٠/٥/٢٠١٧");
		assertEquals("", "10/5/2017", latinDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toLatinDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLatinDigits_withEmptyStringAsInput() {
		String latinDigit = hashDigitTranslator.toLatinDigits("");
		assertEquals("", "", latinDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLatinDigits_withLatinDigits() {
		String latinDigit = hashDigitTranslator.toLatinDigits("10/5/2017");
		assertEquals("", "10/5/2017", latinDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLAtinDigits_withDecimalSeprator() {
		String latincDigit = hashDigitTranslator.toLatinDigits("١٧٫٢٠");
		assertEquals("", "17.20", latincDigit);
	}
	
	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toArabicDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLAtinDigits_withDecimalSepratorInNonNumaricalString() {
		String latincDigit = hashDigitTranslator.toLatinDigits("١٧٫٢٠ أحمد٫داود");
		assertEquals("", "17.20 أحمد٫داود", latincDigit);
	}

	/**
	 * Test method for
	 * {@link test.offsetDigitTranslator#toLatinDigits(java.lang.String)}.
	 */
	@Test
	public void test_toLatinDigits_withNullParameter() {
		thrown.expect(IllegalArgumentException.class);
		hashDigitTranslator.toLatinDigits(null);
	}

}
