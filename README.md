[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/gbraad)

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
