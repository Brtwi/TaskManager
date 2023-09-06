package Application.Model.Services;

import Application.Model.DataModel;
import Application.Model.Entities.Task;
import Application.Model.Helpers.DataContainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class JsonServices
{
    private static final ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper()
    {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        defaultObjectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return defaultObjectMapper;
    }

    public static <A> A fromJson(JsonNode node, Class<A> klass) throws JsonProcessingException
    {
        return objectMapper.treeToValue(node, klass);
    }

    public static List<Task> fromJsonArrayStringToTaskList(String json) throws JsonProcessingException
    {
        TypeReference<List<Task>> typeReference = new TypeReference<>() {};
        return objectMapper.readValue(json, typeReference);
    }

    public static JsonNode toJson(Object a)
    {
        return objectMapper.valueToTree(a);
    }

    public static <T, U> void toJsonFile(String filename, T value, List<U> collection)
    {
        DataContainer<T, U> container = new DataContainer<>(value, collection);

        try
        {
            objectMapper.writeValue(Paths.get(DataModel.JSON_DIR + filename).toFile(), container);
        } catch (IOException ignored)
        {
        }
    }

    public static String stringify(JsonNode node) throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(node);
    }

    public static <T, U> DataContainer<T, U> fromJsonFile(String filename, Class<T> value, Class<U> collection)
    {
        try
        {
            File file = new File(DataModel.JSON_DIR + filename);

            JsonNode nodeValue = objectMapper.readTree(file).get("object");
            JsonNode nodeCollection = objectMapper.readTree(file).get("objects");

            T object = objectMapper.treeToValue(nodeValue, value);

            JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, collection);
            List<U> objects = objectMapper.treeToValue(nodeCollection, listType);


            return new DataContainer<>(object, objects);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
