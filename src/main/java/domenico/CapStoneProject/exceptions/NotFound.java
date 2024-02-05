package domenico.CapStoneProject.exceptions;

import lombok.Getter;

import java.util.UUID;
@Getter
public class NotFound extends RuntimeException{
    public NotFound(UUID id){
        super("l'id: "+id+" non è stato trovato");
    }
    public NotFound(long id){
        super("l'id: "+id+" non è stato trovato");
    }
    public  NotFound(String message){
        super(message);
    }
}
