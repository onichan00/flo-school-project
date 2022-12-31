package com.hva.helios.views;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * This class defines views for serialization with Jackson.
 * <p>
 * Public view: Only includes fields annotated with @JsonView(Views.Public.class)
 * Internal view: Includes all fields
 */
public class Views {
    public static class Public {}

    public static class Internal extends Public {}

    /**
     * Serializer that only includes fields annotated with @JsonView(Views.Public.class)
     */
    public static class PublicSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            // Create a JsonMapper with default view inclusion disabled
            JsonMapper mapper = JsonMapper.builder()
                    .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
                    .build();

            // Set serialization inclusion to always include values
            mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

            // Register the JavaTimeModule and disable writing timestamps for date fields
            mapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            // Set the serialization view to the Public view
            mapper.setConfig(mapper.getSerializationConfig().withView(Public.class));

            // Set the JsonGenerator's codec to the configured JsonMapper
            jsonGenerator.setCodec(mapper);
            jsonGenerator.writeObject(object);
        }
    }
}
