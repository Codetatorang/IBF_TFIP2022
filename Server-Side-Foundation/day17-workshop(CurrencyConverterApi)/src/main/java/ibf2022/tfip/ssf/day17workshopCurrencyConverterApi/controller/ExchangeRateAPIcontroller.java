package ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.model.Currency;
import ibf2022.tfip.ssf.day17workshopCurrencyConverterApi.service.ExchangeRateApiService;

@Controller
@RequestMapping(path = "/pair")
public class ExchangeRateAPIcontroller {
    // Logger logger = LoggerFactory.getLogger(ExchangeRateAPIcontroller.class);

    @Autowired
    private ExchangeRateApiService exchangeRateApiSvc;

    @GetMapping
    public String resultsPage(@RequestParam String baseCode,
            @RequestParam String targetCode, Model model) {
        Optional<Currency> currOpt = exchangeRateApiSvc.getConversion(baseCode,
                targetCode);
        model.addAttribute("curr", currOpt.get());
        return "resultspage";
    }

}
