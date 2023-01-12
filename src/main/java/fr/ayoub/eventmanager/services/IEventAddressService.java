package fr.ayoub.eventmanager.services;

import fr.ayoub.eventmanager.entities.EventAddress;
import org.apache.tomcat.jni.Address;

public interface IEventAddressService {

    void deleteAddress(int id);
    void addAddress(EventAddress a);
    void getAddress(int id);

}
