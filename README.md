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
MapProperty mapProp = MapProperty.newInstance();
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

```

## Get value

```java

```

## Observer

## Compution

### Number Compution

```java
NumberCompution addComp = intProp.add(2);
```

### Relative Compution

### Logical Compution


## Wait Until Methods

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
```
