package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Country;
import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    public CountryController(){
        countryService = new CountryService();
    }

    @GetMapping
    public @ResponseBody List<Country> getAllCountries() {
        return countryService.retrieveCountryList();
    }

    @PostMapping
    public @ResponseBody Boolean createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @GetMapping("/list")
    public String displayCountries(Model model){
        List<Country> countryList = countryService.retrieveCountryList();
        model.addAttribute("countries", countryList);
        return "country";
    }
}
