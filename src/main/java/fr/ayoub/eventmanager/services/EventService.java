package fr.ayoub.eventmanager.services;
import fr.ayoub.eventmanager.dao.EventRepository;
import fr.ayoub.eventmanager.dao.ThemeRepository;
import fr.ayoub.eventmanager.dto.EventDto;
import fr.ayoub.eventmanager.entities.Event;
import fr.ayoub.eventmanager.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService{
    @Autowired
    EventRepository er ;

    @Autowired
    ThemeRepository tr;

    @Override
    public void saveProduct(Event e, MultipartFile mf) throws IOException {
        if(!mf.getOriginalFilename().isEmpty()){
            String filePathOnServer = saveImage(mf);
            e.setPicture(filePathOnServer);
        }

        er.save(e);
    }

    public void update (EventDto e){
        Optional<Event> eventOptional = er.findById(e.getId());
        if(eventOptional.isEmpty()){
            throw new EntityNotFoundException("No entity found with id : " + e.getId());
        }

        Event event = eventOptional.get();
        event.setName(e.getName());
        event.setAnimator(e.getAnimator());
        event.setPrice(e.getPrice());

        Optional<Theme> themeOptional = tr.findById(e.getThemeId());
        if(themeOptional.isEmpty()){
            throw new EntityNotFoundException("No entity found with id : " + e.getThemeId());
        }
        Theme theme = themeOptional.get();
        event.setTheme(theme);

        er.save(event);
    }


    @Override
    public List<Event> getAllEvents() {
        return er.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return er.findById(id).get();
    }

    @Override
    public List<Event> searchByName(String mc) {
        return er.searchByKW(mc);
    }

    @Override
    public void deleteEvent(int id) {
        er.deleteById(id);
    }

    @Override
    public String saveImage(MultipartFile mf) throws IOException {
        String nameFile = mf.getOriginalFilename();
        String tab[] =nameFile.split("\\.");
        String fileModif=tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
        String chemin =System.getProperty("user.home")+"/images2022/";
        Path p = Paths.get(chemin,fileModif);
        Files.write(p,mf.getBytes());
        return fileModif;
    }



    @Override
    public byte[] getImage(int id) throws IOException {
        String nomImage=er.findById(id).get().getPicture();
        Path p = Paths.get(System.getProperty("user.home")+"/images2022/",nomImage);
        return Files.readAllBytes(p);
    }



}
