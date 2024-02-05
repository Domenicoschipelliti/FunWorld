package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeDao extends JpaRepository<Anime,Long> {
    Anime findById(long id);
}
