package ma.enset.commands.aggregates;

import lombok.Getter;
import ma.enset.commands.CreateRadarCommand;
import ma.enset.events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class    RadarAggregate {
    @AggregateIdentifier
    @Getter private String radarId;
    @Getter private double maxSpeed;
    @Getter private double latitude;
    @Getter private double longitude;

    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command){
        if (command.maxSpeed < 0) {
            throw new IllegalArgumentException("Max Speed cannot be negative");
        }
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLatitude(),
                command.getLongitude()));
    }

    @EventSourcingHandler //change the state of the aggregate
    public void on(RadarCreatedEvent event){
        this.radarId = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
    }
}
