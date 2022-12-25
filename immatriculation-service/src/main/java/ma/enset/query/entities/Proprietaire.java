package ma.enset.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Proprietaire {
    @Id
    private String id;
    private String name;
    private Date dateOfBirth;
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Vehicule> vehicules;

}
