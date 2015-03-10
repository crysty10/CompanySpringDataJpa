package ro.company.service;

import ro.company.domain.Address;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public interface AddressService {

    //CREATE OR UPDATE
    Address createAddress(Address address);

    //READ
    Address findAddressById(Long id);
    Address findAddressByLocalityAndStreet(String locality, String street);
    List<Address> findAllAddresses();

    //DELETE
    void deleteAddress(Address address);
}

