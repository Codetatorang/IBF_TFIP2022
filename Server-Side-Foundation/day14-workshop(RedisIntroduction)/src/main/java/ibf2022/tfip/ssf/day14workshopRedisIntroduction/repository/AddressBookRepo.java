package ibf2022.tfip.ssf.day14workshopRedisIntroduction.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day14workshopRedisIntroduction.model.Contact;

@Repository
public class AddressBookRepo {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public void save(final Contact contact){
        System.out.println("contact id = " + contact.getId());
        redisTemplate.opsForList().leftPush("contactList", contact.getId());
        redisTemplate.opsForHash().put("addressbookmap", contact.getId(), contact);
    }

    public Contact findById(final String contactId){
        return (Contact)redisTemplate.opsForHash().get("addressbookmap", contactId);
    }

    public List<Contact> findAllContacts(int startIndex){
        List<Object> contactList = redisTemplate.opsForList().range("contactList", 
                startIndex, 10);
        List<Contact> ctcs = redisTemplate.opsForHash()
            .multiGet("addressbookmap", contactList)
            .stream()
            .filter(Contact.class::isInstance)
            .map(Contact.class::cast)
            .toList();

        return ctcs;
    }
}
