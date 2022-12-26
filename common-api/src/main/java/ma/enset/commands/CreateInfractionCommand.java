package ma.enset.commands;


import lombok.Getter;

import java.util.Date;

public class CreateInfractionCommand extends BaseCommand<String> {
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

    public CreateInfractionCommand(String commandId, Date date, double viresse, double montant, String vehiculeId, String radarId) {
        super(commandId);
        this.date = date;
        this.vitesse = vitesse;
        this.montant = montant;
        this.vehiculeId = vehiculeId;
        this.radarId = radarId;
    }
}
