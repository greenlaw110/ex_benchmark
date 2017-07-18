# EX Benchmark

Benchmark using exception as a control flow in an [ActFramework](https://github.com/actframework/actframework) emulating environment

This benchmark is implemented on [JMH](http://openjdk.java.net/projects/code-tools/jmh/)

## How to run it

```
mvn package
cd target
java -jar benchmarks.jar
```

## The result

```
Benchmark                        Mode  Cnt          Score         Error  Units
MyBenchmark.returnResult        thrpt   10   81916164.629 ± 1808986.677  ops/s
MyBenchmark.returnStaticResult  thrpt   10  114661426.440 ±  462720.877  ops/s
MyBenchmark.throwResult         thrpt   10   86975587.406 ± 2002692.180  ops/s
MyBenchmark.throwStaticResult   thrpt   10  123113490.910 ±  812310.418  ops/s
```

## A bit explaination

* returnResult: Return an new `NotFound` instance constructed with the message
* returnStaticResult: Return a static `NotFound.INSTANCE` instance and use ThreadLocal to store the message
* throwResult: throw an new `NotFound` instance constructed with the message
* throwStaticResult: throw a static `NotFound.INSTANCE` instance and use ThreadLocal to store the message

## Conclusion

* It is safe (maybe encouraged) to throw static exception in an ActFramework application.
* **caution** do not use exception as control flow if your controller handler method is `static`, in which case ActFramework 
  will use Java reflection to invoke it. And anything throw out will be wrapped with `InvocationTargetException` which
  will definitly ruin your performance 
