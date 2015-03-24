package ro.company.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.domain.Car;
import ro.company.repository.CarRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Inject
    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {

        //return em.merge(car);
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {

        return carRepository.findOne(id);
    }

    @Override
    public Car getCarByCarName(String carName) {

        return carRepository.findByCarName(carName);
    }

    @Override
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteCar(Car car) {

        carRepository.delete(car);
    }
}
