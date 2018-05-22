package com.ammarsamater.translators;

/**
 * This class provides an implementation of the {@link DigitTranslator} interface
 * This implementation uses offset calculations to perform the translations
 * 
 * @author Ammar Samater
 * @version 1.0 created on 2018/05/21
 */
public class OffsetDigitTranslator implements DigitTranslator {

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
			if (isLatinDigit(charArray[i])) {
				arabicNumber[i] = (char) (charArray[i] + 1584);
			} else if (charArray[i] == 46) {
				// check that separator is between two Latin digits
				if (isBetweenLatinDigits(charArray, i)) {
					arabicNumber[i] = (char) (1643);
				} else {
					arabicNumber[i] = charArray[i];
				}

			} else {
				arabicNumber[i] = charArray[i];
			}
		}
		return String.valueOf(arabicNumber);
	}

	/**
	 * This method checks if a character at a given index is between two Latin digits
	 * 
	 * @param charArray the character array 
	 * @param charIndex the index of the respective character within the given array
	 * @return true if the character is between two Latin digits, false otherwise 
	 */
	private boolean isBetweenLatinDigits(char[] charArray, int charIndex) {
		return charIndex > 0 && charIndex < charArray.length - 1 && isLatinDigit(charArray[charIndex - 1])
				&& isLatinDigit(charArray[charIndex + 1]);
	}

	/**
	 * Checks if a given character is a Latin digit
	 * 
	 * @param c the inquired character
	 * @return true if the character is a Latin digit, false otherwise
	 */
	private boolean isLatinDigit(char c) {
		return c < 58 && c > 47;
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
			if (isArabicDigit(charArray[i])) {
				latinNumber[i] = (char) (charArray[i] - 1584);
			} else if (charArray[i] == 1643) {
				if (isBetweenArabicDigits(charArray, i)) {
					latinNumber[i] = (char) (46);
				} else {
					latinNumber[i] = charArray[i];
				}

			} else {
				latinNumber[i] = charArray[i];
			}
		}
		return String.valueOf(latinNumber);
	}

	/**
	 * This method checks if a character at a given index is between two Arabic digits
	 * 
	 * @param charArray the character array 
	 * @param charIndex the index of the respective character within the given array
	 * @return true if the character is between two Arabic digits, false otherwise 
	 */
	private boolean isBetweenArabicDigits(char[] charArray, int charIndex) {
		return charIndex > 0 && charIndex < charArray.length - 1 && isArabicDigit(charArray[charIndex - 1])
				&& isArabicDigit(charArray[charIndex + 1]);
	}

	/**
	 * Checks if a given character is a Arabic digit
	 * 
	 * @param c the character 
	 * @return true if the character is an Arabic digit, false otherwise
	 */
	private boolean isArabicDigit(char c) {
		return c < 1642 && c > 1631;
	}

}
