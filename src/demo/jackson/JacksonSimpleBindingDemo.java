package demo.jackson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSimpleBindingDemo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        // JSON to Object
        String basePath = new File("").getAbsolutePath();
        String jsonFilePath = basePath.concat("/src/demo/jackson/people.json");
        System.out.println(jsonFilePath);
        
        ObjectMapper mapper = new ObjectMapper();
        List<Person> value = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Person>>(){});
        System.out.println(value);
        
        // Object to JSON to Object
        Person p = new Person();
        p.setAge(2);
        p.setName("Ethan");
        
        String text = mapper.writeValueAsString(p);
        System.out.println(text);
        
        Person ethan = mapper.readValue(text, Person.class);
        System.out.println(ethan.toString());

    }
}
