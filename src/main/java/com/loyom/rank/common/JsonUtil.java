package com.loyom.rank.common;

import com.google.gson.Gson;

public class JsonUtil {

    private static final Gson GSON = new Gson();

    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        return GSON.toJson(obj);
    }

    public static Object toObject(String json) {
        if (json == null || "".equals(json)) {
            return "";
        }
        return GSON.fromJson(json, Object.class);
    }

    public static Object toObject(String json, Class<?> clazz) {
        if (json == null || "".equals(json)) {
            return "";
        }
        return GSON.fromJson(json, clazz);
    }
}
