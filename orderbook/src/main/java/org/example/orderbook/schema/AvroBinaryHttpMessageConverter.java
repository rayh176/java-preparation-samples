package org.example.orderbook.schema;

import org.springframework.http.MediaType;

public class AvroBinaryHttpMessageConverter<T> extends AvroHttpMessageConverter<T> {

    public AvroBinaryHttpMessageConverter() {
        super(true, new MediaType("application", "avro", DEFAULT_CHARSET),
                new MediaType("application", "*+avro", DEFAULT_CHARSET));
    }
}