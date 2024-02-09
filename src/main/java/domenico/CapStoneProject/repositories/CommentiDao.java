package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.Commenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentiDao extends JpaRepository<Commenti,Long> {
}
