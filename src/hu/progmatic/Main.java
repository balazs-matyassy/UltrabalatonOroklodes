package hu.progmatic;

import hu.progmatic.model.IndividualResult;
import hu.progmatic.model.Result;
import hu.progmatic.model.TeamResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Result> results = loadResult("ub2021kevert.txt");
            System.out.println("Elemek száma: " + results.size());

            // adatok feldolgozása

            // 1. feldolgozási lépés
            // Azoknak a versenyzőknek a kiválogatása,
            // akik teljesítették a távot.
            // Iterátor (egyik) előnye: bejárás közben tudunk törölni.
            // Hátrány: Nehézkesebb a for-each-hez képest.
            Iterator<Result> iterator = results.iterator();

            while (iterator.hasNext()) {
                // éppen bejárt érték lekérdezése
                Result result = iterator.next();

                if (result.getPercentage() != 100) {
                    iterator.remove();
                }
            }

            // 2. lépés kategóriánkénti összes idő másodpercben
            Map<String, Integer> totalTimeByCategory = new TreeMap<>();

            for (Result result : results) {
                // Ha még nem volt az adott kategóriához érték,
                // akkor null helyett 0-hoz szeretnénk új összeget hozzáadni,
                // nogy ne keletkezzen NullPointerException.
                int oldTotal = totalTimeByCategory.getOrDefault(result.getCategory(), 0);
                totalTimeByCategory.put(result.getCategory(), oldTotal + result.getTotalSeconds());
            }

            for (String category : totalTimeByCategory.keySet()) {
                System.out.println(category + ": " + totalTimeByCategory.get(category));
            }

            // nincs írás
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // factory metódus létrehozása
    // factory döntést hoz a konkrét osztály típusáról
    // pl. képesek leszünk kevert fájlokat feldolgozni
    private static Result createResult(String line) {
        String[] parts = line.split(";");

        if (parts.length > 5) {
            return new TeamResult(line);
        } else {
            return new IndividualResult(line);
        }
    }

    private static List<Result> loadResult(String path) throws IOException {
        List<Result> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            // nincs fejléc

            while ((line = reader.readLine()) != null) {
                Result result = createResult(line);
                results.add(result);
            }
        }

        return results;
    }
}
