package domenico.CapStoneProject.configurationCsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerCSV implements CommandLineRunner {

    private final  ImportCSV importCSV;

    @Autowired
    public  RunnerCSV(ImportCSV importCSV){
        this.importCSV=importCSV;
    }
    @Override
    public void run(String... args) throws Exception {
      String animeFile="./csv/anime.csv";
      importCSV.importAnimeFromCsv(animeFile);
    }
}
