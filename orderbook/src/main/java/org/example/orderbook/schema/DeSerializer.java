package org.example.orderbook.schema;

import org.apache.commons.lang.SerializationException;

public interface DeSerializer <T> {

    /**
     * Deserialize object from a byte array.
     * @param Class<? extends T> clazz the expected class for the deserialized object
     * @param byte[] data the byte array
     * @return T object instance
     */
    T deserialize(Class<? extends T> clazz, byte[] data) throws SerializationException;

}

