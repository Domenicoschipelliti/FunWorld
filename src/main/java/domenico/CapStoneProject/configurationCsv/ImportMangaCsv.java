package domenico.CapStoneProject.configurationCsv;

import domenico.CapStoneProject.enteties.Anime;
import domenico.CapStoneProject.enteties.Manga;
import domenico.CapStoneProject.services.MangaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportMangaCsv {
    private final MangaService mangaService;

    public ImportMangaCsv(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    public void importFromCsv(String file){
        try (FileReader reader = new FileReader(file);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                String titolo = record.get("titolo");
                String immagine = record.get("immagine");
                String trama = record.get("trama");
                String voto= record.get("voto");
                int id = Integer.parseInt(record.get("id"));




                Manga manga=new Manga();
                manga.setTitolo(titolo);
                manga.setVoto(voto);
                manga.setImmagine(immagine);
                manga.setTrama(trama);
                manga.setId(id);


                System.out.println(manga);

                mangaService.saveManga(manga);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
