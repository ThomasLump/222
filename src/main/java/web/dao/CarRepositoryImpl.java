package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {
    @Override
    public List<Car> getListOfCars() {
        return List.of(
                new Car(1,"acura", "blue"),
                new Car(1,"bmw", "violet"),
                new Car(1,"cadilac", "red"),
                new Car(1,"datsun", "orange"),
                new Car(1,"exeed", "yellow")
        );
    }
}
