package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.AddressService;
import javax.inject.Inject;

/**
 * Created by Florin.Cojocaru on 3/10/2015.
 */

@Controller
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Inject
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAddresses(Model model) {

        model.addAttribute("addressesList",addressService.findAllAddresses());

        return "address";
    }
}




