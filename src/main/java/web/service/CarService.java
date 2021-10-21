package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> list = new ArrayList<>();

    private final Car car1 = new Car("Kia", 3, "black");
    private final Car car2 = new Car("Ford", 2, "white");
    private final Car car3 = new Car("Toyota", 3, "red");
    private final Car car4 = new Car("Honda", 4, "gray");
    private final Car car5 = new Car("Mitsubishi", 3, "purple");

    {
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
    }

    public List<Car> getList() {
        return list;
    }

    public List<Car> getOfCar(int count) {
        return getList().subList(0,count);
    }
}
