package ro.company.repository;


import ro.company.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    /*
    * Get a car by car name!
    * */
    Car findByCarName(String carName);

    /*
    * Get all cars by the car name!
    * */
    List<Car> findAllCarByCarName(String carName);
}
