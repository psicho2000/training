# General Knowhow
## FunctionalInterface
 * FunctionalInterface = SAM (Single Abstract Method)
 * Methods in Interfaces are abstract by default (see Java language specification)
 * Methods inherited from Object do not count towards singularity (e.g. `toString()`, `equals()`, `hashCode()`)
 * `java.util.function.*` provides a lot of useful FunctionalInterfaces
 * `java.lang.Runnable` is also a FunctionalInterface
 * It is not necessary to declare a SAM with `@FunctionalInterface`, though helpful - as the Java compiler checks against validity

## Lambdas
 * A.k.a Closures.
 * Lambdas are basically anonymous methods.
 * `() -> {command; command;}`
 * With only one command, `{}` and `;` can be omitted.
 * Lambdas can be assigned to variables.
 * Lambdas are of type FunctionalInterface.
 * Method references can be used instead of lambdas.
 * Anonymous classes (producing boilerplate code) can be used instead of lambdas.
 * Such methods may access only effectively final variables from class.
 * Effectively final: final must not be declared, but variable may not be changed (checked by compiler, available since Java 8).

## Method references
 * Static method:           `String::valueOf` instead of `x -> String.valueOf(x)`
 * Instance of an Object:   `this::method`    instead of `x -> this.method(x)`
                            `var::method`     instead of `x -> var.method(x)`
 * Instance of a type:      `MyClass::method` instead of `x -> MyClass.method(x)`
 * Constructor:             `Object::new`     instead of `() -> new Object()`

## Streams
 * Streams realize internal iterations: the iteration is not seen explicitly in the code. Before Java 8, one had to use external iterations (i.e. `for (Object item : items)`)
 * Filter-Map-Reduce is subset of the Java stream API.
 * To work on a stream, one needs exactly one create operation, then any number of intermediate operations, and then exactly one terminal operation.
 * Infinite streams represent mathematical sequences and can be realized with `IntStream.iterate(...)` or `Stream.generate(...)`.
 * Stateful intermediate operations need the knowledge about other objects of the stream. Stateless intermediation operations operate on exactly the current element and don't need to know anything else.
 * Statelessness is an important prerequisite for parallelization, although there are some stateful operations which can be parallelized, e.g. `sorted()`.
 * Statelessness is the core of functional programming.
 * Paging can be realized with `limit()` and `skip()`.
 * Processing is done in the terminal step only - not when an intermediate operation is called. Therefore, to view the content of a the current streamed entity, one needs to use `peek()`.
 * Short circuiting operations don't need to iterate over the whole stream.

### Create operations
 * `stream()`
 * `parallelStream()`
 * `chars()`
 * `Arrays.stream(...)`
 * `Arrays.stream(...).parallel()`
 * `Stream.of(...)`
 * `Stream.generate(...)`
 * `IntStream.range(...)`
 * `IntStream.iterate(...)`
 * `StreamSupport.stream(iter.spliterator(), false)` where the last argument would be true for a parallel stream

### Intermediate operations (stateless)
 * `filter()`
 * `map()`
 * `flatMap()`
 * `peek()`

### Intermediate operations (stateful)
 * `distinct()`
 * `sorted()`
 * `limit()` _short circuit_
 * `skip()`

### Terminal operations
 * `forEach()`
 * `toArray()`
 * `collect()`
 * `reduce()`
 * `min()`
 * `max()`
 * `count()`
 * `sum()`
 * `average()`
 * `anyMatch()` _short circuit_
 * `allMatch()` _short circuit_
 * `noneMatch()` _short circuit_
 * `findFirst()` _short circuit_
 * `findAny()` _short circuit_
 
As argument of `collect()`:
 * `joining()`
 * `groupingBy()`
 * `partitioningBy()`
 * `counting()`
