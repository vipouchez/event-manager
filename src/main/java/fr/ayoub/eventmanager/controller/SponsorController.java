package fr.ayoub.eventmanager.controller;

import fr.ayoub.eventmanager.dto.SponsorDto;
import fr.ayoub.eventmanager.entities.Sponsor;
import fr.ayoub.eventmanager.entities.Theme;
import fr.ayoub.eventmanager.services.EventService;
import fr.ayoub.eventmanager.services.SponsorService;
import fr.ayoub.eventmanager.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sponsorapi")
public class SponsorController {
    @Autowired
    SponsorService ss;
    @Autowired
    EventService es ;

    @GetMapping("/all")
    public String getAll(Model m) {
        List<Sponsor> allSponsors = ss.getAllSponsors();
        m.addAttribute("sponsorlist",allSponsors);
        return "sponsors";
    }
    @GetMapping("/addsponsor")
    public String addSponsor(Model m) {
        m.addAttribute("listEvent", es.getAllEvents());
        return "addsponsor";
    }

    @PostMapping("savesponsor")
    public String saveSponsor(Sponsor s) {
        ss.addSponsor(s);

        return ("redirect:/sponsorapi/all");
    }

    @PostMapping("deletesponsor/{id}")
    public String deleteSponsor(@PathVariable int id ){
        ss.deleteSponsor(id);

        return ("redirect:/sponsorapi/all");
    }

}
