package fr.ayoub.eventmanager.services;

import fr.ayoub.eventmanager.entities.Event;
import fr.ayoub.eventmanager.entities.Sponsor;
import fr.ayoub.eventmanager.entities.Theme;

import java.util.List;

public interface ISponsorService {
    void addSponsor(Sponsor s);
    List<Sponsor> getAllSponsors();
    void deleteSponsor(int id);
    void getSponsor(Integer id);
}
