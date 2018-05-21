package com.ammarsamater.translators;

/**
 * This class provides static methods that translate the digits in a given
 * string from Latin to Arabic and vice-versa
 * 
 * @author Ammar Samater
 * @version 1.0 created on 2018/05/21
 */
public interface DigitTranslator {

	/**
	 * Translates any Latin digits in a string to the corresponding Arabic digits
	 * The thousands separator(comma) is also translated
	 * 
	 * @param latinNumber
	 *            string with Latin digits
	 * @return a string with translated digits
	 */
	public String toArabicDigits(String latinNumber);

	/**
	 * Translates any Arabic digits in a string to the corresponding Latin digits
	 * The thousands separator is also translated
	 * 
	 * @param arabicNumber
	 *            string with Arabic digits
	 * 
	 * @return a string with translated digits
	 */
	public String toLatinDigits(String arabicNumber);

}
