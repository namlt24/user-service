package com.example.userservice.util;

import java.util.Collection;
import java.util.Map;

public class DataUtil {
    public static <T> boolean isNullOrEmpty(T obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        }

        if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        }

        if (obj instanceof Map<?,?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }

        return false;
    }
    public static <T> boolean safeEqual(T obj1, T obj2) {
        if (obj1 == obj2) {
            return true;
        }

        if (obj1 == null || obj2 == null) {
            return false;
        }

        return obj1.equals(obj2);
    }
}
