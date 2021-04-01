# GlidedRose

[GlidedRose](https://github.com/emilybache/GildedRose-Refactoring-Kata)
is the referenced tool to manage your inventories. It handles on your behalf your product expiration date and forecasts
their correlating quality/market value.

It comes with a pre-fulfilled list of most known products such as :

- Aged brie
- World of warcraft item (common to legendary items and elixirs)
- Backstage passes
- Conjured items (soon !)

## Installation

#### Prerequisites:

- [install](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) java runtime environment 8+
- [set](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html) JAVA_HOME env variable
- [download and install](https://maven.apache.org/download.cgi) maven 3+
- [add](https://www.baeldung.com/install-maven-on-windows-linux-mac) maven bin folder to path env variable

#### create JAR file

execute command:

```
mvn clean package
```

## Run program

In order to forecast items quality on an iterating daily basis, concat

- java executable command
- generated jar relative/absolute location
- main class package and name -> "com.gildedrose.TexttestFixture" (fixed)
- days argument

example: run application and forecast quality evolution for next 20 days

```
java -cp target/gilded-rose-kata-0.0.1-SNAPSHOT.jar com.gildedrose.TexttestFixture 20
```

#### arguments

| type    | optional |  default |
|:-------:|:--------:|---------:|
| integer | true     | 2        |

Forecasted items quality will be output in the console day by day

## Run tests

#### Run integration tests

Test folders are segregated, integration test classes can be found in src/integration-test

Integration tests are comparing actual application console output with expected output saved in resources folder
Comparison is done line by line to ease debugging

**integration** maven profile must be used in order to access segregated folder classes and resources

for now 2 tests are written

- test application behavior with no arguments
- test application behavior with a argument number that exceeds all items sellIn value -> 20

Run command:

```
mvn verify -Pintegration
```

notes:

- integration test classes must be suffixed by "IT" in order to be included by failsafe maven plugin
- unit tests are not triggered while using integration profile

#### Run unit tests

execute command:

```
mvn test
```

Notes: so far the only unit test is skipped however unit testing strategy is going to be consolidated in upcoming
iterations

### Biggest consumers and sponsors

- Allison