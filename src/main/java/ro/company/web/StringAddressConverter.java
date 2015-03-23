package ro.company.web;

import org.springframework.core.convert.converter.Converter;
import ro.company.domain.Address;
import ro.company.service.AddressService;

import javax.inject.Inject;
import javax.transaction.Transactional;


/**
 * Created by Florin.Cojocaru on 3/20/2015.
 */


public class StringAddressConverter implements Converter<String, Address> {

    @Inject
    private AddressService addressService;


    @Transactional
    @Override
    public Address convert(String idStr) {
        return addressService.findAddressById(Long.valueOf(idStr));
    }
}
