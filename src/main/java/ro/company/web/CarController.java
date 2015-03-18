package ro.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ro.company.domain.Car;
import ro.company.service.CarService;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class CarController {

    private CarService carService;

    @Autowired(required = true)
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
    }

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public String cars(Model model){
        model.addAttribute("carList", carService.getAllCars());
        return "cars";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){

        model.addAttribute("car", new Car());
        return "addCar";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String saveCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult,
                          Errors errors, Model model) {
        if(bindingResult.hasErrors()) {
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addCar";
        }

        carService.createCar(car);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
    public String updateCar(@PathVariable long carId, Model model) {

        Car car = carService.getCarById(carId);
        model.addAttribute(car);
        return "updateCar";
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.POST)
    public String processUpdate(@ModelAttribute Car car, @PathVariable Long carId) {

        car.setId(carId);
        carService.createCar(car);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String removeAd(@RequestParam("car") long carId) {

        Car car = carService.getCarById(carId);
        carService.deleteCar(car);
        return "redirect:/cars";
    }
}
