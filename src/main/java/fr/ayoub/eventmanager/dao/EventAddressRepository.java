package fr.ayoub.eventmanager.dao;

import fr.ayoub.eventmanager.entities.EventAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAddressRepository extends JpaRepository<EventAddress,Integer> {

}
