package com.hihusky.reflection.util;

import com.hihusky.reflection.BaseAnnotationTarget;
import com.hihusky.reflection.BaseClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    /**
     * Call the method of class for instance which generate from above class by reflection
     */
    @Test
    public void testField() throws IllegalAccessException {
        BaseClass baseClass = new BaseClass();
        Field[] fields = BaseClass.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(baseClass, 11);
        }
        System.out.println(baseClass);
    }

    @Test
    public void testAnnotationTarget() {
        Class clazz = BaseAnnotationTarget.class;
        // Method
    }
}
