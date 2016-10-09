# General Knowhow
## FunctionalInterface
 * FunctionalInterface = SAM (Single Abstract Method)
 * Methods in Interfaces are abstract by default (see Java language specification)
 * Methods inherited from Object do not count towards singularity (e.g. toString(), equals(), hashCode())
 * java.util.function.* provides a lot of useful FunctionalInterfaces
 * java.lang.Runnable is also a FunctionalInterface
 * It is not necessary to declare a SAM with @FunctionalInterface, though helpful - as the Java compiler checks against validity

## Lambdas
 * lambdas are basically anonymous methods
 * () -> {command; command;}
 * with only one command, {} and ; can be ommited
 * lambdas can be assigned to variables
 * lambdas are of type FunctionalInterface
 * Method references can be used instead of lambdas
 * anonymous classes (producing boilerplate code) can be used instead of lambdas
 * such methods may access only effectively final variables from class
 * effectively final: final must not be declared, but variable may not be changed (checked by compiler, available since Java 8) 

## Method references
 * Static method:           String::valueOf instead of x -> String.valueOf(x)
 * Instance of an Object:   this::method    instead of x -> this.method(x)
                            var::method     instead of x -> var.method(x)
 * Instance of a type:      MyClass::method instead of x -> MyClass.method(x)
 * Constructor:             Object::new     instead of () -> new Object()
