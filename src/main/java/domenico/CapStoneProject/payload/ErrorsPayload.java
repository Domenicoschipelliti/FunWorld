package domenico.CapStoneProject.payload;

import java.time.LocalDate;

public record ErrorsPayload(String message, LocalDate time) {
}
