package repository;


import domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByCarName(String car_name);
}
