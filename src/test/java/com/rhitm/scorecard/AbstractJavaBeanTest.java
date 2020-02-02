package com.rhitm.scorecard;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * Convenience class to reduce code when creating unit tests for Java beans.
 * <p>
 * Credit for this class goes to the author of the article posted at
 * <a href="https://www.jdev.it/tips-unit-testing-javabeans/">https://www.jdev.it/tips-unit-testing-javabeans/</a>
 * </p>
 *
 * @param <T> Generic for the Java bean type to be tested
 * 
 * @see AbstractSerializableJavaBeanTest
 */
public abstract class AbstractJavaBeanTest <T> {

    protected String[] propertiesToBeIgnored;

    @Test
    public void equalsAndHashCodeContract() {
    	//EqualsVerifier library
        EqualsVerifier.forClass(getBeanInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
        
        //meanBeans library
        EqualsMethodTester tester = new EqualsMethodTester();
        tester.testEqualsMethod(getBeanInstance().getClass());
        
        HashCodeMethodTester hashTester = new HashCodeMethodTester();
        hashTester.testHashCodeMethod(getBeanInstance().getClass());
    }

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        final BeanTester beanTester = new BeanTester();
        beanTester.testBean(getBeanInstance().getClass());
    }

    protected abstract T getBeanInstance();

}