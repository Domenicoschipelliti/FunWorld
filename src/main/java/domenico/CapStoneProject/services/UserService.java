package domenico.CapStoneProject.services;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.exceptions.NotFound;
import domenico.CapStoneProject.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Page<User> findAll(int size,int page,String order){
        Pageable pageable= PageRequest.of(size,page, Sort.by(order));
        return  userDao.findAll(pageable);
    }

    public  User findById(UUID userId){
        return userDao.findById(userId).orElseThrow(()->new NotFound(userId));
    }


    public  User userUpdate(UUID userId,User body){
        User update=this.findById(userId);
        update.setNome(body.getNome());
        update.setCognome(body.getCognome());
        update.setUsername(body.getUsername());
        update.setEmail(body.getEmail());
        update.setPassword(body.getPassword());
        update.setRole(body.getRole());
        return userDao.save(update);

    }

    public void   userDelete(UUID userId){
        User delete=this.findById(userId);
        userDao.delete(delete);
    }

    public  User findByEmail(String email){
        return  userDao.findByEmail(email).orElseThrow(()->new NotFound("l'utente con questa mail non è stato trovato"));

    }


}
