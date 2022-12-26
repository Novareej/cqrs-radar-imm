package ma.enset.commands.aggregates;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ma.enset.commands.CreateInfractionCommand;
import ma.enset.events.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class InfractionAggregate {


    @Getter
    @AggregateIdentifier
    private String id;

    @Getter
    private Date date;

    @Getter
    private double vitesse;

    @Getter
    private double montant;
    @Getter
    private String vehiculeId;

    @Getter
    private String radarId;

    public InfractionAggregate() {
    }

    String AggregateIdentifier() {
        return "Agg-" + this.id;
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        /*TODO: validations*/
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(), command.getDate(), command.getVitesse(), command.getMontant(), command.getVehiculeId(), command.getRadarId()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.date = event.getDate();
        this.montant = event.getMontant();
        this.vitesse = event.getViresse();
        this.radarId = event.getRadarId();
        this.vehiculeId = event.getVehiculeId();
    }
}
