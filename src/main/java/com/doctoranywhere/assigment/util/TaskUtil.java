package com.doctoranywhere.assigment.util;

import java.util.Objects;

public class TaskUtil {
    public static boolean isStrNotNullOrEmpty(String inp) {
        return Objects.nonNull(inp) && !inp.trim().isEmpty();
    }
    public static boolean isNotNull(Object inp) {
        return Objects.nonNull(inp);
    }
}
