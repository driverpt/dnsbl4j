[![Stories in Ready](https://badge.waffle.io/driverpt/dnsbl4j.png?label=ready&title=Ready)](https://waffle.io/driverpt/dnsbl4j)
[![Build Status](https://travis-ci.org/driverpt/dnsbl4j.svg?branch=master)](https://travis-ci.org/driverpt/dnsbl4j)
[![Coverage Status](https://img.shields.io/coveralls/driverpt/dnsbl4j.svg)](https://coveralls.io/r/driverpt/dnsbl4j)

DNSBL4j (former RBLCheck4j)
=========
dnsbl4j is a Java Framework implementation for DNSBL querying.

Usage
----
RBLChecker uses Fluent Interface pattern to make configuration more clean.
```java
public void someMethod() {
    RBLChecker rblChecker = RBLChecker.newInstance()
                                      .withSource(new ZENSpamhaus())
                                      .withSource(new Spamcop())
                                      ;
    List<RBLError> errors = rblChecker.check("8.8.8.8");
    
    /*
        Do some stuff with the errors
    */
}
```

Well Known DNSBL Providers
----
Currently we have 2 well known providers implemented to simplify usage

 * [Spamhaus ZEN]
 * [Spamcop]

TODO
----
 * XML Configuration

License
----
Apache V2.0

[Spamhaus ZEN]:http://www.spamhaus.org
[Spamcop]:http://www.spamcop.net
