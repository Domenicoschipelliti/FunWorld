package domenico.CapStoneProject.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Anime {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private String immagine;
    private String trama;
    private String voto;



}
