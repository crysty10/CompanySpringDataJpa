package repository;

import domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>  {

    Adress findBylocality(String locality);
}
