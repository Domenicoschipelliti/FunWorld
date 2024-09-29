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


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


}
