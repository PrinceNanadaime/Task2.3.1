package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    List<Car> list = new ArrayList<>();

    public List<Car> getList() {
        return list;
    }

    Car car1 = new Car("Kia", 3, "black");
    Car car2 = new Car("Ford", 2, "white");
    Car car3 = new Car("Toyota", 3, "red");
    Car car4 = new Car("Honda", 4, "gray");
    Car car5 = new Car("Mitsubishi", 3, "purple");

    {
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
    }

    public List<Car> getOfCar(List<Car> list, int count) {
        List<Car> result;
        switch (count) {
            case 1:
                result = list.subList(0, 1);
                break;
            case 2:
                result = list.subList(0, 2);
                break;
            case 3:
                result = list.subList(0, 3);
                break;
            case 4:
                result = list.subList(0, 4);
                break;
            default:
                result = list;
        }
        return result;
    }
}
