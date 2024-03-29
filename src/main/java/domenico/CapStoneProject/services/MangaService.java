package domenico.CapStoneProject.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.Manga;
import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.exceptions.NotFound;
import domenico.CapStoneProject.payload.MangaDto;
import domenico.CapStoneProject.repositories.MangaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class MangaService {
    @Autowired
    private MangaDao mangaDao;
    @Autowired
    private Cloudinary cloudinary;



    public Page<Manga> findAllMangaList(int page,int size,String order){
        Pageable pageable= PageRequest.of(page,size, Sort.by(order));
        return mangaDao.findAll(pageable);
    }

    public List<Manga> findAllManga() {
        return mangaDao.findAll();
    }

    public Manga findByIdManga(long id) {
        return mangaDao.findById(id).orElseThrow(()->new NotFound(id));
    }


    public Manga saveManga(Manga manga){
        return  mangaDao.save(manga);
    }


    public Manga saveMangaDto(MangaDto mangaDto){
        Manga manga=new Manga();

        manga.setTitolo(mangaDto.titolo());
        manga.setTrama(mangaDto.trama());
        manga.setVoto(mangaDto.voto());


       return mangaDao.save(manga);
    }

    public Manga findByIdIntManga(int id) {
        Manga manga = mangaDao.findById(id);
        if (manga != null) {
            return manga;
        } else {
            throw new NotFound(id);
        }

    }

    public  Manga mangaUpdate(long id,Manga body){
        Manga update=this.findByIdManga(id);
        update.setTitolo(body.getTitolo());
        update.setVoto(body.getVoto());
        update.setTrama(body.getTrama());
        update.setImmagine(body.getImmagine());
        return mangaDao.save(update);

    }


    public void  deleteManga(Long id){
        Manga manga=this.findByIdManga(id);
        mangaDao.delete(manga);
    }

  //---------------------QUERIES-------------\\


    public List<Manga> filterByTitleManga(String titolo){
        return mangaDao.findByTitleManga(titolo);
    }


    //--------------------------Upload-------------------\\


    public  String uploadImageManga(MultipartFile file, int id) throws IOException {
        Manga found = this.findByIdIntManga(id);
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setImmagine(url);
        mangaDao.save(found);
        return url;
    }

}





