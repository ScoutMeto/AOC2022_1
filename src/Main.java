import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //bags of food
        int bag1 = 1000;
        int bag2 = 2000;
        int bag3 = 3000;
        int bag4 = 4000;
        int bag5 = 5000;
        int bag6 = 6000;
        int bag7 = 7000;
        int bag8 = 8000;
        int bag9 = 9000;
        int bag10 = 10_000;

        //elves and bags of food/cal.
        int elf1 = bag1 + bag2 + bag3;
        int elf2 = bag4;
        int elf3 = bag5 + bag6;
        int elf4 = bag7 + bag8 + bag9;
        int elf5 = bag10;

        //ArrayList for sum
        List<Integer> elves = new ArrayList<>();
        elves.add(elf1);
        elves.add(elf2);
        elves.add(elf3);
        elves.add(elf4);
        elves.add(elf5);

        //summary of calories in all bags
        int sumBags = 0;
        for (int value : elves) {
            sumBags+=value;
        }

        //HasMap for bag with most cal.
        HashMap<String, Integer> elvesMap = new HashMap<>();
        elvesMap.put("elf1", elf1);
        elvesMap.put("elf2", elf2);
        elvesMap.put("elf3", elf3);
        elvesMap.put("elf4", elf4);
        elvesMap.put("elf5", elf5);

        //elf with bag which most calories included
        int maxValue = elvesMap.values().stream().max(Integer::compareTo).orElse(0);
        String maxBagElfName = elvesMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("N/A");


        //informations
        System.out.println("Součet: " + sumBags);
        System.out.println("Největší počet kalorií nese v baťůžku: " + maxBagElfName + " a to " + maxValue); //upravit
    }
}

/*
Vysvětlení kódu:

        int maxValue = elfValues.values().stream().max(Integer::compareTo).orElse(0);
        String maxElfName = elfValues.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("N/A");
___

elfValues.values().stream().max(Integer::compareTo).orElse(0):

elfValues.values(): Tato část vrátí kolekci hodnot uložených ve Map, tedy hodnoty, které jsou asociovány s klíči.
.stream(): Tímto se vytvoří proud (stream) hodnot, který umožňuje provádět různé operace nad těmito hodnotami.
.max(Integer::compareTo): Tato metoda max hledá maximální hodnotu v proudu. Integer::compareTo je komparátor, který je použit k porovnání dvou čísel (hodnot). Výsledkem této metody je Optional<Integer>, který obsahuje maximální hodnotu, nebo je prázdný, pokud je proud prázdný.
.orElse(0): Tato metoda vrátí hodnotu maximální hodnoty, pokud je přítomná, jinak vrátí hodnotu 0.
elfValues.entrySet().stream()...:

elfValues.entrySet(): Tato část vrátí kolekci Set obsahující všechny páry klíč-hodnota ve Map.
.stream(): Stejně jako v prvním případě se vytváří proud pro páry klíč-hodnota.
.filter(entry -> entry.getValue() == maxValue): Tato metoda filter filtruje páry podle zadané podmínky, zde se hledají páry, kde hodnota odpovídá maximální hodnotě (maxValue).
.map(Map.Entry::getKey): Metoda map transformuje každý prvek v proudu na jiný prvek, zde se převádějí páry klíč-hodnota na samotné klíče.
.findFirst(): Tato metoda najde první prvek v proudu, který splňuje podmínku. Výsledkem je Optional<String>, který obsahuje první klíč, nebo je prázdný, pokud žádný prvek nebyl nalezen.
.orElse("N/A"): Tato metoda vrátí první klíč, pokud je přítomný, jinak vrátí řetězec "N/A".
Celkově tyto metody umožňují využívat tzv. funkcionální programování a operace nad proudem dat.
 */
