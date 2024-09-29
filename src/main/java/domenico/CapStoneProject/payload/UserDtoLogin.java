package domenico.CapStoneProject.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDtoLogin(@Email(message = "la mail non è corretta")String email, @NotEmpty(message = "la password non è corretta")String password) {

}
