# EX Benchmark

Benchmark using exception as a control flow in an ActFramework emulating environment

This benchmark is implemented on [JMH](http://openjdk.java.net/projects/code-tools/jmh/)

## How to run it

```
mvn package
cd target
java -jar benchmarks.jar
```

## The result

```
Benchmark                     Mode  Cnt          Score         Error  Units
MyBenchmark.testMethod       thrpt   10   83672353.298 ± 1147353.403  ops/s
MyBenchmark.testMethodThree  thrpt   10   79100995.038 ±  927628.719  ops/s
MyBenchmark.testMethodTwo    thrpt   10  124141072.380 ± 1075516.028  ops/s
```

## A bit explaination

* testMethod: throw an new `NotFound` instance constructed with the message
* testMethodTwo: throw a static `NotFound.INSTANCE` instance and use ThreadLocal to store the message
* testMethodThree: Return an new `NotFound` instance constructed with the message

## Conclusion

* It is safe (maybe encouraged) to throw static exception in an ActFramework application.
* **caution** do not throw any exception if your controller handler method is `static`, in which case ActFramework 
  will use Java reflection to call it. And anything throw out will be wrapped with `InvocationTargetException` which
  ruin the performance for no doubt
