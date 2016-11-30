package hello;

import java.util.List;

import com.google.common.collect.Lists;

public class HelloWorld {

    public static void main(String[] args) {
        List<String> colors = Lists.newArrayList("red", "green", "blue");
        System.out.println(colors);
    }

}
