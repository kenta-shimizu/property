# property

building ...

This library is similar to JavaFX "javafx.beans.property".  
Java8 or later.

## Build new instance.

```java
/* Object */
ObjectProperty<T> objProp = ObjectProperty.newInstance(null);

/* Primitive */
IntegerProperty intProp = IntegerProperty.newInstsance(0);
LongProperty longProp = LongProperty.newInstance(0L);
FloatProperty floatProp = FloatProperty.newInstance(0.0F);
DoubleProperty doubleProp = DoubleProperty.newInstance(0.0D);
BooleanProperty boolProp = BooleanProperty.newInstance(false);

/* Collection */
ListProperty<E> listProp = ListProperty.newInstance();
SetProperty<E> setProp = SetProperty.newInstance();
MapProperty<K, V> mapProp = MapProperty.newInstance();
```

## Set value

```java
/* Object */
objProp.set(T value);
objProp.set(null);

/* Primitive */
intProp.set(10);
longProp.set(20L);
floatProp.set(30.0F);
doubleProp.set(40.0D);
boolProp.set(true);

/* Collection */
/* ListProperty<E> implements 'java.util.List<E>' */
listProp.add(e);

/* SetProperty<E> implements 'java.util.Set<E>' */
setProp.add(e);

/* MapProperty<K, V> implements 'java.util.Map<K, V>' */
mapProp.put(key, value);
```

## Get value

```java
/* Object */
T v = objProp.get();

/* Primitive */
int i = intProp.intValue();
long l = longProp.longValue();
float f = floatProp.floatValue();
double d = doubleProp.doubleValue();
boolean b = boolProp.booleanValue();

/* Collection */
/* ListProperty implements 'java.util.List' */
E v = listProp.get(0);

/* SetProperty<E> implements 'java.util.Set<E>' */
int size = setProp.size();

/* MapProperty<K, V> implements 'java.util.Map<K, V>' */
V v = mapProp.get(key);
```

## Observer

```java
/* Add ChangeListener */

//building...

```

## Compution

### Number Compution

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

```java
//building...

```

### Logical Compution

```java
/* build instance */
BooleanProperty a = BooleanProperty.newInstance(false);
BooleanProperty b = BooleanProperty.newInstance(true);

LogicalCompution and = a.and(b); /* a && b  */
Sysmtem.out.println(and);        /* "false" */

LogicalCompution or = a.or(b);   /* a || b  */
Sysmtem.out.println(or);         /* "true"  */

LogicalCompution not = a.not()   /* ! a     */
Sysmtem.out.println(not);        /* "true"  */

LogicalCompution xor = a.xor(b); /* a ^ b   */
Sysmtem.out.println(xor);        /* "true"  */

a.set(true); /* a change to true */

/* NumberCompution change automatically */
Sysmtem.out.println(and);        /* "true"  */
Sysmtem.out.println(or);         /* "true"  */
Sysmtem.out.println(not);        /* "false" */
Sysmtem.out.println(xor);        /* "false" */
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
