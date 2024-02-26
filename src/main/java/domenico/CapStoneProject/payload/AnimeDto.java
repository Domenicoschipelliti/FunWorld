package domenico.CapStoneProject.payload;

import jakarta.validation.constraints.NotEmpty;

public record AnimeDto(@NotEmpty(message = "questo campo serve per dare un titolo all'anime")String titolo,@NotEmpty(message = "la trama serve all'utente per capire di cosa tratta l'anime")String trama,@NotEmpty(message = "il voto non deve essere messo ma non vuoto")String voto,@NotEmpty(message = "metti una foto per capire che cosa tratta l'anime")String immagine) {
}
