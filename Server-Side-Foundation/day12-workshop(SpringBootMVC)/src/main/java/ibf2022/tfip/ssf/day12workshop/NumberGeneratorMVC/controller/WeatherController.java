package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    
        //request param method
        @GetMapping
        public String getWeather(@RequestParam(required = true) String city, @RequestParam(defaultValue = "kilometers") String units, Model model){
            model.addAttribute("city", city);
            model.addAttribute("units", units);
            return "weather";
        }
    
        //path variable method 
        @GetMapping("{country}")
        public String getWeather2(@PathVariable(name="country",required = true) String city, @RequestParam(defaultValue = "kilometers") String units, Model model){
            model.addAttribute("city", city);
            model.addAttribute("units", units);
            return "weather";
        }
}
