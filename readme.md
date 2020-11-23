This repository is used to simulate the schema registration exception 415

1. `curl -o http://packages.confluent.io/archive/2.0/confluent-2.0.1-2.11.7.tar.gz`
2. `tar -xvzf  confluent-2.0.1-2.11.7.tar.gz`
3. `cd confluent-2.0.1`
4. add the below properties to `etc/schema-registry/schema-registry.properties`

```
kafkastore.bootstrap.servers=PLAINTEXT://kafka01.cap.qa.opal.synacor.com:9092
kafkastore.connection.url=kafka01.cap.qa.opal.synacor.com:2181/kafka010_adstreams
kafkastore.topic=_schemas_1

debug=false


access.control.allow.methods=GET,POST,PUT,OPTIONS
access.control.allow.origin=*
schema.registry.group.id=schema-registry-2
```
5. start confluent schema registry using `bin/schema-registry-start etc/schema-registry/schema-registry.properties`
6. finally run the project using `gradle clean run`.