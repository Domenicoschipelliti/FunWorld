package domenico.CapStoneProject.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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

}
