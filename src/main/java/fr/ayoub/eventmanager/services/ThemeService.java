package fr.ayoub.eventmanager.services;

import fr.ayoub.eventmanager.dao.ThemeRepository;
import fr.ayoub.eventmanager.entities.Event;
import fr.ayoub.eventmanager.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeService implements IThemeService{
    @Autowired
    ThemeRepository tr;
    @Override
    public void addTheme(Theme t) {
        tr.save(t);
    }

    @Override
    public List<Theme> getAllThemes() {
        return tr.findAll();
    }

    @Override
    public List<Event> getEventByTheme(int idc) {
        return tr.findById(idc).get().getEvents();
    }

    @Override
    public void deleteTheme(int id) {
        tr.deleteById(id);
    }

    @Override
    public void getTheme(int id) {
        tr.findById(id).get();
    }
}
