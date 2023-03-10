# property

This library is similar to JavaFX "javafx.beans.property".  
Includes Setter/Getter/Observer, Number/Comparative/Logical compution and blocking methods to wait until condition is true.  
Requires Java8 or later.

## Build new instance.

```java
/* Primitive */
IntegerProperty intProp    = IntegerProperty.newInstsance(0);
LongProperty    longProp   = LongProperty.newInstance(0L);
FloatProperty   floatProp  = FloatProperty.newInstance(0.0F);
DoubleProperty  doubleProp = DoubleProperty.newInstance(0.0D);
BooleanProperty boolProp   = BooleanProperty.newInstance(false);

/* Object */
ObjectProperty<String> objProp = ObjectProperty.newInstance(null);

/* String */
StringProperty strProp = StringProperty.newInstance("string");

/* Collection */
ListProperty<String> listProp = ListProperty.newInstance();
SetProperty<Integer> setProp  = SetProperty.newInstance();
MapProperty<String, Integer> mapProp = MapProperty.newInstance();
```

See also  
["/examples/example/IntegerPropertyExample.java"](/examples/example/IntegerPropertyExample.java)  
["/examples/example/BooleanPropertyExample.java"](/examples/example/BooleanPropertyExample.java)  
["/examples/example/ObjectPropertyExample.java"](/examples/example/ObjectPropertyExample.java)  
["/examples/example/StringPropertyExample.java"](/examples/example/StringPropertyExample.java)  
["/examples/example/ListPropertyExample.java"](/examples/example/ListPropertyExample.java)  
["/examples/example/SetPropertyExample.java"](/examples/example/SetPropertyExample.java)  
["/examples/example/MapPropertyExample.java"](/examples/example/MapPropertyExample.java)  

## Set value

```java
/* Primitive */
intProp.set(10);
longProp.set(20L);
floatProp.set(30.0F);
doubleProp.set(40.0D);
boolProp.set(true);

/* Object */
objProp.set("STRING");
objProp.set(null);

/* String */
strProp.set("STRING");

/* Collection */
/* ListProperty<E> implements 'java.util.List<E>' */
listProp.add("STRING");

/* SetProperty<E> implements 'java.util.Set<E>' */
setProp.add(Integer.valurOf(1));

/* MapProperty<K, V> implements 'java.util.Map<K, V>' */
mapProp.put("KEY", Integer.valurOf(1));
```

## Get value

```java
/* Primitive */
int i     = intProp.intValue();
long l    = longProp.longValue();
float f   = floatProp.floatValue();
double d  = doubleProp.doubleValue();
boolean b = boolProp.booleanValue();

/* Object */
String o = objProp.get();

/* String */
String s = strProp.toString();

/* Collection */
/* ListProperty<E> implements 'java.util.List<E>' */
String e = listProp.get(0);

/* SetProperty<E> implements 'java.util.Set<E>' */
int size = setProp.size();

/* MapProperty<K, V> implements 'java.util.Map<K, V>' */
Integer v = mapProp.get("STRING");
```

## Compution

### Number Compution

`NumberProperty` can compute `#add(+)`, `#negate(-)`, `#subtract(-)`, `#multiply(*)`, `#sum`, `#max`, `#min`.  
`NumberCompution` can also compute.

```java
/* build instance */
IntegerProperty a = IntegerProperty.newInstance(1);
IntegerProperty b = IntegerProperty.newInstance(2);
IntegerProperty c = IntegerProperty.newInstance(3);

NumberCompution addA2 = a.add(2);       /* a + 2 */
System.out.println(addA2.intValue());   /* "3"   */

NumberCompution addBC = b.add(c);       /* b + c */
System.out.println(addBC.intValue());   /* "5"   */

NumberCompution mulBC = b.multiply(c);  /* b * c */
System.out.println(mulBC.intValue());   /* "6"   */

NumberCompution negateA = a.negate();   /* -a    */
System.out.println(negateA);            /* "-1"  */

NumberCompution sumABC = NumberCompution.sum(a, b, c);
System.out.println(sumABC.intValue());  /* "6" */

NumberCompution maxABC = NumberCompution.max(a, b, c);
System.out.println(maxABC.intValue());  /* "3" */

NumberCompution minABC = NumberCompution.min(a, b, c);
System.out.println(minABC.intValue());  /* "1" */

a.set(4);   /* a change to 4 */

/* NumberCompution change automatically */
System.out.println(sumABC.intValue());  /* "9" */
System.out.println(maxABC.intValue());  /* "4" */
System.out.println(minABC.intValue());  /* "2" */
```

See also ["/examples/example/NumberComputionExample.java"](/examples/example/NumberComputionExample.java)

### Comparative Compution

`NumberProperty` can compute `#computeIsEqualTo(==)`, `#computeIsNotEqualTo(!=)`, `#computeIsLessThan(<)`, `#computeIsLessThanOrEqualTo(<=)`, `#computeIsGreaterThan(>)`, `#computeIsGreaterThanOrEqualTo(>=)`.  
`NumberCompution` can also compute.

```java
/* build instance */
IntegerProperty a = IntegerProperty.newInstance(3);
IntegerProperty b = IntegerProperty.newInstance(4);

BooleanCompution aGT3 = a.computeIsGreaterThan(3);
System.out.println(aGT3.booleanValue());  /* a >  3, "false" */

BooleanCompution aEQ5 = a.computeIsEqualTo(5);
System.out.println(aEQ5.booleanValue());  /* a == 5, "false" */

BooleanCompution aLTb = a.computeIsLessThan(b);
System.out.println(aLTb.booleanValue());  /* a <  b, "true"  */

a.set(5);  /* a change to 5 */

/* ComparaiveCompution change automatically */
System.out.println(aGT3.booleanValue());  /* a >  3, "true"  */
System.out.println(aEQ5.booleanValue());  /* a == 5, "true"  */
System.out.println(aLTb.booleanValue());  /* a <  b, "false" */
```

See also ["/examples/example/ComparativeComputionExample.java"](/examples/example/ComparativeComputionExample.java)

### Logical Compution

`BooleanProperty` can compute `#and(&&)`, `#or(||)`, `#not(!)`, `#xor(^)`, `#nand`, `#nor`.  
`BooleanCompution` can also compute.

```java
/* build instance */
BooleanProperty a = BooleanProperty.newInstance(false);
BooleanProperty b = BooleanProperty.newInstance(true);

BooleanCompution and = a.and(b);         /* a && b  */
System.out.println(and.booleanValue());  /* "false" */

BooleanCompution or = a.or(b);           /* a || b  */
System.out.println(or.booleanValue());   /* "true"  */

BooleanCompution not = a.not();          /* ! a     */
System.out.println(not.booleanValue());  /* "true"  */

BooleanCompution xor = a.xor(b);         /* a ^ b   */
System.out.println(xor.booleanValue());  /* "true"  */

a.set(true);  /* a change to true */

/* LogicalCompution change automatically */
System.out.println(and.booleanValue());  /* "true"  */
System.out.println(or.booleanValue());   /* "true"  */
System.out.println(not.booleanValue());  /* "false" */
System.out.println(xor.booleanValue());  /* "false" */
```

See also ["/examples/example/LogicalComputionExample.java"](/examples/example/LogicalComputionExample.java)

### Others

```java
/* Object */
ObjectProperty<String> objProp = ObjectProperty.newInstance("STRING");

BooleanCompution isNullCompution  = objProp.computeIsNull();
BooleanCompution notNullCompution = objProp.computeIsNotNull();
BooleanCompution equalCompution   = objProp.computeIsEqualTo("STRING");

/* String */
StringProperty a = StringProperty.newInstance("A");
StringProperty b = StringProperty.newInstance("B");
StringProperty c = StringProperty.newInstance("C");

StringCompution joinCompution = StringCompution.join(",", a, b, c);

StringCompution trimCompution        = a.computeTrim();
StringCompution toLowerCaseCompution = a.computeToLowerCase();
StringCompution toUpperCaseCompution = a.computeToUpperCase();
BooleanCompution isEmptyCompution    = a.computeIsEmpty();
BooleanCompution containsCompution   = a.computeContains("A");
IntegerCompution lengthCompution     = a.computeLength();

/* List */
ListProperty<String> listProp = ListProperty.newInstance();

BooleanCompution isEmptyCompution  = listProp.computeIsEmpty();
BooleanCompution containsCompution = listProp.computeContains("CONTAINS");
IntegerCompution sizeCompution     = listProp.computeSize();

/* Set */
SetProperty<String> setProp = SetProperty.newInstance();

BooleanCompution isEmptyCompution  = setProp.computeIsEmpty();
BooleanCompution containsCompution = setProp.computeContains("CONTAINS");
IntegerCompution sizeCompution     = setProp.computeSize();

/* Map */
MapProperty<String, Integer> mapProp = MapProperty.newInstance();

BooleanCompution isEmptyCompution     = mapProp.computeIsEmpty();
BooleanCompution containsKeyCompution = mapProp.computeContainsKey("KEY");
IntegerCompution sizeCompution        = mapProp.computeSize();
SetCompution<String> keySetCompution  = mapProp.computeKeySet();
```

## Observer

All `Property` and `Compution` can observe changed value by `#addChangeListener`.

```java
/* build instance */
IntegerProperty a = IntegerProperty.newInstance(1);
IntegerProperty b = IntegerProperty.newInstance(2);
IntegerProperty c = IntegerProperty.newInstance(3);

NumberCompution sum = NumberCompution.sum(a, b, c);

/* Add ChangeListener */
sum.addChangeListener(n -> {
	System.out.println(n.intValue());
});

           /*  "6", (1+2+3), initial   */
a.set(4);  /*  "9", (4+2+3), a changed */
b.set(5);  /* "12", (4+5+3), b changed */
c.set(6);  /* "15", (4+5+6), c changed */
```

See also ["/examples/example/NumberComputionExample.java"](/examples/example/NumberComputionExample.java)

## Wait Until Methods

Waiting until condition is true. (blocking methods)  
If set timeout and over, throw `java.util.concurrent.TimeoutException`.

```java
/* build instance */
final BooleanProperty boolProp = BooleanProperty.newInstance(false);
final IntegerProperty intProp = IntegerProperty.newInstance(0);
final ObjectProperty<String> objProp = ObjectProperty.newInstance(null);
final MapProperty<String, String> mapProp = MapProperty.newInstance();

new Thread(() -> {
	try {
		Thread.sleep(1000L);
		boolProp.set(true);
		
		Thread.sleep(1000L);
		intProp.set(10);
		
		Thread.sleep(1000L);
		objProp.set("STRING");
		
		Thread.sleep(1000L);
		mapProp.put("KEY", "VALUE");
	}
	catch ( InterruptedException ignore ) {
	}
}).start();

System.out.println("Waiting until boolProp is true.");
boolProp.waitUntilTrue();
System.out.println("boolProp is true.");

System.out.println("Waiting until intProp is >0.");
intProp.waitUntilGreaterThan(0);
System.out.println("inrProp is >0.");

System.out.println("Waiting until objProp is not null.");
String objv = objProp.waitUntilNotNullAndGet();
System.out.println("objProp is " + objv);

System.out.println("Waiting until mapProp containsKey(\"KEY\").");
String mapv = mapProp.waitUntilContainsKeyAndGet("KEY");
System.out.println("mapProp get(\"KEY\") is " + mapv);
```

- Integer/Long/Float/Double/Number Property/Compution
  + `#waitUntilEqualTo` (==)
  + `#waitUntilNotEqualTo` (!=)
  + `#waitUntilLessThan` (<)
  + `#waitUntilLessThanOrEqualTo` (<=)
  + `#waitUntilGreaterThan` (>)
  + `#waitUntilGreaterThanOrEqualTo` (>=)
  + `#waitUntilEqualToZero` (==0)
  + `#waitUntilNotEqualToZero` (!=0)
  + `#waitUntilLessThanZero` (<0)
  + `#waitUntilLessThanOrEqualToZero` (<=0)
  + `#waitUntilGreaterThanZero` (>0)
  + `#waitUntilGreaterThanOrEqualToZero` (>=0)
- Boolean Property/Compution
  + `#waitUntil`
  + `#waitUntilTrue`
  + `#waitUntilFalse`
- Object Property/Compution
  + `#waitUntilEqualTo`
  + `#waitUntilNotEqualTo`
  + `#waitUntilNull`
  + `#waitUntilNotNullAndGet`
- String Property/Compution
  + `#waitUntilIsEmpty`
  + `#waitUntilIsNotEmptyAndGet`
  + `#waitUntilContainsAndGet`
  + `#waitUntilNotContainsAndGet`
  + `#waitUntilStartsWithAndGet`
  + `#waitUntilEndsWithAndGet`
  + `#waitUntilMatchesAndGet`
  + `#waitUntilContentEqualToAndGet`
  + `#waitUntilNotContentEqualToAndGet`
  + `#waitUntilEqualTo`
  + `#waitUntilNotEqualTo`
  + `#waitUntilLessThan` (compareTo <0)
  + `#waitUntilLessThanOrEqualTo` (compareTo <=0)
  + `#waitUntilGreaterThan` (compareTo >0)
  + `#waitUntilGreaterThanOrEqualTo` (compareTo >=0)
  + `#waitUntilEqualToIgnoreCase`
  + `#waitUntilNotEqualToIgnoreCase`
- List/Set Property/Compution
  + `#waitUntilIsEmpty`
  + `#waitUntilIsNotEmpty`
  + `#waitUntilContains`
  + `#waitUntilNotContains`
  + `#waitUntilContainsAll`
  + `#waitUntilNotContainsAll`
- Map Property/Compution
  + `#waitUntilIsEmpty`
  + `#waitUntilIsNotEmpty`
  + `#waitUntilContainsKeyAndGet`
  + `#waitUntilNotContainsKey`

## TimeoutProperty

`TimeoutProperty` is utility class instance.  
Includes `timeout(long)` and `java.util.concurrent.TimeUnit`.  
Can set to `waitUntil` methods as timeout.

```java
/* build instance */
TimeoutProperty timeProp = TimeoutProperty.newInstance(10L, TimeUnit.SECONDS);  /* set 10 seconds */
TimeoutProperty timeProp = TimeoutProperty.newInstance(10.0F);  /* set 10.0 seconds */

/* Setter */
timeProp.set(5.0F);  /* set 5.0 seconds */

/* Utilities */
timeProp.sleep();  /* TimeUnit#sleep(timeout); */
timeProp.wait(syncObj);  /* TimeUnit#timedWait(syncObj, timeout); */
T v = timeProp.futureGet(future);  /* Future<T>#get(timeout, TimeUnit); */
T v = timeProp.blockingQueuePoll(blockingQueue);  /* BlokingQueue<T>#poll(timeout, TimeUnit); */

/* set to #waitUntil methods as timeout */
boolProp.waitUntilTrue(timeProp);
```

See also ["/examples/example/TimeoutPropertyExample.java"](/examples/example/TimeoutPropertyExample.java)
