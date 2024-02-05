package domenico.CapStoneProject.services;

import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.exceptions.NotFound;
import domenico.CapStoneProject.repositories.AnimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    @Autowired
    private AnimeDao animeDao;

    public List<Anime> findAllAnime(){
        return animeDao.findAll();
    }

    public Anime findByAnimeId(long id){
       return animeDao.findById(id);
    }

    public Anime saveAnime(Anime anime){
        return animeDao.save(anime);
    }


    public Anime findbyAnimeId(long id){
        Anime found=animeDao.findById(id);

        if (found!=null){
            return  found;
        }else {
            throw new NotFound(id);
        }
    }





}
