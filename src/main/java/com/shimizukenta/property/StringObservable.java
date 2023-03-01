package com.shimizukenta.property;

import java.util.Locale;

/**
 * String value Observer.
 * 
 * @author shimizukenta
 * @see Observable
 */
public interface StringObservable extends Observable<String> {
	
	/**
	 * Returns StringCompution of converted to uppercase.
	 * 
	 * @return StringCompution of converted to uppercase
	 * @see String#toUpperCase()
	 */
	default public StringCompution computeToUpperCase() {
		return StringUtils.computeToUpperCase(this);
	}
	
	/**
	 * Returns StringCompution of converted to uppercase.
	 * 
	 * @param locale use the case transformation rules for this locale
	 * @return StringCompution of converted to uppercase
	 * @see String#toUpperCase(Locale)
	 */
	default public StringCompution computeToUpperCase(Locale locale) {
		return StringUtils.computeToUpperCase(this, locale);
	}
	
	/**
	 * Returns StringCompution of converted to lowercase.
	 * 
	 * @return StringCompution of converted to lowercase
	 * @see String#toLowerCase()
	 */
	default public StringCompution computeToLowerCase() {
		return StringUtils.computeToLowerCase(this);
	}
	
	/**
	 * Returns StringCompution of converted to lowercase.
	 * 
	 * @param locale use the case transformation rules for this locale
	 * @return StringCompution of converted to lowercase
	 * @see String#toLowerCase(Locale)
	 */
	default public StringCompution computeToLowerCase(Locale locale) {
		return StringUtils.computeToLowerCase(this, locale);
	}
	
	/**
	 * Return StringCompution of converted to trim.
	 * 
	 * @return StringCompution of converted to trim
	 * @see String#trim()
	 */
	default public StringCompution computeTrim() {
		return StringUtils.computeTrim(this);
	}
	
	/**
	 * Returns StringCompution of convert to concat.
	 * 
	 * @param str the String that is concatenated to the end of this String.
	 * @return StringCompution of convert to concat
	 * @see String#concat(String)
	 */
	default public StringCompution computeConcat(String str) {
		return StringUtils.computeConcat(this, str);
	}
	
	/**
	 * Returns StringCompution of convert to replace.
	 * 
	 * @param oldChar the old character.
	 * @param newChar the new character.
	 * @return StringCompution of convert to replace
	 * @see String#replace(char, char)
	 */
	default public StringCompution computeReplace(char oldChar, char newChar) {
		return StringUtils.computeReplace(this, oldChar, newChar);
	}
	
	/**
	 * Returns StringCompution of convert to replace.
	 * 
	 * @param target The sequence of char values to be replaced
	 * @param replacement  The replacement sequence of char values
	 * @return StringCompution of convert to replace
	 * @see String#replace(CharSequence, CharSequence)
	 */
	default public StringCompution computeReplace(CharSequence target, CharSequence replacement) {
		return StringUtils.computeReplace(this, target, replacement);
	}
	
	/**
	 * Returns StringCompution of convert to replaceAll.
	 * 
	 * @param regex the regular expression to which this string is to be matched
	 * @param replacement the string to be substituted for each match
	 * @return StringCompution of convert to replaceAll
	 * @see String#replaceAll(String, String)
	 */
	default public StringCompution computeReplaceAll(String regex, String replacement) {
		return StringUtils.computeReplaceAll(this, regex, replacement);
	}
	
	/**
	 * Returns StringCompution of convert to replaceFirst.
	 * 
	 * @param regex the regular expression to which this string is to be matched
	 * @param replacement the string to be substituted for the first match
	 * @return StringCompution of convert to replaceFirst
	 * @see String#replaceFirst(String, String)
	 */
	default public StringCompution computeReplaceFirst(String regex, String replacement) {
		return StringUtils.computeReplaceFirst(this, regex, replacement);
	}
	
	/**
	 * Returns BooleanCompution of isEmpty.
	 * 
	 * @return BooleanCompution of isEmpty
	 * @see StringProperty#isEmpty()
	 */
	default public BooleanCompution computeIsEmpty() {
		return StringUtils.computeIsEmpty(this);
	}
	
	/**
	 * Returns BooleanCompution of NOT isEmpty.
	 * 
	 * @return BooleanCompution of NOT isEmpty
	 * @see StringProperty#isEmpty()
	 */
	default public BooleanCompution computeIsNotEmpty() {
		return StringUtils.computeIsNotEmpty(this);
	}
	
	
	//TODO
	//boolean
	
	
	/**
	 * Returns IntegerCompution of String length.
	 * 
	 * @return IntegerCompution of String length
	 * @see String#length()
	 */
	default public IntegerCompution computeLength() {
		return StringUtils.computeLength(this);
	}
	
	/**
	 * Returns IntegerCompution of String indexOf.
	 * 
	 * @param str the substring to search for.
	 * @return IntegerCompution of String IndexOf
	 * @see String#indexOf(String)
	 */
	default public IntegerCompution computeIndexOf(String str) {
		return StringUtils.computeIndexOf(this, str);
	}
	
	/**
	 * Returns IntegerCompution of String indexOf.
	 * 
	 * @param ch a character (Unicode code point).
	 * @return IntegerCompution of String indexOf
	 * @see String#indexOf(int)
	 */
	default public IntegerCompution computeIndexOf(int ch) {
		return StringUtils.computeIndexOf(this, ch);
	}
	
	/**
	 * Returns IntegerCompution of String indexOf.
	 * 
	 * @param str the substring to search for.
	 * @param fromIndex  the index from which to start the search.
	 * @return IntegerCompution of String indexOf
	 * @see String#indexOf(String, int)
	 */
	default public IntegerCompution computeIndexOf(String str, int fromIndex) {
		return StringUtils.computeIndexOf(this, str, fromIndex);
	}
	
	/**
	 * Returns IntegerCompution of String indexOf.
	 * 
	 * @param ch a character (Unicode code point).
	 * @param fromIndex the index to start the search from.
	 * @return IntegerCompution of String indexOf
	 * @see String#indexOf(int, int)
	 */
	default public IntegerCompution computeIndexOf(int ch, int fromIndex) {
		return StringUtils.computeIndexOf(this, ch, fromIndex);
	}
	
	/**
	 * Returns IntegerCompution of String lastIndexOf.
	 * 
	 * @param str the substring to search for.
	 * @return IntegerCompution of String lastIndexOf
	 * @see String#lastIndexOf(String)
	 */
	default public IntegerCompution computeLastIndexOf(String str) {
		return StringUtils.computeLastIndexOf(this, str);
	}
	
	/**
	 * Returns IntegerCompution of String lastIndexOf.
	 * 
	 * @param str the substring to search for.
	 * @param fromIndex the index to start the search from.
	 * @return IntegerCompution of String lastIndexOf
	 * @see String#lastIndexOf(String, int)
	 */
	default public IntegerCompution computeLastIndexOf(String str, int fromIndex) {
		return StringUtils.computeLastIndexOf(this, str, fromIndex);
	}
	
	/**
	 * Returns IntegerCompution of String lastIndexOf.
	 * 
	 * @param ch a character (Unicode code point).
	 * @return IntegerCompution of String lastIndexOf
	 * @see String#lastIndexOf(int)
	 */
	default public IntegerCompution computeLastIndexOf(int ch) {
		return StringUtils.computeLastIndexOf(this, ch);
	}
	
	/**
	 * Returns IntegerCompution of String lastIndexOf.
	 * 
	 * @param ch a character (Unicode code point).
	 * @param fromIndex the index to start the search from. There is no restriction on the value of fromIndex. If it is greater than or equal to the length of this string, it has the same effect as if it were equal to one less than the length of this string: this entire string may be searched. If it is negative, it has the same effect as if it were -1: -1 is returned.
	 * @return IntegerCompution of String lastIndexOf
	 * @see String#lastIndexOf(int, int)
	 */
	default public IntegerCompution computeLastIndexOf(int ch, int fromIndex) {
		return StringUtils.computeLastIndexOf(this, ch, fromIndex);
	}
	
}
