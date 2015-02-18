package repository;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>  {

    /*
    * Get an address by the locality name!
    * */
    Address findBylocality(String locality);

    /*
    * Get all addresses by the street name!
    * */
    List<Address> findByStreet(String street);

    /*
    * Get an address by the apartment number!
    * */
    Address findByApartment(int apartment);

    /*
    * Get all addresses by the country name using a query!
    * */
    @Query("SELECT A FROM Address A WHERE A.country = :country")
    List<Address> findAllByCountry(@Param("country") String country);
}
