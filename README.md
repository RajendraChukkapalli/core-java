### Java7 Features:


#### Try-with-resources statement

Wrap the resource in try block. Any object that implements `java.lang.AutoCloseable`, which includes all objects which implement `java.io.Closeable`, can be used as a resource. 

```java
	static String readFirstLineFromFile(String path) throws IOException {
	try (BufferedReader br =
		       new BufferedReader(new FileReader(path))) {
	    return br.readLine();
	    }
	}
```

#### Suppressed Exceptions

An exception can be thrown from the block of code associated with the try-with-resources statement.

#### Underscores in numeric literals

int one_million = 1_000_000; This is added for better readability

#### Binary literals 

int binary = 0b1001_1001;  => 0B/0b can be used

#### Multiple exception catching

```java
} catch (FirstException ex) {
     logger.error(ex);
     throw ex;
} catch (SecondException ex) {
     logger.error(ex);
     throw ex;
}

to 

} catch (FirstException | SecondException ex) {
 logger.error(ex);
throw ex;
}
```

#### Strings in switch Statement

Now you can user strings in `switch` statements

#### Type Inference for Generic Instance (Diamond operator support)

We can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.

#### java.nio.file package

The java.nio.file package and its related package, java.nio.file.attribute, provide comprehensive support for file I/O and for accessing the file system. A zip file system provider is also available in JDK 7.

### Java8 Features:

#### Lambda Expressions

#### Pipelines and Streams

#### Date and Time API
#### Default Methods
#### Type Annotations
#### Nashorn JavaScript Engine
#### Concurrent Accumulators
#### Parallel operations

#### PermGen Space Removed - Replaced with Metaspace

```bash
`Prior to Java8, PermGen space is part of Heap. Now it is part of Native Memory`. 
PermGen (Permanent Generation) is a special heap space separated from the main memory heap.

The JVM keeps track of loaded class metadata in the PermGen. Additionally, the JVM stores all the static content in this memory section. This includes all the static methods, primitive variables, and references to the static objects.

Furthermore, it contains data about bytecode, names and JIT information. Before Java 7, the String Pool was also part of this memory. The disadvantages of the fixed pool size are listed in our write-up.

The default maximum memory size for 32-bit JVM is 64 MB and 82 MB for the 64-bit version.

However, we can change the default size with the JVM options:

`-XX:PermSize=[size]` is the initial or minimum size of the PermGen space
`-XX:MaxPermSize=[size]` is the maximum size
Most importantly, Oracle completely removed this memory space in JDK 8 release.

With its limited memory size, PermGen is involved in generating the famous OutOfMemoryError.

Metaspace:

Simply put, Metaspace is a new memory space – starting from the Java 8 version; it has replaced the older PermGen memory space.
The most significant difference is how it handles the memory allocation.

As a result, this native memory region grows automatically by default. Here we also have new flags to tune-up the memory:
```
#### TLS SNI

#### forEach() method in `Iterable` interface
Java 8 has introduced forEach method in java.lang.Iterable and it is the super class of `java.util.Collection` and it is available for all the List and Set classes. Though `map` interface is part of the collections package, it does not extend `java.util.Collection`. 

### Java9 Features:

#### The Java Platform module system

```java
As codebases grow larger, the odds of creating complicated, tangled “spaghetti code” increase exponentially 
and it has 2 fundamental problems. 
1. It is hard to truly encapsulates the code 
2. no notion of defining the explicit dependncies between JAR files of system. 

A public class can be accessed by any other public class in the classpath. 

When starting a modular application, the JVM verifies whether all modules can be resolved based on the `requires` statements—a big step. Modules allow you to better structure your application with strong enforcement of encapsulation and explicit dependencies. Also resolves the classpath issues. 
```

```java 
#### Module1 

module-info.java 
module my-module1 {
  exports com.examples.my-module1;
  requires my-module2;
}

#### Module2 

module-info.java 
module my-module2 {
  exports com.examples.my-module2;
}
```
Java platform has been modularized with Java9.

#### Linking 

Instead of shipping your app with a fully loaded JDK installation, you can create a minimal runtime image 
optimized for your application by taking the advantage of Java9 modular system. You can leverage the `jlink` tool 
introduced as part of Java9.

#### JShell: the interactive Java REPL

Interactive Read-Eval-Print-Loop, which helps explore language API and features using jshell. 

#### Collection factory methods

With Java 9, several so-called collection factory methods have been added:
Set<Integer> ints = Set.of(1, 2, 3);
List<String> strings = List.of("first", "second");

#### Private interface methods

Java8 has `default` methods which means interfaces can define behavior instead of method signatures. Generally we keep a `private` function for shared behavior. Can we do the same in interface? What if multiple default methods, can we the  same piece of code? 

Yes in Java9. 

You can define a `private` shared method.

#### HTTP/2 support.

`HttpURLConnection` has been enhanced to support `websockets` and HTTP2. But this is added a `_incubator module_`, 
which means it can be removed. Lets not start incorporating this feature yet.

```java
HttpClient client = HttpClient.newHttpClient();

HttpRequest req =
   HttpRequest.newBuilder(URI.create("http://www.google.com"))
              .header("User-Agent","Java")
              .GET()
              .build();


HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());
```

#### Multi-Release JARS support has been added

This is good for `third-party` library providers and users.  Multi-release JAR feature allows you to create alternate versions of classes that are only used  when running the library on a specific Java version. As you can see in the following code snippet, A.class has been defined in different hierarchies. If you start using Java9, A.class under versions/9/myltirelease/ will be used.

```java
multirelease.jar
├── META-INF
│   └── versions
│       └── 9
│           └── multirelease
│               └── A.class
├── multirelease
    ├── A.class
    └── Main.class
```
