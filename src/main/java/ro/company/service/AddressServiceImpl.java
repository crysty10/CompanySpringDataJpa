package ro.company.service;

import ro.company.domain.Address;
import ro.company.repository.AddressRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public class AddressServiceImpl implements AddressService {

    @Inject
    private AddressRepository addressRepository;


    @Override
    public Address createAddress(Address address) {

        return addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Long id) {

        return addressRepository.findOne(id);
    }

    @Override
    public List<Address> findAllAddresses() {

        return addressRepository.findAll();
    }

    @Override
    public void deleteAddress(Long id) {

        addressRepository.delete(id);

    }
}
