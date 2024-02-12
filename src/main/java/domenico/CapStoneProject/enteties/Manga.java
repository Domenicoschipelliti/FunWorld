package domenico.CapStoneProject.enteties;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @ManyToMany
    @JoinTable(
            name = "manga_user",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId")

    )
    private List<User> user;


}
