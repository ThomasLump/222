package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> carsRep;
    {
        carsRep = new ArrayList<>(List.of(
                new Car(1, "acura", "blue"),
                new Car(1, "bmw", "violet"),
                new Car(1, "cadilac", "red"),
                new Car(1, "datsun", "orange"),
                new Car(1, "exeed", "yellow")
        ));
    }

    @Override
    public List<Car> getListOfCars() {
        return carsRep;
    }

    @Override
    public List<Car> getListOfCarsByCount(int count) {
        if (count > 5) {
            return carsRep;
        } else {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cars.add(i, carsRep.get(i));
            }
            return cars;
        }
    }
}
