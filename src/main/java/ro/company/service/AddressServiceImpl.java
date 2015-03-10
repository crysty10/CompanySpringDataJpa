package ro.company.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.domain.Address;
import ro.company.repository.AddressRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Inject
    private AddressRepository addressRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Address createAddress(Address address) {

        return addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Long id) {

        return addressRepository.findOne(id);
    }

    @Override
    public Address findAddressByLocalityAndStreet(String locality, String street) {

        return addressRepository.findAddressByLocalityAndStreet(locality, street);
    }

    @Override
    public List<Address> findAllAddresses() {

        return addressRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteAddress(Address address) {

        addressRepository.delete(address);
    }
}
