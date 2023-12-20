package com.backend.deserialiser;
import java.io.IOException;
import java.time.LocalDate;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        String dateStr = parser.getText();
        return LocalDate.parse(dateStr);
    }
}
