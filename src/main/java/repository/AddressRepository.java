package repository;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>  {

    Address findBylocality(String locality);
}