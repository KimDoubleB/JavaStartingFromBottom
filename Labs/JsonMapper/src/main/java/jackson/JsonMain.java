package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JsonMain {
    public static void main(String[] args) throws JsonProcessingException {
        Person p = new Person("Kim", 25, new Job("Backend developer", 600, "Game company"));
        ObjectMapper mapper = new ObjectMapper();
        String personToJson = mapper.writeValueAsString(p);
        System.out.println(personToJson);
        // {"name":"Kim","age":25,"job":{"name":"Backend developer","averageSalary":600,"company":"Game company"}}

        var personList = Arrays.asList(
                new Person("Lee", 26, new Job("Student", 0, "University")),
                new Person("Park", 42, new Job("Teacher", 200, "High School")),
                new Person("Sim", 32, new Job("frontend developer", 400, "e-commerce"))
        );

        String personsToJson = mapper.writeValueAsString(personList);
        System.out.println(personsToJson);
        // [{"name":"Lee","age":26,"job":{"name":"Student","averageSalary":0,"company":"University"}},{"name":"Park", "age":42,"job":{"name":"Teacher","averageSalary":200,"company":"High School"}},{"name":"Sim","age":32, "job":{"name":"frontend developer","averageSalary":400,"company":"e-commerce"}}]


        Person p2 = mapper.readValue(personToJson, Person.class);
        System.out.println(p2);

        // Array
        Person[] personArray = mapper.readValue(personsToJson, Person[].class);

        // Collection (List)
        List<Person> personList2 = mapper.readValue(personsToJson, List.class);

        // Use TypeReference
        List<Person> personList3 = mapper.readValue(personsToJson, new TypeReference<>() {
        });
    }
}
