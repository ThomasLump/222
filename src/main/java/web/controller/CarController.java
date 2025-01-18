package web.controller;

import jakarta.validation.constraints.*;
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
    public String cars(@RequestParam(name = "count",required = false, defaultValue = "5")
                           @Min(1)
                           @Max(5)
                           int count, Model model ) {
        //мне хочется ограничить ввод параметра, чтобы ничего кроме цифер
        //как без ифа тут - ну мне ток в голову пришло либо тернарником
        //либо писать формулу через остатки от деления и срезание знака
            model.addAttribute("cars", carService.getCarsByCount(count));
        return "cars";
    }
}
