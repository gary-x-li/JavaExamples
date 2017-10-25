package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        List<String> myList = new ArrayList<String>();
        
        myList.add("1");
        myList.add("2");
        myList.add("3");
//        myList.add("4");
//        myList.add("5");
 
        Iterator<String> it = myList.iterator();
        while(it.hasNext()){
            String value = it.next();
            System.out.println("List Value:"+value);
            if(value.equals("3")) it.remove();
        }
        
        System.out.println(myList);
 
//        Map<String,String> myMap = new HashMap<String,String>();
//        myMap.put("1", "1");
//        myMap.put("2", "2");
//        myMap.put("3", "3");
// 
//        Iterator<String> it1 = myMap.keySet().iterator();
//        while(it1.hasNext()){
//            String key = it1.next();
//            System.out.println("Map Value:"+myMap.get(key));
//            if(key.equals("2")){
//                myMap.put("1","4");
//                //myMap.put("4", "4");
//            }
//        }
        
    }

}
