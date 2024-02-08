package domenico.CapStoneProject.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manga {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private String trama;
    private String voto;
    private String immagine;


}
