package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Country;

@Repository
public class CountryRepo {
    private List<Country> countries;

    public List<Country> getAllCountries() {
        countries = new ArrayList<Country>();

        //populate the countries list
        Country country = new Country("SG", "Singapore", 6000000);
        countries.add(country);

        country = new Country("US", "USA", 160000000);
        countries.add(country);
        
        country = new Country("MY", "Malaysia", 23000000);
        countries.add(country);
        
        country = new Country("CN", "China", 1430000000);
        countries.add(country);

        return countries;
    }

    public boolean createCountry(Country country) {
        if (null == countries) {
            countries = new ArrayList<Country>();
        }
        countries.add(country);
        return true;
    }
}
