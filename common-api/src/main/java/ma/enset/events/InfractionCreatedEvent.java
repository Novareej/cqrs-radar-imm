package ma.enset.events;

import lombok.Getter;

import java.util.Date;

public class InfractionCreatedEvent extends BaseEvent<String> {
    @Getter
    private Date date;

    @Getter
    private double viresse;

    @Getter
    private double montant;

    @Getter
    private String vehiculeId;

    @Getter
    private String radarId;

    public InfractionCreatedEvent(String id, Date date, double viresse, double montant, String vehiculeId, String radarId) {
        super(id);
        this.date = date;
        this.viresse = viresse;
        this.montant = montant;
        this.vehiculeId = vehiculeId;
        this.radarId = radarId;
    }
}