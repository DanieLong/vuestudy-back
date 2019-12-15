package com.lk.test.vuestudy.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;

public class ResultSerializerUtils<T> extends JsonSerializer<T> {

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        if (null == value) {
            gen.writeObject(new HashMap<>());
        }
    }

}
