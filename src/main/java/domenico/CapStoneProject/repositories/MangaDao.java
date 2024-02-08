package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MangaDao extends JpaRepository<Manga, Long> {

    Manga findById(int id);
}
