package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getListOfCars();
    List<Car> getListOfCarsByCount(int count);
}
