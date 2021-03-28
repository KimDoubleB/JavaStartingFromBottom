package jackson.ignore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JsonMain {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String personJson = "{\"name\":\"Kim\",\"age\":25,\"job\":{\"name\":\"Backend developer\"," +
                "\"averageSalary\":600,\"company\":\"Game company\"}}";
        Person person = objectMapper.readValue(personJson, Person.class);
        System.out.println(person);
    }
}
