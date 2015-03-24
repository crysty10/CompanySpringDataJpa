package ro.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
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

    @Autowired(required = true)
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    private AddressService addressService;

    @Inject
    @Qualifier("conversionService")
    public ConversionService conversionService;

    @Inject
    public AddressController(AddressService addressService) {


        this.addressService = addressService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
        //binder.setConversionService(conversionService);
    }
    @RequestMapping(value = "/addresss", method = RequestMethod.GET)
    public String addresses(Model model) {

        model.addAttribute("addressList", addressService.findAllAddresses());
        return "addresss";
    }

    /**
     * Get the page for adding a new address.
     *
     * @return the name of the view.
     * params = {"address} --> @RequestParam(value = "address")
     */
    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String showRegistrationFormAddress(Model model) {


        model.addAttribute("address",new Address());
        return "addAddress";
    }

    /**
     * Save an address into the database.
     *
     *
     * @return redirect to all addresses page to check the result.
     * params = {"department} --> @RequestParam(value = "department")
     */
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String saveAddress(@Valid Address address, BindingResult bindingResult, Errors errors) {

        if (bindingResult.hasErrors()) {
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addAddress";
        }

        addressService.createAddress(address);
        return "redirect:/addresss";
    }


    /**
     * Edit details about an address.
     *
     * @param addressId the address you want to update
     * @param model      used to save the address details.
     * @return name of the view.
     */
    @RequestMapping(value = "/addresss/{addressId}", method = RequestMethod.GET)
    public String updateAddress(
        @PathVariable long addressId, Model model) {

        Address address = addressService.findAddressById(addressId);
        model.addAttribute(address);
        return "updateAddress";
    }

    /**
     * Update an address from database.
     *
     * @param address the entity to populate with data.
     * @return redirect to all addresses page to check the result.
     */
    @RequestMapping(value = "/addresss/{addressId}", method = RequestMethod.POST)
    public String processUpdate(@ModelAttribute Address address,
                                @PathVariable Long addressId) {

        address.setId(addressId);
        addressService.createAddress(address);
        return "redirect:/addresss";
    }



    /**
    *
    * Delete an address from database.
    *
    * @return redirect to all addresses page to check if the action executed.
    */
    @RequestMapping(value = "/addresss", method = RequestMethod.POST)
    public String removeAd(@RequestParam("address") long addressId) {

        Address address = addressService.findAddressById(addressId);
        addressService.deleteAddress(address);
        return "redirect:/addresss";
    }


}
