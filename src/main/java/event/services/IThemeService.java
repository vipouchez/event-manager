package event.services;

import event.entities.Event;
import event.entities.Theme;

import java.util.List;

public interface IThemeService {
    void addTheme(Theme t);
    List<Theme> getAllThemes();
    List<Event> getEventByTheme(int idc);
    void deleteTheme(int id);
    void getTheme(int id);


}

