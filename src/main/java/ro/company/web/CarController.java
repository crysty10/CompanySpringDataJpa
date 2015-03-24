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

    @Inject
    public CarController(CarService carService) {

        this.carService = carService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String cars(Model model) {
        model.addAttribute("carList", carService.getAllCars());
        return "cars";
    }

    /**
     * Get the page for adding a new car.
     *
     * @return the name of the view.
     * params = {"car} --> @RequestParam(value = "car")
     */
    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String showRegistrationFormCar( Model model) {


        model.addAttribute("car",new Car());
        return "addCar";
    }

    /**
     * Save an car into the database.
     *
     *
     * @return redirect to all cars page to check the result.
     * params = {"car} --> @RequestParam(value = "car")
     */
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String saveCar(@Valid Car car, BindingResult bindingResult,Model model, Errors errors) {

        if (bindingResult.hasErrors()) {
            //create a set of errors and iterate threw it to view the errors
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addEmployee";
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
