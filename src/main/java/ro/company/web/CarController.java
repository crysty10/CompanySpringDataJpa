package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.CarService;

import javax.inject.Inject;

/**
 * Created by Florin.Cojocaru on 3/10/2015.
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCars(Model model) {

        model.addAttribute("carsList",carService.getAllCars());

        return "cars";

    }
}
