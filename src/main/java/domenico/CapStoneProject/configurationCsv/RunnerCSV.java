package domenico.CapStoneProject.configurationCsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerCSV implements CommandLineRunner {

    private final  ImportCSV importCSV;
    private final ImportMangaCsv importMangaCsv;

    @Autowired
    public  RunnerCSV(ImportCSV importCSV,ImportMangaCsv importMangaCsv){
        this.importCSV=importCSV;
        this.importMangaCsv=importMangaCsv;
    }
    @Override
    public void run(String... args) throws Exception {
        String animeFile="./csv/anime.csv";
        String mangaFile="./csv/manga.csv";
        //--------------------------------;
        importCSV.importFromCsv(animeFile);
        importMangaCsv.importFromCsv(mangaFile);
    }
}
