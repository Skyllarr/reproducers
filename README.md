# Cipher suite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 supported in FIPS mode

run example:

```console
mvn compile
mvn exec:exec
```

You can comment out the `System.setSecurityManager(new SecurityManager());` line and the result of ciphers will be different.
