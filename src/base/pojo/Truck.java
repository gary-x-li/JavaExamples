package base.pojo;

public class Truck implements Vehicle {

    @Override
    public void start() {
        System.out.println("Truck started.");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped.");        
    }
    
}
