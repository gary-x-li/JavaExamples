package demo.reflection;

import java.lang.reflect.Proxy;

import base.pojo.Car;
import base.pojo.Truck;
import base.pojo.Vehicle;

public class DynamicProxyDemo {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        
        Vehicle v = (Vehicle) Proxy.newProxyInstance(
                Vehicle.class.getClassLoader(), 
                new Class[] { Vehicle.class }, 
                new VehicleSelectionHandler(car, truck));
        
        v.start();
        v.stop();
    }

}
