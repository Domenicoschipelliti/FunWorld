package domenico.CapStoneProject.exceptions;

import domenico.CapStoneProject.payload.ErrorsPayload;
import domenico.CapStoneProject.payload.ErrorsPayloadList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayloadList badRequest(BadRequest e){
        List<String> errorsMessages=new ArrayList<>();
        if (e.getErrorList()!=null)
            errorsMessages=e.getErrorList().stream().map(err->err.getDefaultMessage()).toList();
        return  new ErrorsPayloadList(e.getMessage(),LocalDate.now(),errorsMessages);

    }


    @ExceptionHandler(Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorsPayload unathorized(Unauthorized e){
        return new ErrorsPayload(e.getMessage(),LocalDate.now());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorsPayload accessDenied(AccessDeniedException e){
        return  new ErrorsPayload("il ruolo non ti consente di accedere a atale sezione",LocalDate.now())
    }


    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ErrorsPayload notFound(NotFound e){
        return new ErrorsPayload(e.getMessage(),LocalDate.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ErrorsPayload internalServerError(Exception e){
        e.printStackTrace();
        return new ErrorsPayload("Problema del server il backEnder se ne prenderà cura il prima possibile",LocalDate.now());

    }




}
