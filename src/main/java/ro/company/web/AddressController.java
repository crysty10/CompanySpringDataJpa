package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.company.domain.Address;
import ro.company.service.AddressService;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class AddressController {

    private AddressService addressService;

    @Inject
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/addresss",method = RequestMethod.GET)
    public String addresses(Model model) {

        model.addAttribute("addressList", addressService.findAllAddresses());
        return "addresss";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "addAddress";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String saveAddress(Address address){
        addressService.createAddress(address);
        return "redirect:/addresss";
    }

    @RequestMapping(value = "/addresss/{addressId}",method = RequestMethod.GET)
    public String updateAddress(@PathVariable long addressId, Model model){
        Address address = addressService.findAddressById(addressId);
        model.addAttribute(address);
        return "updateAddress";
    }

    @RequestMapping(value = "/addresss/{addressId}",method = RequestMethod.POST)
    public String processUpdate(@ModelAttribute Address address, @PathVariable Long addressId) {

        address.setId(addressId);
        addressService.createAddress(address);
        return "redirect:/addresss";
    }

    @RequestMapping(value = "/addresss", method = RequestMethod.POST)
    public String removeAd(@RequestParam("address") long addressId) {

        Address address = addressService.findAddressById(addressId);
        addressService.deleteAddress(address);
        return "redirect:/addresss";
    }
}
