# cucumber_parallel_execution

## Maven Surefire plugin

Cucumber tests can be exectued in parallel using JUnit and Maven test execution plugins.

In JUnit the feature files are run in parallel rather than scenarios. All the scenarios
in the feature file get executed by the same thread.

We can use the Maven Surefire plugin to run feature files in parallel.

1. Add the plugin in the pom file. Update the configurations as required-
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <parallel>methods</parallel>
        <threadCount>2</threadCount>
        <perCoreThreadCount>true</perCoreThreadCount>
    </configuration>
</plugin>
```

2. Run the following cmd in terminal to run the feature files in parallel-
```
    mvn verify
```

## Maven FailSafe Plugin

### Plugin Goals
The failsafe plugin is used for integration tests of a project. It has two goals:

1. integration-test – run integration tests; this goal is bound to the integration-test phase by default
2. verify – verify that the integration tests passed; this goal is bound to the verify phase by default

We can use the Maven FailSafe plugin to run feature files in parallel.

1. Add the plugin in the pom file. Update the configurations as required-
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>3.0.0-M5</version>
    <executions>
        <execution>
            <goals>
                <goal>integration-test</goal>
                <goal>verify</goal>
            </goals>
            <configuration>
                <includes>
                    <include>**/TestRunner.java</include>
                </includes>
                <parallel>methods</parallel>
                <threadCount>2</threadCount>
                <perCoreThreadCount>true</perCoreThreadCount>
            </configuration>
        </execution>
    </executions>
</plugin>
```

2. Run the following cmd in terminal to run the feature files in parallel-
```
    mvn verify
```

### Surefire plugin vs Failsafe plugin

This plugin runs methods in test classes just like the surefire plugin. We can configure both plugins in similar ways.
However, there're some crucial differences between them.

First, unlike surefire which is included in the super pom.xml, the failsafe plugin with its goals must
be explicitly specified in the pom.xml to be part of a build lifecycle:

Second, the failsafe plugin runs and verifies tests using different goals. A test failure in the integration-test phase
doesn't fail the build straight away, allowing the phase post-integration-test to execute, where clean-up operations are performed.

Failed tests, if any, are only reported during the verify phase, after the integration test environment has been torn down
properly.


## Callable

Java Callable can be used to run particular tasks in parallel.

### Reference:
Please refer to '/src/test/java/com/github/automation/junit/tests/ParallelTests.java' for sample usage of Callable
