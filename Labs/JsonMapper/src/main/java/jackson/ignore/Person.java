package jackson.ignore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    String name;
    Job job;

    public Person() {
    }

    public Person(String name, Job job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public Job getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}