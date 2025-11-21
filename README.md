# kafka-key-to-partition

This is a little tool which determines the kafka partition for a given string key. The tools calculates the partition with the help of the algorithm from the kafka-client library.

## build
There can be a fat jar and a native image build. 
The fat jar builds with a standard java 21 sdk:
```
mvn clean package
```

The native image build needs a graalvm 21 sdk:
```
mvn clean package -Pnative
```

## usage

```
java -jar kafka-key-to-partition-<version>-jar-with-dependencies.jar <key> <number_of_partition>
```
or native image
```
kafka-key-to-partition <key> <number_of_partition>
```

