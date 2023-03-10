package ma.enset.query.service;

import lombok.AllArgsConstructor;
import ma.enset.query.entities.Radar;
import ma.enset.events.RadarCreatedEvent;
import ma.enset.queries.FindAllRadars;
import ma.enset.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    @Transactional
    public void on(RadarCreatedEvent event){
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setMaxSpeed(event.getMaxSpeed());
        radarRepository.save(radar);
    }

    @QueryHandler
    public List<Radar> on(FindAllRadars query){
        return radarRepository.findAll();
    }
}
