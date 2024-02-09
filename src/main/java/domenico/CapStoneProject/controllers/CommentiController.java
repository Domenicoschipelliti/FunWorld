package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.Commenti;
import domenico.CapStoneProject.payload.CommentiDto;
import domenico.CapStoneProject.services.CommentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commenti")
public class CommentiController {

    @Autowired
    private CommentiService commentiService;

    @GetMapping
    public List<Commenti> findAllComment(){
        return commentiService.findAllComment();
    }

    @GetMapping("/{idMessaggio}")
    public Commenti findByIdComment(@PathVariable long idMessaggio){
        return commentiService.findByIdComment(idMessaggio);
    }

    @PostMapping
    public Commenti postComment(@RequestBody CommentiDto commentiDto){
        return commentiService.postComment(commentiDto);
    }


    @PatchMapping("/{idMessaggio}")
    public Commenti patchComment(@PathVariable long idMessaggio,@RequestBody CommentiDto body){
        return commentiService.patchComment(body,idMessaggio);
    }

    @DeleteMapping("/{idMessaggio}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCommente(@PathVariable long idMessaggio){
        commentiService.deleteComment(idMessaggio);
    }

}
