package ro.company.service;

import ro.company.domain.Car;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public interface CarService {

        //CREATE OR UPDATE
        Car createCar(Car car);

        //READ
        Car getCarById(Long id);
        List<Car> getAllCars();

        //DELETE
        void deleteCar(Long id);
}
