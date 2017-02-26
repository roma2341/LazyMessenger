package com.softgroup.common.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zigza on 25.02.2017.
 */
public class CommonReflectionUtils {
    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
    }
}
