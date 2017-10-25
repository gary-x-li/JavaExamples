package demo.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDate;

import base.pojo.Vehicle;

public class VehicleSelectionHandler implements InvocationHandler {
    
    private Vehicle car;
    private Vehicle truck;
    
    public VehicleSelectionHandler(Vehicle car, Vehicle truck) {
        this.car = car;
        this.truck = truck;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (LocalDate.now().getDayOfMonth() % 2 == 0) {
            return method.invoke(car, args);
        } else {
            return method.invoke(truck, args);
        }
    }

}
