package domenico.CapStoneProject.controllers;

import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.payload.AnimeDto;
import domenico.CapStoneProject.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/anime")
public class AnimeController {

   @Autowired
   private AnimeService animeService;

   @GetMapping
   public List<Anime> findallAnime(){
       return animeService.findAllAnime();
   }

   @GetMapping("/{id}")
   public Anime findByIdAnime(@PathVariable long id){
      return animeService.findByAnimeId(id);
   }


   @GetMapping("/titolo")
   public List<Anime> filterByTitle(@RequestParam(name = "titolo")String titolo){
      return animeService.filterByTitle(titolo);
   }

   @PostMapping
   //@PreAuthorize("hasAuthority('ADMIN')")
   @ResponseStatus(HttpStatus.CREATED)
   public Anime newAnime(@RequestBody AnimeDto anime){
     return animeService.saveAnimePost(anime);
   }

   @PutMapping("/{id}")
   @PreAuthorize("hasAuthority('ADMIN')")
   public Anime putAnimeIdBody(@PathVariable long id, @RequestBody Anime body){
      return  animeService.animeUpdate(id, body);
   }

   @DeleteMapping("/{id}")
   //@PreAuthorize("hasAuthority('ADMIN')")
   public void deleteAnime(@PathVariable int id){
      animeService.deleteAnime(id);
   }

   //------------------upload immagini--------------\\


   @PatchMapping("/{id}/upload")
   @ResponseStatus(HttpStatus.CREATED)
   //@PreAuthorize("hasAuthority('ADMIN')")
   public String uploadImg(@RequestParam("image") MultipartFile file, @PathVariable int id) throws Exception {
      return animeService.uploadImage(file,id);
   }


}
