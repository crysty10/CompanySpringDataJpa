package repository;


import domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByCarName(String carName);
    List<Car> findAllCarByCarName(String carName);
}
