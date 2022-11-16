# property

building ...

This library is similar to JavaFX "javafx.beans.property".  
Java8 or later.

## Build new instance.

```java
/* Object */
ObjectProperty<String> objProp = ObjectProperty.newInstance(null);

/* Primitive */
IntegerProperty intProp = IntegerProperty.newInstsance(0);
LongProperty longProp = LongProperty.newInstance(0L);
FloatProperty floatProp = FloatProperty.newInstance(0.0F);
DoubleProperty doubleProp = DoubleProperty.newInstance(0.0D);
BooleanProperty boolProp = BooleanProperty.newInstance(false);

/* Collection */
ListProperty<String> listProp = ListProperty.newInstance();
SetProperty<Integer> setProp = SetProperty.newInstance();
MapProperty<String, Integer> mapProp = MapProperty.newInstance();
```

## Set value

```java
/* Object */
objProp.set("STRING");
objProp.set(null);

/* Primitive */
intProp.set(10);
longProp.set(20L);
floatProp.set(30.0F);
doubleProp.set(40.0D);
boolProp.set(true);

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
/* Object */
String v = objProp.get();

/* Primitive */
int i = intProp.intValue();
long l = longProp.longValue();
float f = floatProp.floatValue();
double d = doubleProp.doubleValue();
boolean b = boolProp.booleanValue();

/* Collection */
/* ListProperty<E> implements 'java.util.List<E>' */
String v = listProp.get(0);

/* SetProperty<E> implements 'java.util.Set<E>' */
int size = setProp.size();

/* MapProperty<K, V> implements 'java.util.Map<K, V>' */
Integer i = mapProp.get("STRING");
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

### Comparative Compution

`NumberProperty` can compute `#isEqualTo(==)`, `#isNotEqualTo(!=)`, `#isLessThan(<)`, `#isLessThanOrEqualTo(<=)`, `isGreaterThan(>)`, `isGreaterThanOrEqualTo(>=)`.  
`NumberCompution` can also compute.

```java
/* build instance */
IntegerProperty a = IntegerProperty.newInstance(3);
IntegerProperty b = IntegerProperty.newInstance(4);

BooleanCompution aGT3 = a.isGreaterThan(3);
System.out.println(aGT3.booleanValue());  /* a >  3, "false" */

BooleanCompution aEQ5 = a.isEqualTo(5);
System.out.println(aEQ5.booleanValue());  /* a == 5, "false" */

BooleanCompution aLTb = a.isLessThan(b);
System.out.println(aLTb.booleanValue());  /* a <  b, "true"  */

a.set(5);  /* a change to 5 */

/* ComparaiveCompution change automatically */
System.out.println(aGT3.booleanValue());  /* a >  3, "true"  */
System.out.println(aEQ5.booleanValue());  /* a == 5, "true"  */
System.out.println(aLTb.booleanValue());  /* a <  b, "false" */
```

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

## Observer

All `Property` and `Compution` can observe by `#addChangeListener`.

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

a.set(4);
b.set(5);
c.set(6);

/*  "6", (1+2+3), first     */
/*  "9", (4+2+3), a changed */
/* "12", (4+5+3), b changed */
/* "15", (4+5+6), c changed */
```

## Wait Until Methods

```java
//building...

```

## TimeProperty

```java
/* java.time */
TimeProperty timeProp = TimeProperty.newInstance(10.0F); /* set 10.0 seconds */
TimeProperty timeProp = TimeProperty.newInstance(10L, TimeUnit.SECONDS); /* set 10 seconds */

/* Setter */
timeProp.set(5.0F); /* set 5.0 seconds */

/* Utilities */
timeProp.sleep(); /* TimeUnit#sleep(timeout) */

/* to #waitUntil methods */

//building...
```
