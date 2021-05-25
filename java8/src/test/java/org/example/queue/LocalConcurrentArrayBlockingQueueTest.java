package org.example.queue;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocalConcurrentArrayBlockingQueueTest {

    private LocalConcurrentArrayBlockingQueue localConcurrentArrayBlockingQueue;

    @BeforeAll
    public void setUp() {
        localConcurrentArrayBlockingQueue = new LocalConcurrentArrayBlockingQueue(5);
    }

    @ParameterizedTest
    //@ValueSource(ints = {2,3,4,5})
    @MethodSource("objectToInsert")
    public void testOffer(@ConvertWith(IntArrayConverter.class) int [] values ){
        Arrays.stream(values).forEach( value ->
            new Thread(() -> localConcurrentArrayBlockingQueue.offer(value))
        );
        new Thread(() -> localConcurrentArrayBlockingQueue.pull(01));
    }

    @Test
    public void testAllEntries() {
        int[] values = {1,2,3,4,5,6};
        Arrays.stream(values).forEach( value ->
                new Thread(() -> localConcurrentArrayBlockingQueue.offer(value))
        );
        assertEquals(localConcurrentArrayBlockingQueue.pull(01), 1);
    }

    @Test
    public void testAllBlockingQueueEntries() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(5);
        int[] values = {1,2,3,4,5,6};
        Arrays.stream(values).forEach( value ->
                new Thread(() -> blockingQueue.offer(value))
        );
        assertEquals(
            blockingQueue.take()
        , 1);
    }

    private static Stream<Arguments> objectToInsert() {
        return Stream.of(Arguments.of(1,2,3,4,5,6), Arguments.of(6,7,8,9,10,11,12));
    }

    public static class IntArrayConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if (source instanceof Integer && Integer[].class.isAssignableFrom(targetType)) {
                return new int [] {1,2,3,4,5,6};
            } else {
                throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                        + targetType + " not supported.");
            }
        }

    }
}
