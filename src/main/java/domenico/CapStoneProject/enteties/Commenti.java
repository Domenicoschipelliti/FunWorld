package domenico.CapStoneProject.enteties;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commenti {
    @Id
    @GeneratedValue
    private long idMessaggio;
    private String messaggio;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "comment_user",
            joinColumns = @JoinColumn(name = "idMessaggio"),
            inverseJoinColumns = @JoinColumn(name = "userId")

    )
    private List<User> user;

}
