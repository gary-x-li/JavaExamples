package demo.jackson;

public class Person {
	  public String name;
	  public int age; 
	  
	  @Override
	  public String toString() {
		  return name + ": " + age;
	  }
}
