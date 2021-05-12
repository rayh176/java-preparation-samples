package org.example.orderbook.schema;

import org.apache.commons.lang.SerializationException;

public interface Serializer<T> {
    /**
     * Serialize object as byte array.
     * @param T data the object to serialize
     * @return byte[]
     */
    byte[] serialize(T data) throws SerializationException;
}
