package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<User> getUsers(int size,int page,String order){
       return userService.findAll(size,page,order);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User getUsersId(@PathVariable UUID userId){
      return  userService.findById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User putUsersIdBody(@PathVariable UUID userId,@RequestBody User body){
        return  userService.userUpdate(userId,body);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void  deleteUserId(@PathVariable UUID userId){
       userService.userDelete(userId);
    }


    //---------------/me------------\\

    @GetMapping("/me")
    public  User pageUser(@AuthenticationPrincipal User utente){
      return  utente;
    }

    @PutMapping("/me")
    public  User putPageUser(@AuthenticationPrincipal User userId,@RequestBody User body){
        return  userService.userUpdate(userId.getUserId(),body);
    }



    @DeleteMapping("/me")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteUserPage(@AuthenticationPrincipal User userId){
       userService.userDelete(userId.getUserId());
    }









}
