package Application.Model.Services;

import Application.Model.Entities.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class JsonServices
{
    private static final ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper()
    {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
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

    public static String stringify(JsonNode node) throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(node);
    }
}
