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
  





	
