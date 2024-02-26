package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MangaDao extends JpaRepository<Manga, Long> {

    Manga findById(int id);
    @Query("SELECT m FROM Manga m WHERE m.titolo LIKE %:titolo%")
    List<Manga> findByTitleManga(@Param("titolo")String titolo);
}
