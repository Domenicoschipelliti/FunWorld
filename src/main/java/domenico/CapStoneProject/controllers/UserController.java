package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "userId") String order){
       return userService.findAll(page,size,order);
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


   //----------------user uplaod avatar

    @PatchMapping("/{userId}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uploadAvatarImg(@RequestParam("image") MultipartFile file, @PathVariable UUID userId) throws Exception {
        return userService.uploadImageAvatar(file,userId);
    }








}
