package ibf2022.tfip.ssf.day14workshopRedisIntroduction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day14workshopRedisIntroduction.model.Contact;
import ibf2022.tfip.ssf.day14workshopRedisIntroduction.repository.AddressBookRepo;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepo addressBookRepo;

    public void save(final Contact contact){
        addressBookRepo.save(contact);
    }

    public Contact findById(final String contactId){
       return addressBookRepo.findById(contactId);
    }

    public List<Contact> findAllContacts(int startIndex){
        return addressBookRepo.findAllContacts(startIndex);
    }

}
