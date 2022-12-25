package ma.enset.commands.aggregates;

import ma.enset.commands.CreateProprCommand;
import ma.enset.events.ProprCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class ProprAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private Date dateOfBirth;
    private String email;

    public ProprAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public ProprAggregate(CreateProprCommand command) {
        if (command.getName() == null || command.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        AggregateLifecycle.apply(new ProprCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDateOfBirth(),
                command.getEmail()));
    }

    @EventSourcingHandler
    public void on(ProprCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.dateOfBirth = event.getDateOfBirth();
        this.email = event.getEmail();
    }
}
