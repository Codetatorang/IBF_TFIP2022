package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Country;
import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.repository.CountryRepo;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    public CountryService() {
        countryRepo = new CountryRepo();
    }

    public List<Country> retrieveCountryList() {
        return countryRepo.getAllCountries();
    }   

    public Boolean createCountry(Country country){
        return countryRepo.createCountry(country);
    }
}
