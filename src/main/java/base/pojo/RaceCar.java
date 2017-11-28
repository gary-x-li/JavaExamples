package base.pojo;

public class RaceCar extends Car {

    @Override
    public void start() {
        System.out.println("Race car started.");
    }

    @Override
    public void stop() {
        System.out.println("Race car stopped.");
    }

}
