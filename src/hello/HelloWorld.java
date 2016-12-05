package hello;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class HelloWorld {

    public static void main(String[] args) {
        List<String> colors = Lists.newArrayList("red", "green", "blue");
        System.out.println(colors);
        
        List<String> red = colors.stream().filter(s -> s.equals("red")).collect(Collectors.toList());
        System.out.println(red);
    }

}
