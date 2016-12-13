package hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        
        List<String> result = words.stream()
                                   .map(word -> word.split(""))
                                   .flatMap(arr -> Arrays.stream(arr))
                                   .collect(Collectors.toList());
        
        result.forEach(s -> System.out.println(s.toString()));
        System.out.println(result);
        
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
            numbers1.stream()
                    .flatMap(i -> numbers2.stream()
                                          .map(j -> new int[]{i, j})
                                          .filter(a -> (a[0] + a[1]) % 3 == 0)
                            )
                    .collect(Collectors.toList());
        
        pairs.forEach(a -> System.out.println(a[0] + " " + a[1]));
        
        
    }

}
