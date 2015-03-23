package ro.company.web;

/**
 * Created by Florin.Cojocaru on 3/20/2015.
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;

public class CustomWebBindingInitializer implements WebBindingInitializer {


    @Inject
    @Qualifier("conversionService")
    private ConversionService conversionService;

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.setConversionService(conversionService);
    }

}
