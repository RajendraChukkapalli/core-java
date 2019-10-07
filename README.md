Java7 Features:
===============

1. Try-with-resources statement

Wrap the resource in try block. Any object that implements "java.lang.AutoCloseable", which includes all objects which implement java.io.Closeable, can be used as a resource. 

static String readFirstLineFromFile(String path) throws IOException {
try (BufferedReader br =
               new BufferedReader(new FileReader(path))) {
    return br.readLine();
}
}

2. Suppressed Exceptions

An exception can be thrown from the block of code associated with the try-with-resources statement.

3. Underscores in numeric literals

int one_million = 1_000_000; This is added for better readability

4. Binary literals 

int binary = 0b1001_1001;  => 0B/0b can be used

5. Multiple exception catching

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

6. Strings in switch Statement

Now you can user strings in switch statements

7. Type Inference for Generic Instance (Diamond operator support)

We can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.

8. java.nio.file package

The java.nio.file package and its related package, java.nio.file.attribute, provide comprehensive support for file I/O and for accessing the file system. A zip file system provider is also available in JDK 7.

Java8 Features:
===============

1.Lambda Expressions

2.Pipelines and Streams

3.Date and Time API
4.Default Methods
5.Type Annotations
6.Nashorn JavaScript Engine
7.Concurrent Accumulators
8.Parallel operations

9.PermGen Space Removed - Replaced with Metaspace

Prior to Java8, PermGen space is part of Heap. Now it is part of Native Memory. 
PermGen (Permanent Generation) is a special heap space separated from the main memory heap.

The JVM keeps track of loaded class metadata in the PermGen. Additionally, the JVM stores all the static content in this memory section. This includes all the static methods, primitive variables, and references to the static objects.

Furthermore, it contains data about bytecode, names and JIT information. Before Java 7, the String Pool was also part of this memory. The disadvantages of the fixed pool size are listed in our write-up.

The default maximum memory size for 32-bit JVM is 64 MB and 82 MB for the 64-bit version.

However, we can change the default size with the JVM options:

-XX:PermSize=[size] is the initial or minimum size of the PermGen space
-XX:MaxPermSize=[size] is the maximum size
Most importantly, Oracle completely removed this memory space in JDK 8 release.

With its limited memory size, PermGen is involved in generating the famous OutOfMemoryError.

Metaspace:

Simply put, Metaspace is a new memory space – starting from the Java 8 version; it has replaced the older PermGen memory space. The most significant difference is how it handles the memory allocation.

As a result, this native memory region grows automatically by default. Here we also have new flags to tune-up the memory:



10.TLS SNI
11. forEach() method in Iterable interface
Java 8 has introduced forEach method in java.lang.Iterable and it is the super class of "java.util.Collection" and it is available for all the List and Set classes



  





	
