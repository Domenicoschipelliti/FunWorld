package domenico.CapStoneProject.configurationCsv;

import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.services.AnimeService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportCSV {
    private final AnimeService animeService;

    @Autowired
    public ImportCSV(AnimeService animeService){
        this.animeService=animeService;
    }

    public void importAnimeFromCsv(String file){
        try (FileReader reader = new FileReader(file);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                String titolo = record.get("titolo");
                String immagine = record.get("immagine");
                String trama = record.get("trama");
                String voto= record.get("voto");
                int id = Integer.parseInt(record.get("id"));


                Anime anime = new Anime();
                anime.setTitolo(titolo);
                anime.setImmagine(immagine);
                anime.setVoto(voto);
                anime.setTrama(trama);
                anime.setId(id);


                System.out.println(anime);
                animeService.saveAnime(anime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
