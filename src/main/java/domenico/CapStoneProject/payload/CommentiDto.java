package domenico.CapStoneProject.payload;

import jakarta.validation.constraints.NotEmpty;

public record CommentiDto(@NotEmpty(message = "il commento non deve esssere scurrile")String messaggio) {
}
