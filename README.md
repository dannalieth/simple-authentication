# simple-authentication

Simple Dropwizard Authentication Application.

## Setup Server SSL

In order for chrome to properly trust the server, a valid certificate needs to be provided.
The default one will result in "ERR_SSL_VERSION_OR_CIPHER_MISMATCH".

To generate the keystore and truststore follow the instructions from:
https://docs.continuent.com/tungsten-replicator-3.0/deployment-ssl-stores.html
