package domenico.CapStoneProject.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.Commenti;
import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.enums.Role;
import domenico.CapStoneProject.exceptions.BadRequest;
import domenico.CapStoneProject.exceptions.NotFound;
import domenico.CapStoneProject.payload.AnimeDto;
import domenico.CapStoneProject.payload.UserDtoRegister;
import domenico.CapStoneProject.repositories.AnimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AnimeService {
    @Autowired
    private AnimeDao animeDao;

    @Autowired
    private Cloudinary cloudinary;

    public List<Anime> findAllAnime(){
        return animeDao.findAll();
    }

    public Anime findByAnimeId(long id){
       return animeDao.findById(id).orElseThrow(()->new NotFound(id));
    }

    public Anime saveAnime(Anime anime){
        return animeDao.save(anime);
    }


    public Anime findbyAnimeId(int id){
        Anime found=animeDao.findById(id);

        if (found!=null){
            return  found;
        }else {
            throw new NotFound(id);
        }
    }

    public Anime saveAnimePost(AnimeDto body){



        Anime newAnime=new Anime();

        newAnime.setTrama(body.trama());
        newAnime.setVoto(body.voto());
        newAnime.setTitolo(body.titolo());


        return animeDao.save(newAnime);
    }


    public void deleteAnime(Integer id){
        Anime anime=this.findbyAnimeId(id);
        animeDao.delete(anime);
    }



    public List<Anime> filterByTitle(String titolo){
        return animeDao.listAnimeRicerca(titolo);
    }

    //--------------------upload image----------\\


    public  String uploadImage(MultipartFile file, int id) throws IOException {
        Anime found = this.findbyAnimeId(id);
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setImmagine(url);
        animeDao.save(found);
        return url;
    }





}
