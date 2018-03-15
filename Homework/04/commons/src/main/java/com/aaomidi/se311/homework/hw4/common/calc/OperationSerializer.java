package com.aaomidi.se311.homework.hw4.common.calc;

import com.google.gson.*;

import java.lang.reflect.Type;

public class OperationSerializer implements JsonSerializer<Operation>, JsonDeserializer<Operation> {
    @Override
    public Operation deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject wrapper = (JsonObject) jsonElement;
        switch (Operation.Type.valueOf(wrapper.get("type").getAsString())) {
            case OPERAND:
                return jsonDeserializationContext.deserialize(wrapper.get("data"), Operand.class);
            case OPERATOR:
                return jsonDeserializationContext.deserialize(wrapper.get("data"), Operator.class);
        }
        return null;
    }

    @Override
    public JsonElement serialize(Operation operation, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject wrapper = new JsonObject();
        wrapper.addProperty("type", operation.getType().toString());
        wrapper.add("data", jsonSerializationContext.serialize(operation));

        return wrapper;
    }
}
