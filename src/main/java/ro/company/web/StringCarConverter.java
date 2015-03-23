package ro.company.web;

import org.springframework.core.convert.converter.Converter;
import ro.company.domain.Car;
import ro.company.service.CarService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by Florin.Cojocaru on 3/19/2015.
 */
public class StringCarConverter implements Converter<String, Car> {

    @Inject
    private CarService carService;

    @Transactional
    @Override
    public Car convert(String idStr) {

        if(idStr == "") {
            return null;
        }
        return carService.getCarById(Long.valueOf(idStr));
    }
}
