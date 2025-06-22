package com.google.gson.internal;

import java.lang.reflect.Type;

public abstract class j {
    public static boolean a(Type type) {
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return false;
        }
        return true;
    }
}
