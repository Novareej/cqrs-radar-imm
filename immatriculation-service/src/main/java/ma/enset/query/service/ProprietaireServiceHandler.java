package ma.enset.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.events.ProprCreatedEvent;
import ma.enset.queries.GetAllPropr;
import ma.enset.queries.GetPropr;
import ma.enset.query.entities.Proprietaire;
import ma.enset.query.repositories.ProprRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ProprietaireServiceHandler {
    private ProprRepository ownerRepository;

    @EventHandler
    @Transactional
    public void on(ProprCreatedEvent event) {
        log.info("Proprietaire CreatedEvent: {}", event);
        Proprietaire owner = new Proprietaire();
        owner.setId(event.getId());
        owner.setName(event.getName());
        owner.setDateOfBirth(event.getDateOfBirth());
        owner.setEmail(event.getEmail());
        ownerRepository.save(owner);
    }

    @QueryHandler
    public List<Proprietaire> on(GetAllPropr query) {
        return ownerRepository.findAll();
    }


    @QueryHandler
    public Proprietaire on(GetPropr query) {
        return ownerRepository.findById(query.getId()).get();
    }
}
