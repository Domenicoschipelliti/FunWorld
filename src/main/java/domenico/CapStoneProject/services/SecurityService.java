package domenico.CapStoneProject.services;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.enums.Role;
import domenico.CapStoneProject.exceptions.BadRequest;
import domenico.CapStoneProject.exceptions.Unauthorized;
import domenico.CapStoneProject.payload.UserDtoLogin;
import domenico.CapStoneProject.payload.UserDtoRegister;
import domenico.CapStoneProject.repositories.UserDao;
import domenico.CapStoneProject.security.JWTclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private JWTclass jwTclass;

    @Autowired
    private UserDao userDao;
    @Autowired
    private  UserService userService;

   public String userAuthentication(UserDtoLogin body){
       User user=userService.findByEmail(body.email());
       if (bcrypt.matches(body.password(), user.getPassword())){
           return jwTclass.createToken(user);
       }else {
           throw new Unauthorized("Credenziali non valide");
       }
   }


   public User saveUser(UserDtoRegister body){

       userDao.findByEmail(body.email()).ifPresent(user->{
           throw  new BadRequest("email "+ user.getEmail()+" già in uso");
       });
       userDao.findByUsername(body.username()).ifPresent(username->{
           throw new BadRequest("Lo username "+username.getUsername()+" è già in uso");
       });

       User newUser=new User();

       newUser.setNome(body.nome());
       newUser.setCognome(body.cognome());
       newUser.setEmail(body.email());
       newUser.setUsername(body.username());
       newUser.setPassword(bcrypt.encode(body.password()));
       newUser.setRole(Role.USER);
       return userDao.save(newUser);
   }







}
