package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/generatenumber")
public class NumberGeneratorController {

    
    @GetMapping
    public String numberGenerator() {
        return "numbergenerator";
    }
    
    @PostMapping("/postednumber")
    public String generateNumber(@RequestParam(name = "inputNumber", defaultValue = "1") Integer units, Model model){
        List<Integer> integerList = new ArrayList<>();
        Integer loopVal = units;
        Integer currentVal = 1;
        while (currentVal <= loopVal){
            int result = (int)(Math.random() * loopVal) + 1;

            if (!integerList.contains(result)) {
                integerList.add(result);
                currentVal+=1;
            }
        }

        model.addAttribute("numbers", integerList);
        return "generatedresult";
    }

}   
