package fr.ayoub.eventmanager.dao;

import fr.ayoub.eventmanager.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme,Integer> {
}
