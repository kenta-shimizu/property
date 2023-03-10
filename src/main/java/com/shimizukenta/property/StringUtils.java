package com.shimizukenta.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author kenta-shimizu
 *
 */
public class StringUtils {

	private StringUtils() {
		/* Nothing */
	}
	
	/**
	 * Returns UnmodifiableStringProperty.
	 * 
	 * @param initial initial value.
	 * @return UnmodifiableStringProperty
	 */
	public static AbstractStringProperty unmodifiableString(CharSequence initial) {
		
		return new AbstractUnmodifiableStringProperty(initial) {
			
			private static final long serialVersionUID = -9009688943557006510L;
		};
	}
	
	private static AbstractStringProperty __unmodifiableEmptyStringPropertyInstance = unmodifiableString(null);
	
	/**
	 * Returns Unmodifiable Empty StrigProperty.
	 * 
	 * <p>
	 * This instance is Singleton and immutable.<br />
	 * </p>
	 * 
	 * @return Unmodifiable Empty StrigProperty
	 */
	public static AbstractStringProperty getUnmodifiableEmptyString() {
		return __unmodifiableEmptyStringPropertyInstance;
	}
	
	/**
	 * InnerMonoString.
	 * 
	 * @author kenta-shimizu
	 */
	private static class InnerMonoString extends AbstractStringCompution {
		
		private static final long serialVersionUID = -7693163906123369585L;
		
		private InnerMonoString(
				Function<String, String> compute,
				StringObservable observer) {
			
			super();
			
			observer.addChangeListener(v -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(v));
				}
			});
		}
	}
	
	/**
	 * InnerStringJoiner.
	 * 
	 * @author kenta-shimizu
	 */
	private static class InnerStringJoining extends AbstractStringCompution {
		
		private static final long serialVersionUID = 4155259609010636895L;
		
		private final CharSequence delimiter;
		private final List<Inner> inners = new ArrayList<>();
		
		public InnerStringJoining(
				CharSequence delimiter,
				Iterable<StringObservable> observers) {
			
			super();
			
			this.delimiter = delimiter;
			
			for ( StringObservable o : observers ) {
				Inner i = new Inner();
				this.inners.add(i);
				o.addChangeListener(i);
			}
		}
		
		private class Inner implements ChangeListener<String> {
			
			private String last;
			
			private Inner() {
				this.last = "";
			}
			
			@Override
			public void changed(String v) {
				synchronized ( InnerStringJoining.this._sync ) {
					this.last = v;
					InnerStringJoining.this._syncSetAndNotifyChanged(
							InnerStringJoining.this.inners.stream()
							.map(x -> x.last)
							.collect(Collectors.joining(InnerStringJoining.this.delimiter)));
				}
			}
		}
	}
	
	/**
	 * InnerMonoInteger.
	 * 
	 * @author kenta-shimizu
	 *
	 */
	private static class InnerMonoInteger extends AbstractIntegerCompution {
		
		private static final long serialVersionUID = -8464912497342722456L;

		private InnerMonoInteger(
				Function<String, Integer> compute,
				StringObservable observer) {
			
			super();
			
			observer.addChangeListener(v -> {
				synchronized ( this._sync ) {
					this._syncSetAndNotifyChanged(compute.apply(v));
				}
			});
		}
	}
	
	/**
	 * InnerPredicate
	 * 
	 * @author kenta-shimizu
	 *
	 */
	private static class InnerMonoPredicate extends AbstractPredicateCompution<String> {
		
		private static final long serialVersionUID = 259962293452164287L;

		private InnerMonoPredicate(Predicate<? super String> compute) {
			super(compute, "");
		}
	}
	
	/**
	 * InnerBiPredicate.
	 * 
	 * @author kenta-shimizu
	 *
	 */
	private static class InnerBiPredicate extends AbstractBiPredicateCompution<String, String> {
		
		private static final long serialVersionUID = 8931253801771975194L;
		
		private InnerBiPredicate(BiPredicate<? super String, ? super String> compute) {
			super(compute, "", "");
		}
	}
	
	private static InnerMonoString buildMonoString(
			StringObservable observer,
			Function<String, String> compute) {
		
		return new InnerMonoString(compute, observer);
	}
	
	private static InnerMonoInteger buildMonoInteger(
			StringObservable observer,
			Function<String, Integer> compute) {
		
		return new InnerMonoInteger(compute, observer);
	}
	
	private static InnerMonoPredicate buildMonoPredicate(
			StringObservable observer,
			Predicate<String> compute) {
		
		InnerMonoPredicate i = new InnerMonoPredicate(compute);
		i.bind(observer);
		return i;
	}
	
	private static InnerBiPredicate buildBiPredicate(
			StringObservable left,
			StringObservable right,
			BiPredicate<String, String> compute) {
		
		InnerBiPredicate i = new InnerBiPredicate(compute);
		i.bindLeft(left);
		i.bindRight(right);
		return i;
	}
	
	private static InnerStringJoining buildStringJoining(
			CharSequence delimiter,
			Iterable<StringObservable> observers) {
		
		return new InnerStringJoining(delimiter, observers);
	}
	
	private static String waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer) throws InterruptedException {
		
		try {
			return i.waitUntilTrueAndGet();
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static String waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}

	private static String waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			return i.waitUntilTrueAndGet(p);
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static void waitUntil(
			AbstractBiPredicateCompution<String, String> i,
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	private static void waitUntil(
			AbstractBiPredicateCompution<String, String> i,
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	private static void waitUntil(
			AbstractBiPredicateCompution<String, String> i,
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
		}
		finally {
			i.unbindLeft(left);
			i.unbindRight(right);
		}
	}
	
	private static InnerMonoPredicate buildIsEmpty(StringObservable observer) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.isEmpty()));
	}
	
	private static InnerMonoPredicate buildIsNotEmpty(StringObservable observer) {
		
		return buildMonoPredicate(observer, v -> Boolean.valueOf(! v.isEmpty()));
	}
	
	private static InnerMonoPredicate buildContains(StringObservable observer, CharSequence s) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.contains(s)));
	}
	
	private static InnerMonoPredicate buildNotContains(StringObservable observer, CharSequence s) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(! v.contains(s)));
	}
	
	private static InnerMonoPredicate buildStartsWith(StringObservable observer, String prefix) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.startsWith(prefix)));
	}
	
	private static InnerMonoPredicate buildStartsWith(StringObservable observer, String prefix, int toOffset) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.startsWith(prefix, toOffset)));
	}
	
	private static InnerMonoPredicate buildEndsWith(StringObservable observer, String suffix) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.endsWith(suffix)));
	}
	
	private static InnerMonoPredicate buildMatches(StringObservable observer, String regex) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.matches(regex)));
	}
	
	private static InnerMonoPredicate buildContentEqualTo(StringObservable observer, CharSequence cs) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.contentEquals(cs)));
	}
	
	private static InnerMonoPredicate buildContentEqualTo(StringObservable observer, StringBuffer sb) {
		return buildMonoPredicate(observer, v -> Boolean.valueOf(v.contentEquals(sb)));
	}
	
	private static InnerBiPredicate buildIsEqualTo(StringObservable a, StringObservable b) {
		return buildBiPredicate(a, b, (l, r) -> Boolean.valueOf(l.equals(r)));
	}
	
	private static InnerBiPredicate buildIsNotEqualTo(StringObservable a, StringObservable b) {
		return buildBiPredicate(a, b, (l, r) -> Boolean.valueOf(! l.equals(r)));
	}
	
	private static InnerBiPredicate buildIsLessThan(StringObservable left, StringObservable right) {
		return buildBiPredicate(left, right, (l, r) -> Boolean.valueOf(l.compareTo(r) < 0));
	}
	
	private static InnerBiPredicate buildIsLessThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildBiPredicate(left, right, (l, r) -> Boolean.valueOf(l.compareTo(r) <= 0));
	}
	
	private static InnerBiPredicate buildIsGreaterThan(StringObservable left, StringObservable right) {
		return buildBiPredicate(left, right, (l, r) -> Boolean.valueOf(l.compareTo(r) > 0));
	}
	
	private static InnerBiPredicate buildIsGreaterThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildBiPredicate(left, right, (l, r) -> Boolean.valueOf(l.compareTo(r) >= 0));
	}
	
	private static InnerBiPredicate buildIsEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildBiPredicate(a, b, (l, r) -> Boolean.valueOf(l.equalsIgnoreCase(r)));
	}
	
	private static InnerBiPredicate buildIsNotEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildBiPredicate(a, b, (l, r) -> Boolean.valueOf(! l.equalsIgnoreCase(r)));
	}
	
	/**
	 * Returns StringCompution of toUpperCase.
	 * 
	 * @param observer the observer
	 * @return StringCompution of toUpperCase
	 * @see String#toUpperCase()
	 */
	public static AbstractStringCompution computeToUpperCase(StringObservable observer) {
		return buildMonoString(observer, v -> v.toUpperCase());
	}
	
	/**
	 * Returns StringCompution of toUppseCase.
	 * 
	 * @param observer the observer
	 * @param locale use the case transformation rules for this locale
	 * @return StringCompution of toUppseCase
	 * @see String#toUpperCase(Locale)
	 */
	public static AbstractStringCompution computeToUpperCase(StringObservable observer, Locale locale) {
		return buildMonoString(observer, v -> v.toUpperCase(locale));
	}
	
	/**
	 * Returns StringCompution of toLowerCase.
	 * 
	 * @param observer the observer
	 * @return StringCompution of toLowerCase
	 * @see String#toLowerCase()
	 */
	public static AbstractStringCompution computeToLowerCase(StringObservable observer) {
		return buildMonoString(observer, v -> v.toLowerCase());
	}
	
	/**
	 * Returns StringCompution of toLowerCase.
	 * 
	 * @param observer the observer
	 * @param locale use the case transformation rules for this locale
	 * @return StringCompution of toLowerCase
	 * @see String#toLowerCase(Locale)
	 */
	public static AbstractStringCompution computeToLowerCase(StringObservable observer, Locale locale) {
		return buildMonoString(observer, v -> v.toLowerCase(locale));
	}
	
	/**
	 * Returns StringCompution of trim.
	 * 
	 * @param observer the observer
	 * @return StringCompution of trim
	 * @see String#trim()
	 */
	public static AbstractStringCompution computeTrim(StringObservable observer) {
		return buildMonoString(observer, v -> v.trim());
	}
	
	/**
	 * Returns StringCompution of concat.
	 * 
	 * @param observer the observer
	 * @param str the String that is concatenated to the end of this String.
	 * @return StringCompution of concat
	 * @see String#concat(String)
	 */
	public static AbstractStringCompution computeConcat(StringObservable observer, String str) {
		return buildMonoString(observer, v -> v.concat(str));
	}
	
	/**
	 * Returns StringCompution of replace.
	 * 
	 * @param observer the observer
	 * @param oldChar the old character.
	 * @param newChar the new character.
	 * @return StringCompution of replace
	 * @see String#replace(char, char)
	 */
	public static AbstractStringCompution computeReplace(StringObservable observer, char oldChar, char newChar) {
		return buildMonoString(observer, v -> v.replace(oldChar, newChar));
	}
	
	/**
	 * Returns StringCompution of replace.
	 * 
	 * @param observer the observer
	 * @param target The sequence of char values to be replaced
	 * @param replacement The replacement sequence of char values
	 * @return StringCompution of replace
	 * @see String#replace(CharSequence, CharSequence)
	 */
	public static AbstractStringCompution computeReplace(StringObservable observer, CharSequence target, CharSequence replacement) {
		return buildMonoString(observer, v -> v.replace(target, replacement));
	}
	
	/**
	 * Returns StringCompution of replaceAll.
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @param replacement the string to be substituted for each match
	 * @return StringCompution of replaceAll
	 * @see String#replaceAll(String, String)
	 */
	public static AbstractStringCompution computeReplaceAll(StringObservable observer, String regex, String replacement) {
		return buildMonoString(observer, v -> v.replaceAll(regex, replacement));
	}
	
	/**
	 * Returns StringCompution of replaceFirst.
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @param replacement the string to be substituted for the first match
	 * @return StringCompution of replaceFirst
	 * @see String#replaceFirst(String, String)
	 */
	public static AbstractStringCompution computeReplaceFirst(StringObservable observer, String regex, String replacement) {
		return buildMonoString(observer, v -> v.replaceFirst(regex, replacement));
	}
	
	/**
	 * Returns PredicateCompution of empty.
	 * 
	 * @param observer the observer
	 * @return PredicateCompution of empty
	 * @see String#isEmpty()
	 */
	public static AbstractPredicateCompution<String> computeIsEmpty(StringObservable observer) {
		return buildIsEmpty(observer);
	}
	
	/**
	 * Returns PredicateCompution of NOT empty.
	 * 
	 * @param observer the observer
	 * @return PredicateCompution of NOT empty
	 * @see String#isEmpty()
	 */
	public static AbstractPredicateCompution<String> computeIsNotEmpty(StringObservable observer) {
		return buildIsNotEmpty(observer);
	}
	
	/**
	 * Returns PredicateCompution of contains.
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @return PredicateCompution of contains
	 * @see String#contains(CharSequence)
	 */
	public static AbstractPredicateCompution<String> computeContains(StringObservable observer, CharSequence s) {
		return buildContains(observer, s);
	}
	
	/**
	 * Returns PredicateCompution of NOT contains.
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @return PredicateCompution of NOT contains
	 * @see String#contains(CharSequence)
	 */
	public static AbstractPredicateCompution<String> computeNotContains(StringObservable observer, CharSequence s) {
		return buildNotContains(observer, s);
	}
	
	/**
	 * Returns PredicateCompution of startsWith.
	 * 
	 * @param observer the observer
	 * @param prefix the prefix.
	 * @return PredicateCompution of startsWith
	 * @see String#startsWith(String)
	 */
	public static AbstractPredicateCompution<String> computeStartsWith(StringObservable observer, String prefix) {
		return buildStartsWith(observer, prefix);
	}
	
	/**
	 * Returns PredicateCompution of startsWith.
	 * 
	 * @param observer the observer
	 * @param prefix the prefix.
	 * @param toOffset where to begin looking in this string.
	 * @return PredicateCompution of startsWith
	 * @see String#startsWith(String, int)
	 */
	public static AbstractPredicateCompution<String> computeStartsWith(StringObservable observer, String prefix, int toOffset) {
		return buildStartsWith(observer, prefix, toOffset);
	}
	
	/**
	 * Returns PredicateCompution of endsWith.
	 * 
	 * @param observer the observer
	 * @param suffix the suffix.
	 * @return PredicateCompution of endsWith
	 * @see String#endsWith(String)
	 */
	public static AbstractPredicateCompution<String> computeEndsWith(StringObservable observer, String suffix) {
		return buildEndsWith(observer, suffix);
	}
	
	/**
	 * Returns PredicateCompution of matches.
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @return PredicateCompution of matches
	 * @see String#matches(String)
	 */
	public static AbstractPredicateCompution<String> computeMatches(StringObservable observer, String regex) {
		return buildMatches(observer, regex);
	}
	
	/**
	 * Returns PredicateCompution of contentEquals.
	 * 
	 * @param observer the observer
	 * @param cs The sequence to compare this String against
	 * @return PredicateCompution of contentEquals
	 * @see String#contentEquals(CharSequence)
	 */
	public static AbstractPredicateCompution<String> computeContentEqualTo(StringObservable observer, CharSequence cs) {
		return buildContentEqualTo(observer, cs);
	}
	
	/**
	 * Returns PredicateCompution of contentEquals.
	 * 
	 * @param observer the observer
	 * @param sb The StringBuffer to compare this String against
	 * @return PredicateCompution of contentEquals
	 * @see String#contentEquals(StringBuffer)
	 */
	public static AbstractPredicateCompution<String> computeContentEqualTo(StringObservable observer, StringBuffer sb) {
		return buildContentEqualTo(observer, sb);
	}
	
	/**
	 * Returns IntegerCompution of length.
	 * 
	 * @param observer the observer
	 * @return IntegerCompution of length
	 * @see String#length()
	 */
	public static AbstractIntegerCompution computeLength(StringObservable observer) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.length()));
	}
	
	/**
	 * Returns IntegerCompution of indexOf.
	 * 
	 * @param observer the observer
	 * @param str the substring to search for.
	 * @return IntegerCompution of indexOf
	 * @see String#indexOf(String)
	 */
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, String str) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(str)));
	}
	
	/**
	 * Returns IntegerCompution of indexOf.
	 * 
	 * @param observer the observer
	 * @param ch a character (Unicode code point).
	 * @return IntegerCompution of indexOf
	 * @see String#indexOf(int)
	 */
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, int ch) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(ch)));
	}
	
	/**
	 * Returns IntegerCompution of indexOf.
	 * 
	 * @param observer the observer
	 * @param str the substring to search for.
	 * @param fromIndex the index from which to start the search.
	 * @return IntegerCompution of indexOf
	 * @see String#indexOf(String, int)
	 */
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, String str, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(str, fromIndex)));
	}
	
	/**
	 * Returns IntegerCompution of indexOf.
	 * 
	 * @param observer the observer
	 * @param ch a character (Unicode code point).
	 * @param fromIndex the index from which to start the search.
	 * @return IntegerCompution of indexOf
	 * @see String#indexOf(int, int)
	 */
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, int ch, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(ch, fromIndex)));
	}
	
	/**
	 * Returns IntegerCompution of lastIndexOf.
	 * 
	 * @param observer the observer
	 * @param str the substring to search for.
	 * @return IntegerCompution of lastIndexOf
	 * @see String#lastIndexOf(String)
	 */
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, String str) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(str)));
	}
	
	/**
	 * Returns IntegerCompution of lastIndexOf.
	 * 
	 * @param observer the observer
	 * @param str the substring to search for.
	 * @param fromIndex the index to start the search from.
	 * @return IntegerCompution of lastIndexOf
	 * @see String#lastIndexOf(String, int)
	 */
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, String str, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(str, fromIndex)));
	}
	
	/**
	 * Returns IntegerCompution of lastIndexOf.
	 * 
	 * @param observer the observer
	 * @param ch a character (Unicode code point).
	 * @return IntegerCompution of lastIndexOf
	 * @see String#lastIndexOf(int)
	 */
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, int ch) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(ch)));
	}
	
	/**
	 * Returns IntegerCompution of lastIndexOf.
	 * 
	 * @param observer the observer
	 * @param ch a character (Unicode code point).
	 * @param fromIndex the index to start the search from. There is no restriction on the value of fromIndex. If it is greater than or equal to the length of this string, it has the same effect as if it were equal to one less than the length of this string: this entire string may be searched. If it is negative, it has the same effect as if it were -1: -1 is returned.
	 * @return IntegerCompution of lastIndexOf
	 * @see String#lastIndexOf(int, int)
	 */
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, int ch, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(ch, fromIndex)));
	}
	
	/**
	 * Returns BiPredicateCompution of equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @return BiPredicateCompution of equals.
	 * @see String#equals(Object)
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsEqualTo(StringObservable a, StringObservable b) {
		return buildIsEqualTo(a, b);
	}
	
	/**
	 * Returns BiPredicateCompution of  NOT equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @return BiPredicateCompution of NOT equals.
	 * @see String#equals(Object)
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsNotEqualTo(StringObservable a, StringObservable b) {
		return buildIsNotEqualTo(a, b);
	}
	
	/**
	 * Returns BiPredicateCompution of {@code (left < right)}.
	 * 
	 * @param left left observer
	 * @param right right observer
	 * @return BiPredicateCompution of {@code (left < right)}
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsLessThan(StringObservable left, StringObservable right) {
		return buildIsLessThan(left, right);
	}
	
	/**
	 * Returns BiPredicateCompution of {@code (left <= right)}.
	 * 
	 * @param left left observer
	 * @param right right observer
	 * @return BiPredicateCompution of {@code (left <= right)}
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsLessThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildIsLessThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns BiPredicateCompution of {@code (left > right)}.
	 * 
	 * @param left left observer
	 * @param right right observer
	 * @return BiPredicateCompution of {@code (left > right)}
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsGreaterThan(StringObservable left, StringObservable right) {
		return buildIsGreaterThan(left, right);
	}
	
	/**
	 * Returns BiPredicateCompution of {@code (left >= right)}.
	 * 
	 * @param left left observer
	 * @param right right observer
	 * @return BiPredicateCompution of {@code (left >= right)}
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsGreaterThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildIsGreaterThanOrEqualTo(left, right);
	}
	
	/**
	 * Returns BiPredicateCompution of equalsToIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @return BiPredicateCompution of equalsToIgnoreCase
	 * @see String#equalsIgnoreCase(String)
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildIsEqualToIgnoreCase(a, b);
	}
	
	/**
	 * Returns BiPredicateCompution of NOT equalsToIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @return BiPredicateCompution of NOT equalsToIgnoreCase
	 * @see String#equalsIgnoreCase(String)
	 */
	public static AbstractBiPredicateCompution<String, String> computeIsNotEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildIsNotEqualToIgnoreCase(a, b);
	}
	
	/**
	 * Returns StringCompution of join observers.
	 * 
	 * @param delimiter a sequence of characters that is used to separate each of the elements in the resulting String
	 * @param observers the observers
	 * @return StringCompution of join observers
	 * @see String#join(CharSequence, Iterable)
	 */
	public static AbstractStringCompution computeJoin(CharSequence delimiter, Iterable<StringObservable> observers) {
		return buildStringJoining(delimiter, observers);
	}
	
	/**
	 * Waiting until value is empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsEmpty(
			StringObservable observer) throws InterruptedException {
		
		return waitUntil(buildIsEmpty(observer), observer);
	}
	
	/**
	 * Waiting until value is empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsEmpty(
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildIsEmpty(observer), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsEmpty(
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildIsEmpty(observer), observer, p);
	}
	
	/**
	 * Waiting until value is NOT empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsNotEmpty(
			StringObservable observer) throws InterruptedException {
		
		return waitUntil(buildIsNotEmpty(observer), observer);
	}
	
	/**
	 * Waiting until value is NOT empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsNotEmpty(
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildIsNotEmpty(observer), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is NOT empty, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT empty, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#isEmpty()
	 */
	public static String waitUntilIsNotEmpty(
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildIsNotEmpty(observer), observer, p);
	}
	
	/**
	 * Waiting until value is contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilContains(
			StringObservable observer,
			CharSequence s) throws InterruptedException {
		
		return waitUntil(buildContains(observer, s), observer);
	}
	
	/**
	 * Waiting until value is contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilContains(
			StringObservable observer,
			CharSequence s,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContains(observer, s), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilContains(
			StringObservable observer,
			CharSequence s,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContains(observer, s), observer, p);
	}
	
	/**
	 * Waiting until value is NOT contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilNotContains(
			StringObservable observer,
			CharSequence s) throws InterruptedException {
		
		return waitUntil(buildNotContains(observer, s), observer);
	}
	
	/**
	 * Waiting until value is NOT contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilNotContains(
			StringObservable observer,
			CharSequence s,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildNotContains(observer, s), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is NOT contains, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is NOT contains, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param s the sequence to search for
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contains(CharSequence)
	 */
	public static String waitUntilNotContains(
			StringObservable observer,
			CharSequence s,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildNotContains(observer, s), observer, p);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#startsWith(String)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix) throws InterruptedException {
		
		return waitUntil(buildStartsWith(observer, prefix), observer);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#startsWith(String)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildStartsWith(observer, prefix), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#startsWith(String)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildStartsWith(observer, prefix), observer, p);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix.
	 * @param toOffset where to begin looking in this string.
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#startsWith(String, int)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset) throws InterruptedException {
		
		return waitUntil(buildStartsWith(observer, prefix, toOffset), observer);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix.
	 * @param toOffset where to begin looking in this string.
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#startsWith(String, int)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildStartsWith(observer, prefix, toOffset), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is startsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is startsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param prefix the prefix.
	 * @param toOffset where to begin looking in this string.
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#startsWith(String, int)
	 */
	public static String waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildStartsWith(observer, prefix, toOffset), observer, p);
	}
	
	/**
	 * Waiting until value is endsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is endsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param suffix the suffix.
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#endsWith(String)
	 */
	public static String waitUntilEndsWith(
			StringObservable observer,
			String suffix) throws InterruptedException {
		
		return waitUntil(buildEndsWith(observer, suffix), observer);
	}
	
	/**
	 * Waiting until value is endsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is endsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param suffix the suffix.
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#endsWith(String)
	 */
	public static String waitUntilEndsWith(
			StringObservable observer,
			String suffix,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildEndsWith(observer, suffix), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is endsWith, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is endsWith, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param suffix the suffix.
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#endsWith(String)
	 */
	public static String waitUntilEndsWith(
			StringObservable observer,
			String suffix,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildEndsWith(observer, suffix), observer, p);
	}
	
	/**
	 * Waiting until value is matches, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is matches, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#matches(String)
	 */
	public static String waitUntilMatches(
			StringObservable observer,
			String regex) throws InterruptedException {
		
		return waitUntil(buildMatches(observer, regex), observer);
	}
	
	/**
	 * Waiting until value is matches, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is matches, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#matches(String)
	 */
	public static String waitUntilMatches(
			StringObservable observer,
			String regex,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildMatches(observer, regex), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is matches, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is matches, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param regex the regular expression to which this string is to be matched
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#matches(String)
	 */
	public static String waitUntilMatches(
			StringObservable observer,
			String regex,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildMatches(observer, regex), observer, p);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param cs The sequence to compare this String against
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#contentEquals(CharSequence)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs) throws InterruptedException {
		
		return waitUntil(buildContentEqualTo(observer, cs), observer);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param cs The sequence to compare this String against
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contentEquals(CharSequence)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContentEqualTo(observer, cs), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param cs The sequence to compare this String against
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contentEquals(CharSequence)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContentEqualTo(observer, cs), observer, p);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param sb The StringBuffer to compare this String against
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#contentEquals(StringBuffer)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb) throws InterruptedException {
		
		return waitUntil(buildContentEqualTo(observer, sb), observer);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param sb The StringBuffer to compare this String against
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contentEquals(StringBuffer)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContentEqualTo(observer, sb), observer, timeout, unit);
	}
	
	/**
	 * Waiting until value is contentEquals, and return last value.
	 * 
	 * <p>
	 * This is blocking method.<br />
	 * If already value is contentEquals, return last value immediately.<br />
	 * </p>
	 * 
	 * @param observer the observer
	 * @param sb The StringBuffer to compare this String against
	 * @param p the TimeoutProperty
	 * @return last value
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#contentEquals(StringBuffer)
	 */
	public static String waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		return waitUntil(buildContentEqualTo(observer, sb), observer, p);
	}
	
	/**
	 * Waiting until equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsEqualTo(a, b), a, b);
	}
	
	/**
	 * Waiting until equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualTo(a, b), a, b, timeout, unit);
	}
	
	/**
	 * Waiting until equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param p TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualTo(a, b), a, b, p);
	}
	
	/**
	 * Waiting until NOT equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b);
	}
	
	/**
	 * Waiting until NOT equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b, timeout, unit);
	}
	
	/**
	 * Waiting until NOT equals.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param p TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b, p);
	}
	
	/**
	 * Waiting until {@code (left < right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsLessThan(left, right), left, right);
	}
	
	/**
	 * Waiting until {@code (left < right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThan(left, right), left, right, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (left < right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param p the TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThan(left, right), left, right, p);
	}
	
	/**
	 * Waiting until {@code (left <= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right);
	}
	
	/**
	 * Waiting until {@code (left <= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (left <= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param p the TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right, p);
	}
	
	/**
	 * Waiting until {@code (left > right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right);
	}
	
	/**
	 * Waiting until {@code (left > right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (left > right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param p the TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right, p);
	}
	
	/**
	 * Waiting until {@code (left >= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @throws InterruptedException if interrupted while waiting
	 */
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right);
	}
	
	/**
	 * Waiting until {@code (left >= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	/**
	 * Waiting until {@code (left >= right)}.
	 * 
	 * @param left the left observer
	 * @param right the right observer
	 * @param p the TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 */
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right, p);
	}
	
	/**
	 * Waiting until equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b);
	}
	
	/**
	 * Waiting until equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b, timeout, unit);
	}
	
	/**
	 * Waiting until equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param p TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b, p);
	}
	
	/**
	 * Waiting until NOT equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @throws InterruptedException if interrupted while waiting
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b);
	}
	
	/**
	 * Waiting until NOT equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param timeout the maximum time to wait
	 * @param unit the time unit of the timeout argument
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b, timeout, unit);
	}
	
	/**
	 * Waiting until NOT equalsIgnoreCase.
	 * 
	 * @param a the observer A
	 * @param b the observer B
	 * @param p TimeoutProperty
	 * @throws InterruptedException if interrupted while waiting
	 * @throws TimeoutException if the wait timed out
	 * @see String#equalsIgnoreCase(String)
	 */
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b, p);
	}
	
}
