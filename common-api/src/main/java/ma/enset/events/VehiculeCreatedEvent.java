package ma.enset.events;

import lombok.Getter;

public class VehiculeCreatedEvent extends BaseEvent<String> {
    @Getter public String matricule;
    @Getter public String marque;
    @Getter public String modele;
    @Getter public int puissance;
    @Getter public String proprietaire;
    public VehiculeCreatedEvent(String id, String matricule, String marque, String modele, int puissance, String proprietaire) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.proprietaire = proprietaire;
    }
}
