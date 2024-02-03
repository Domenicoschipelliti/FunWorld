package domenico.CapStoneProject.payload;

import java.time.LocalDate;
import java.util.List;

public record ErrorsPayloadList(String message, LocalDate time, List<String> errorsList){
}
