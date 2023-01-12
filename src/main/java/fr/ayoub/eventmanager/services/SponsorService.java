package fr.ayoub.eventmanager.services;

import fr.ayoub.eventmanager.dao.SponsorRepository;
import fr.ayoub.eventmanager.dto.SponsorDto;
import fr.ayoub.eventmanager.entities.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService implements ISponsorService {
    @Autowired
    SponsorRepository sr;

    @Override
    public void addSponsor(Sponsor s) {
        sr.save(s);
    }

    @Override
    public List<Sponsor> getAllSponsors() {

        return sr.findAll();
    }

    @Override
    public void deleteSponsor(int id) {
        sr.deleteById(id);
    }

    @Override
    public void getSponsor(Integer id) {
        sr.getById(id);

    }
}
