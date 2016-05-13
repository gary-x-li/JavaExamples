package demo.jackson;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSimpleBindingDemo {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String basePath = new File("").getAbsolutePath();
		String jsonFilePath = basePath.concat("/src/demo/jackson/people.json");
		System.out.println(jsonFilePath);
		
		ObjectMapper mapper = new ObjectMapper();
	    List<Person> value = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Person>>(){});
	    System.out.println(value);
	}
}
