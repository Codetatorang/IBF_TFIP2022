package ibf2022.tfip.paf.day22workshopSQLSearch.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.paf.day22workshopSQLSearch.model.RSVP;

@Repository
public class RSVPRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String findAllSQL = "select * from rsvp";
    private static final String findByNameSQL = "SELECT * FROM rsvp WHERE name LIKE ?";
    private static final String insertIntoSQL = """
        insert into rsvp (name, email, phone, confirmation_date, comments)
        values (?,?,?,?,?);
        """;
    private static final String updateSQLById = """
        update rsvp 
        set name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? 
        where id = ?
        """;

    public List<RSVP> getAllRSVP(){
        return jdbcTemplate.query(findAllSQL, BeanPropertyRowMapper.newInstance(RSVP.class));
    }

    public List<RSVP> getRSVPByName(String name){
        return jdbcTemplate.query(findByNameSQL, BeanPropertyRowMapper.newInstance(RSVP.class), "%" + name + "%");
    }

    public Boolean saveRSVP(RSVP rsvp){
        Integer result =  jdbcTemplate.update(insertIntoSQL, rsvp.getName(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmationDate(), rsvp.getText());

        return result > 0 ? true:false;
    }

    public Boolean updateRSVP(RSVP rsvp){
        Integer result = jdbcTemplate.update(updateSQLById, rsvp.getName(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmationDate(), rsvp.getText(), rsvp.getId());

        return result > 0 ? true:false;
    }
}
