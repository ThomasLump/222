package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarRepository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarsByCount(int count) {
        if (count > 5) {
            return carRepository.getListOfCars();
        } else {
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cars.add(i, carRepository.getListOfCars().get(i));
            }
            return cars;
        }
    }
}
