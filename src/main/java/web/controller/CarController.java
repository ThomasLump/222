package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars(@RequestParam(name = "count", defaultValue = "5") String count, Model model ) {
        if (Integer.parseInt(count) <= 5 && Integer.parseInt(count) > 0) {
            model.addAttribute("cars", carService.getCarsByCount(Integer.parseInt(count)));
        } else {
            model.addAttribute("cars",  carService.getCarsByCount(5));
        }
        return "cars";
    }
}
