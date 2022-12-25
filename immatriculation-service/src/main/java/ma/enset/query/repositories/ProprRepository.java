package ma.enset.query.repositories;

import ma.enset.query.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprRepository extends JpaRepository<Proprietaire, String> {
}
