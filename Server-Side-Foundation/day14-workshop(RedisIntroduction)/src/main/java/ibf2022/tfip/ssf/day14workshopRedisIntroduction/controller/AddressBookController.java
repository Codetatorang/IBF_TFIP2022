package ibf2022.tfip.ssf.day14workshopRedisIntroduction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.tfip.ssf.day14workshopRedisIntroduction.model.Contact;
import ibf2022.tfip.ssf.day14workshopRedisIntroduction.service.AddressBookService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    Logger logger = LoggerFactory.getLogger(AddressBookController.class);

    @GetMapping("/")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contactForm";
    }
    @PostMapping("/contact")
    public String saveContact(@Valid Contact contact, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            return "contactForm";
        }
        addressBookService.save(contact);
        model.addAttribute("contact", contact);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return "contact";
    }

    @GetMapping("/contact")
    public String getAllContact(Model model, @RequestParam Integer startIndex) {
        List<Contact> contactList = addressBookService.findAllContacts(startIndex);
        logger.info("contact list size : %d".formatted(contactList.size()));
        model.addAttribute("contacts", contactList);
        return "listContacts";
    }

    @GetMapping("/contact/{contactId}")
    public String getContactDetails(Model model, @PathVariable String contactId){
        Contact contact = addressBookService.findById(contactId);
        model.addAttribute("contact", contact);
        return "contact";
    }
}
