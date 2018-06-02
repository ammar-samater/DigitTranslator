/**
 * 
 */
package com.ammarsamater.translators;

import java.util.HashMap;

/**
 * This class provides an implementation of the {@link DigitTranslator} interface
 * This implementation uses character mapping to perform the translations
 * 
 * @author Ammar Samater
 *
 */
public class HashDigitTranslator implements DigitTranslator {

	private HashMap<Character, Character> arabicDigitsMap;
	private HashMap<Character, Character> latinDigitsMap;

	/**
	 * 
	 */
	public HashDigitTranslator() {
		super();
		arabicDigitsMap = new HashMap<Character, Character>();
		latinDigitsMap = new HashMap<Character, Character>();

		char[] arabicDigits = "١٢٣٤٥٦٧٨٩٠".toCharArray();
		char[] latingDigits = "1234567890".toCharArray();

		for (int i = 0; i < arabicDigits.length; i++) {
			latinDigitsMap.put(arabicDigits[i], latingDigits[i]);
		}

		for (int i = 0; i < latingDigits.length; i++) {
			arabicDigitsMap.put(latingDigits[i], arabicDigits[i]);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ammarsamater.translators.DigitTranslator#toArabicDigits(java.lang.String)
	 */
	@Override
	public String toArabicDigits(String latinNumber) {
		if (latinNumber == null) {
			throw new IllegalArgumentException("Invalid null argument");
		}
		char[] charArray = latinNumber.toCharArray();
		char[] arabicNumber = new char[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '.') {
				if (isBetweenLatinDigits(charArray, i)) {
					arabicNumber[i] = '٫';
				} else {
					arabicNumber[i] = charArray[i];
				}
			} else if (isLatinDigit(charArray[i])) {
				arabicNumber[i] = arabicDigitsMap.get(charArray[i]);
			} else {
				arabicNumber[i] = charArray[i];
			}
		}
		return String.valueOf(arabicNumber);
	}

	private boolean isBetweenLatinDigits(char[] charArray, int charIndex) {
		return charIndex > 0 && charIndex < charArray.length - 1 && isLatinDigit(charArray[charIndex - 1])
				&& isLatinDigit(charArray[charIndex + 1]);
	}

	private boolean isLatinDigit(char c) {
		return latinDigitsMap.containsValue(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ammarsamater.translators.DigitTranslator#toLatinDigits(java.lang.String)
	 */
	@Override
	public String toLatinDigits(String arabicNumber) {
		if (arabicNumber == null) {
			throw new IllegalArgumentException("Invalid null argument");
		}
		char[] charArray = arabicNumber.toCharArray();
		char[] latinNumber = new char[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '٫') {
				if (isBetweenArabicDigits(charArray, i)) {
					latinNumber[i] = '.';
				} else {
					latinNumber[i] = charArray[i];
				}
			} else if (isArabicDigit(charArray[i])) {
				latinNumber[i] = latinDigitsMap.get(charArray[i]);
			} else {
				latinNumber[i] = charArray[i];
			}
		}
		return String.valueOf(latinNumber);
	}

	private boolean isBetweenArabicDigits(char[] charArray, int charIndex) {
		return charIndex > 0 && charIndex < charArray.length - 1 && isArabicDigit(charArray[charIndex - 1])
				&& isArabicDigit(charArray[charIndex + 1]);
	}

	private boolean isArabicDigit(char c) {
		return arabicDigitsMap.containsValue(c);
	}

}
