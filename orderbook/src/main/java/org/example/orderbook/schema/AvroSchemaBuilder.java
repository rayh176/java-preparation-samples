package org.example.orderbook.schema;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class AvroSchemaBuilder {

    public void createOrderBuilder(){
        Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier")
                .namespace("com.baeldung.avro")
                .fields().requiredString("hostName").requiredString("ipAddress")
                .endRecord();

        Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest")
                .namespace("com.baeldung.avro")
                .fields().requiredLong("requestTime")
                .name("clientIdentifier")
                .type(clientIdentifier)
                .noDefault()
                .name("employeeNames")
                .type()
                .array()
                .items()
                .stringType()
                .arrayDefault(null)
                .name("active")
                .type()
                .enumeration("Active")
                .symbols("YES","NO")
                .noDefault()
                .endRecord();
    }
}
