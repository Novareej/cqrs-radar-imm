package ma.enset.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Radar {
    @Id
    private String id;
    private double maxSpeed;
    private double latitude;
    private double longitude;
}