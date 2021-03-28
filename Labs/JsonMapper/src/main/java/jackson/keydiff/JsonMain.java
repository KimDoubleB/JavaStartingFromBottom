package jackson.keydiff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMain {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String personJson = "{\"name\":\"Kim\",\"age\":25}";
        Person person = objectMapper.readValue(personJson, Person.class);
        String personJson2 = "{\"person_name\":\"Kim\",\"age\":25}";
        Person person2 = objectMapper.readValue(personJson2, Person.class);
        System.out.println(person);
        System.out.println(person2);
    }
}
