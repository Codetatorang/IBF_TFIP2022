package ibf2022.tfip.ssf.day11workshop.RandomImageGenerator.controller;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/","/index.html"}, produces = MediaType.TEXT_HTML_VALUE)
public class ImageController {
    Logger logger  = Logger.getLogger(ImageController.class.getName());

    @GetMapping
    public String getRandomNumber(Model model) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(31);
        logger.log(Level.INFO, "image index: %d".formatted(randomNumber));
        model.addAttribute("randomNumber", randomNumber);
        return "index";
    }
}
