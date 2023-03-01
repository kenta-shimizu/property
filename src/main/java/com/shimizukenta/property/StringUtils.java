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
	
	public static AbstractStringProperty unmodifiableString(CharSequence initial) {
		
		return new AbstractUnmodifiableStringProperty(initial) {
			
			private static final long serialVersionUID = -9009688943557006510L;
		};
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
	
	private static void waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer) throws InterruptedException {
		
		try {
			i.waitUntilTrue();
		}
		finally {
			i.unbind(observer);
		}
	}
	
	private static void waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(timeout, unit);
		}
		finally {
			i.unbind(observer);
		}
	}

	private static void waitUntil(
			AbstractPredicateCompution<String> i,
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		try {
			i.waitUntilTrue(p);
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
	
	public static AbstractStringCompution computeToUpperCase(StringObservable observer) {
		return buildMonoString(observer, v -> v.toUpperCase());
	}
	
	public static AbstractStringCompution computeToUpperCase(StringObservable observer, Locale locale) {
		return buildMonoString(observer, v -> v.toUpperCase(locale));
	}
	
	public static AbstractStringCompution computeToLowerCase(StringObservable observer) {
		return buildMonoString(observer, v -> v.toLowerCase());
	}
	
	public static AbstractStringCompution computeToLowerCase(StringObservable observer, Locale locale) {
		return buildMonoString(observer, v -> v.toLowerCase(locale));
	}
	
	public static AbstractStringCompution computeTrim(StringObservable observer) {
		return buildMonoString(observer, v -> v.trim());
	}
	
	public static AbstractStringCompution computeConcat(StringObservable observer, String str) {
		return buildMonoString(observer, v -> v.concat(str));
	}
	
	public static AbstractStringCompution computeReplace(StringObservable observer, char oldChar, char newChar) {
		return buildMonoString(observer, v -> v.replace(oldChar, newChar));
	}
	
	public static AbstractStringCompution computeReplace(StringObservable observer, CharSequence target, CharSequence replacement) {
		return buildMonoString(observer, v -> v.replace(target, replacement));
	}
	
	public static AbstractStringCompution computeReplaceAll(StringObservable observer, String regex, String replacement) {
		return buildMonoString(observer, v -> v.replaceAll(regex, replacement));
	}
	
	public static AbstractStringCompution computeReplaceFirst(StringObservable observer, String regex, String replacement) {
		return buildMonoString(observer, v -> v.replaceFirst(regex, replacement));
	}
	
	public static AbstractPredicateCompution<String> computeIsEmpty(StringObservable observer) {
		return buildIsEmpty(observer);
	}
	
	public static AbstractPredicateCompution<String> computeIsNotEmpty(StringObservable observer) {
		return buildIsNotEmpty(observer);
	}
	
	public static AbstractPredicateCompution<String> computeContains(StringObservable observer, CharSequence s) {
		return buildContains(observer, s);
	}
	
	public static AbstractPredicateCompution<String> computeNotContains(StringObservable observer, CharSequence s) {
		return buildNotContains(observer, s);
	}
	
	public static AbstractPredicateCompution<String> computeStartsWith(StringObservable observer, String prefix) {
		return buildStartsWith(observer, prefix);
	}
	
	public static AbstractPredicateCompution<String> computeStartsWith(StringObservable observer, String prefix, int toOffset) {
		return buildStartsWith(observer, prefix, toOffset);
	}
	
	public static AbstractPredicateCompution<String> computeEndsWith(StringObservable observer, String suffix) {
		return buildEndsWith(observer, suffix);
	}
	
	public static AbstractPredicateCompution<String> computeMatches(StringObservable observer, String regex) {
		return buildMatches(observer, regex);
	}
	
	public static AbstractPredicateCompution<String> computeContentEqualTo(StringObservable observer, CharSequence cs) {
		return buildContentEqualTo(observer, cs);
	}
	
	public static AbstractPredicateCompution<String> computeContentEqualTo(StringObservable observer, StringBuffer sb) {
		return buildContentEqualTo(observer, sb);
	}
	
	public static AbstractIntegerCompution computeLength(StringObservable observer) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.length()));
	}
	
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, String str) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(str)));
	}
	
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, int ch) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(ch)));
	}
	
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, String str, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(str, fromIndex)));
	}
	
	public static AbstractIntegerCompution computeIndexOf(StringObservable observer, int ch, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.indexOf(ch, fromIndex)));
	}
	
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, String str) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(str)));
	}
	
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, String str, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(str, fromIndex)));
	}
	
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, int ch) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(ch)));
	}
	
	public static AbstractIntegerCompution computeLastIndexOf(StringObservable observer, int ch, int fromIndex) {
		return buildMonoInteger(observer, v -> Integer.valueOf(v.lastIndexOf(ch, fromIndex)));
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsEqualTo(StringObservable a, StringObservable b) {
		return buildIsEqualTo(a, b);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsNotEqualTo(StringObservable a, StringObservable b) {
		return buildIsNotEqualTo(a, b);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsLessThan(StringObservable left, StringObservable right) {
		return buildIsLessThan(left, right);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsLessThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildIsLessThanOrEqualTo(left, right);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsGreaterThan(StringObservable left, StringObservable right) {
		return buildIsGreaterThan(left, right);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsGreaterThanOrEqualTo(StringObservable left, StringObservable right) {
		return buildIsGreaterThanOrEqualTo(left, right);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildIsEqualToIgnoreCase(a, b);
	}
	
	public static AbstractBiPredicateCompution<String, String> computeIsNotEqualToIgnoreCase(StringObservable a, StringObservable b) {
		return buildIsNotEqualToIgnoreCase(a, b);
	}
	
	public static AbstractStringCompution computeJoin(CharSequence delimiter, Iterable<StringObservable> observers) {
		return buildStringJoining(delimiter, observers);
	}
	
	public static void waitUntilIsEmpty(
			StringObservable observer) throws InterruptedException {
		
		waitUntil(buildIsEmpty(observer), observer);
	}
	
	public static void waitUntilIsEmpty(
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEmpty(observer), observer, timeout, unit);
	}
	
	public static void waitUntilIsEmpty(
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEmpty(observer), observer, p);
	}
	
	public static void waitUntilIsNotEmpty(
			StringObservable observer) throws InterruptedException {
		
		waitUntil(buildIsNotEmpty(observer), observer);
	}
	
	public static void waitUntilIsNotEmpty(
			StringObservable observer,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEmpty(observer), observer, timeout, unit);
	}
	
	public static void waitUntilIsNotEmpty(
			StringObservable observer,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEmpty(observer), observer, p);
	}
	
	public static void waitUntilContains(
			StringObservable observer,
			CharSequence s) throws InterruptedException {
		
		waitUntil(buildContains(observer, s), observer);
	}
	
	public static void waitUntilContains(
			StringObservable observer,
			CharSequence s,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContains(observer, s), observer, timeout, unit);
	}
	
	public static void waitUntilContains(
			StringObservable observer,
			CharSequence s,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContains(observer, s), observer, p);
	}
	
	public static void waitUntilNotContains(
			StringObservable observer,
			CharSequence s) throws InterruptedException {
		
		waitUntil(buildNotContains(observer, s), observer);
	}
	
	public static void waitUntilNotContains(
			StringObservable observer,
			CharSequence s,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildNotContains(observer, s), observer, timeout, unit);
	}
	
	public static void waitUntilNotContains(
			StringObservable observer,
			CharSequence s,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildNotContains(observer, s), observer, p);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix) throws InterruptedException {
		
		waitUntil(buildStartsWith(observer, prefix), observer);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildStartsWith(observer, prefix), observer, timeout, unit);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildStartsWith(observer, prefix), observer, p);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset) throws InterruptedException {
		
		waitUntil(buildStartsWith(observer, prefix, toOffset), observer);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildStartsWith(observer, prefix, toOffset), observer, timeout, unit);
	}
	
	public static void waitUntilStartsWith(
			StringObservable observer,
			String prefix,
			int toOffset,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildStartsWith(observer, prefix, toOffset), observer, p);
	}
	
	public static void waitUntilEndsWith(
			StringObservable observer,
			String suffix) throws InterruptedException {
		
		waitUntil(buildEndsWith(observer, suffix), observer);
	}
	
	public static void waitUntilEndsWith(
			StringObservable observer,
			String suffix,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildEndsWith(observer, suffix), observer, timeout, unit);
	}
	
	public static void waitUntilEndsWith(
			StringObservable observer,
			String suffix,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildEndsWith(observer, suffix), observer, p);
	}
	
	public static void waitUntilMatches(
			StringObservable observer,
			String regex) throws InterruptedException {
		
		waitUntil(buildMatches(observer, regex), observer);
	}
	
	public static void waitUntilMatches(
			StringObservable observer,
			String regex,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildMatches(observer, regex), observer, timeout, unit);
	}
	
	public static void waitUntilMatches(
			StringObservable observer,
			String regex,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildMatches(observer, regex), observer, p);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs) throws InterruptedException {
		
		waitUntil(buildContentEqualTo(observer, cs), observer);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContentEqualTo(observer, cs), observer, timeout, unit);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			CharSequence cs,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContentEqualTo(observer, cs), observer, p);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb) throws InterruptedException {
		
		waitUntil(buildContentEqualTo(observer, sb), observer);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContentEqualTo(observer, sb), observer, timeout, unit);
	}
	
	public static void waitUntilContentEqualTo(
			StringObservable observer, 
			StringBuffer sb,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildContentEqualTo(observer, sb), observer, p);
	}
	
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsEqualTo(a, b), a, b);
	}
	
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualTo(a, b), a, b, timeout, unit);
	}
	
	public static void waitUntilEqualTo(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualTo(a, b), a, b, p);
	}

	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b);
	}
	
	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b, timeout, unit);
	}
	
	public static void waitUntilNotEqualTo(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualTo(a, b), a, b, p);
	}
	
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsLessThan(left, right), left, right);
	}
	
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThan(left, right), left, right, timeout, unit);
	}
	
	public static void waitUntilLessThan(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThan(left, right), left, right, p);
	}
	
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right);
	}
	
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	public static void waitUntilLessThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsLessThanOrEqualTo(left, right), left, right, p);
	}
	
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right);
	}
	
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right, timeout, unit);
	}
	
	public static void waitUntilGreaterThan(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThan(left, right), left, right, p);
	}
	
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right) throws InterruptedException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right);
	}
	
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right, timeout, unit);
	}
	
	public static void waitUntilGreaterThanOrEqualTo(
			StringObservable left,
			StringObservable right,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsGreaterThanOrEqualTo(left, right), left, right, p);
	}
	
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b);
	}
	
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b, timeout, unit);
	}
	
	public static void waitUntilEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsEqualToIgnoreCase(a, b), a, b, p);
	}
	
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b) throws InterruptedException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b);
	}
	
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			long timeout,
			TimeUnit unit) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b, timeout, unit);
	}
	
	public static void waitUntilNotEqualToIgnoreCase(
			StringObservable a,
			StringObservable b,
			TimeoutGettable p) throws InterruptedException, TimeoutException {
		
		waitUntil(buildIsNotEqualToIgnoreCase(a, b), a, b, p);
	}
	
}
