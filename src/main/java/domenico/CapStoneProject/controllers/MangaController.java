package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.Manga;
import domenico.CapStoneProject.payload.AnimeDto;
import domenico.CapStoneProject.payload.MangaDto;
import domenico.CapStoneProject.services.MangaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manga")
public class MangaController {
    @Autowired
    private MangaService mangaService;

    @GetMapping
    public List<Manga> findAllManga(){
        return mangaService.findAllManga();
    }

    @GetMapping("/{id}")
    public Manga findByIdManga(@PathVariable long id){
        return mangaService.findByIdManga(id);

    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Manga newManga(@RequestBody MangaDto mangaDto){
        return mangaService.saveMangaDto(mangaDto);
    }



}
