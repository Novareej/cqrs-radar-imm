package ma.enset.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.events.VehiculeCreatedEvent;
import ma.enset.queries.GetVehicule;
import ma.enset.queries.GetVehicules;
import ma.enset.query.entities.Proprietaire;
import ma.enset.query.entities.Vehicule;
import ma.enset.query.repositories.ProprRepository;
import ma.enset.query.repositories.VehiculeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class VehiculeServiceHandler {
    private VehiculeRepository vehiculeRepository;
    private ProprRepository proprRepository;

    @EventHandler
    @Transactional
    public void on(VehiculeCreatedEvent event) {
        log.info("VehiculeCreatedEvent: {}", event);
        Proprietaire owner = proprRepository.findById(event.getProprietaire()).get();
        Vehicule vehicule = new Vehicule();
        vehicule.setId(event.getId());
        vehicule.setMatricule(event.getMatricule());
        vehicule.setMarque(event.getMarque());
        vehicule.setModele(event.getModele());
        vehicule.setPuissance(event.getPuissance());
        vehicule.setOwner(owner);
        vehicule.setProprietaireId(owner.getId());
        vehiculeRepository.save(vehicule);
    }


    @QueryHandler
    public List<Vehicule> on(GetVehicules query) {
        return vehiculeRepository.findAll();
    }

    @QueryHandler
    public Vehicule on(GetVehicule query) {
        return vehiculeRepository.findById(query.getId()).get();
    }


}
