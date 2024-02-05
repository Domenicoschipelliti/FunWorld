package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.exceptions.BadRequest;
import domenico.CapStoneProject.payload.UserDtoLogin;
import domenico.CapStoneProject.payload.UserDtoRegister;
import domenico.CapStoneProject.payload.UserResponseLogin;
import domenico.CapStoneProject.payload.UserResponseRegister;
import domenico.CapStoneProject.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    public UserResponseLogin login(@RequestBody UserDtoLogin body){
        String tokenAccess=securityService.userAuthentication(body);
        return new UserResponseLogin(tokenAccess);
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseRegister register(@RequestBody @Validated UserDtoRegister body, BindingResult validation){

        if (validation.hasErrors()){
            System.out.println(validation.hasErrors());
            throw new BadRequest(validation.getAllErrors());
        }else {
            User newUser=securityService.saveUser(body);
            return new UserResponseRegister(newUser.getUserId());
        }

    }

}
