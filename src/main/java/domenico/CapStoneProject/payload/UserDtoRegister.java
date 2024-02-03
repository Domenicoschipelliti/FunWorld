package domenico.CapStoneProject.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;



public record UserDtoRegister(@NotEmpty(message = "bisogna sempre compilare questa sezione")String nome, @NotEmpty(message = "bisogna sempre compilare questa sezione")String cognome, @NotEmpty(message = "bisogna sempre compilare questa sezione")String username, @Email(message = "l'email messa non è valida")String email,@NotEmpty(message = "la password non è corretta")String password) {
}
