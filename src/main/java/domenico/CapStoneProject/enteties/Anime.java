package domenico.CapStoneProject.enteties;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
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
    @ManyToMany
    @JoinTable(
            name = "anime_user",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId")

    )
    private List<User> user;



}
