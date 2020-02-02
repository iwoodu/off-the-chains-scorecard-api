package com.rhitm.scorecard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

/**
 * Convenience class to reduce code when creating unit tests for serializable Java beans.
 * <p>
 * Credit for this class goes to the author of the article posted at
 * <a href="https://www.jdev.it/tips-unit-testing-javabeans/">https://www.jdev.it/tips-unit-testing-javabeans/</a>
 * </p>
 * Use this class when testing Serializable Java beans. Use <code>AbstractJavaBeanTest</code>
 * when testing non-Serializable Java beans.
 *
 * @param <T> Generic for the Java bean type to be tested
 * 
 * @see AbstractJavaBeanTest
 */
public abstract class AbstractSerializableJavaBeanTest<T> extends AbstractJavaBeanTest<T> {

    protected String[] propertiesToBeIgnored;

    @Test
    public void beanIsSerializable() throws Exception {
        final T myBean = getBeanInstance();
        final byte[] serializedMyBean = SerializationUtils.serialize((Serializable) myBean);
        @SuppressWarnings("unchecked")
        final T deserializedMyBean = (T) SerializationUtils.deserialize(serializedMyBean);
        assertEquals(myBean, deserializedMyBean);
    }

}