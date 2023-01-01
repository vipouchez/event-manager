package fr.ayoub.eventmanager.services;


import fr.ayoub.eventmanager.entities.Event;
import fr.ayoub.eventmanager.entities.Theme;

import java.util.List;

public interface IThemeService {
    void addTheme(Theme t);
    List<Theme> getAllThemes();
    List<Event> getEventByTheme(int idc);
    void deleteTheme(int id);
    void getTheme(int id);


}

