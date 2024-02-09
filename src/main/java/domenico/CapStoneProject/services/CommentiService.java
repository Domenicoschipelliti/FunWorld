package domenico.CapStoneProject.services;

import com.cloudinary.utils.ObjectUtils;
import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.Commenti;
import domenico.CapStoneProject.exceptions.NotFound;
import domenico.CapStoneProject.payload.CommentiDto;
import domenico.CapStoneProject.repositories.CommentiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@Service
public class CommentiService {
    @Autowired
    private CommentiDao commentiDao;


    public List<Commenti> findAllComment(){
        return commentiDao.findAll();
    }


    public Commenti findByIdComment(long id){
        return commentiDao.findById(id).orElseThrow(()->new NotFound(id));
    }

    public Commenti saveComment(Commenti commenti){
       return commentiDao.save(commenti);
    }


    public Commenti postComment(CommentiDto commentiDto){

        Commenti commenti=new Commenti();
        commenti.setMessaggio(commentiDto.messaggio());

        return commentiDao.save(commenti);
    }

    public  Commenti patchComment(CommentiDto commentiDto, long idMessaggio)  {
       Commenti commenti=this.findByIdComment(idMessaggio);
       commenti.setMessaggio(commentiDto.messaggio());
       commentiDao.save(commenti);
       return commenti;
    }

    public void deleteComment(long idMessaggio){
        Commenti commenti=this.findByIdComment(idMessaggio);
        commentiDao.delete(commenti);
    }





}
