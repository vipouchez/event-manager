package fr.ayoub.eventmanager.controller;

import fr.ayoub.eventmanager.entities.Event;
import fr.ayoub.eventmanager.entities.Theme;
import fr.ayoub.eventmanager.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/themeapi")
public class ThemeController {
    @Autowired
    ThemeService ts;

    @GetMapping("/all")
    public String getAll(Model m) {
        List<Theme> themes = ts.getAllThemes();
        m.addAttribute("themes", themes);

        return "themes";
    }
    @GetMapping("/addtheme")
    public String addTheme() {
        return "addtheme";
    }


    @PostMapping("savetheme")
    public String saveEvent(Theme t) {
        ts.addTheme(t);
        return ("redirect:/themeapi/all");
    }



    @PostMapping("deletetheme/{id}")
    public String deleteTheme(@PathVariable int id ){
        ts.deleteTheme(id);

        return ("redirect:/themeapi/all");
    }

}
