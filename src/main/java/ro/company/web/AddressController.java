package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.AddressService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    @Inject
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String addresses(Model model) {

        model.addAttribute("addressList", addressService.findAllAddresses());
        return "addresses";
    }
}