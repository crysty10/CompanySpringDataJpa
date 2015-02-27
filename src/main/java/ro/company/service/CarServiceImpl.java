package ro.company.service;

import ro.company.domain.Car;
import ro.company.repository.CarRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public class CarServiceImpl implements CarService {

    @Inject
    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {

        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {

        return carRepository.findOne(id);
    }

    @Override
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Long id) {

        carRepository.delete(id);

    }
}
