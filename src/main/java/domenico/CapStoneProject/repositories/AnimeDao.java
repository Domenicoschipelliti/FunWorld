package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeDao extends JpaRepository<Anime,Long> {
    Anime findById(int id);

    @Query("SELECT a FROM Anime a WHERE a.titolo LIKE %:titolo%")
    List<Anime> listAnimeRicerca(@Param("titolo") String titolo);
}
