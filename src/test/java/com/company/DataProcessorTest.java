package com.company;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    DataProcessor<ArtUnit> ArtUnitStream = new DataProcessor<>();

    @org.junit.jupiter.api.Test
    void processing() throws MyException {
        List<ArtUnit> ArtUnits = new ArrayList<>();
        ArtUnits.add(new Film("Bloodshot", 3, 1));
        ArtUnits.add(new Film("Venom", 6, 4));
        ArtUnits.add(new Film("Spider-Man", 7, 2));
        ArtUnits.add(new Film("Venom 2", 6, 4));
        ArtUnits.add(new Film("Sonic", 1, 8));
        ArtUnits.add(new Serial("Naruto", 4, 1));
        ArtUnits.add(new Serial("Boruto", 3, 8));
        ArtUnits.add(new Serial("Attack on Titan", 8, 9));
        ArtUnits.add(new Serial("Bakugan", 5, 17));
        ArtUnits.add(new Serial("Brigada", 5, 9));

        ArtUnitStream.setList(ArtUnits);

        List<ArtUnit> processed = new ArrayList<>(ArtUnitStream.processing(3, 3));

        List<ArtUnit> expected = new ArrayList<>();
        expected.add(ArtUnits.get(1));
        expected.add(ArtUnits.get(7));
//        expected.add(new Film("Bloodshot", 3, 1));
//        expected.add(new Serial("Boruto", 3, 8));
        assertEquals(expected, processed);
        assertThrows(MyException.class, () -> {
            ArtUnitStream.processing(15, 10);
        });
    }

    @org.junit.jupiter.api.Test
    void matching() {
        List<ArtUnit> ArtUnits = new ArrayList<>();
        StringBuilder matchedList = new StringBuilder();
        String expected = "";
        ArtUnits.add(new Film("Bloodshot", 3, 1));
        ArtUnits.add(new Film("Venom", 6, 4));
        ArtUnits.add(new Film("Spider-Man", 7, 2));
        ArtUnits.add(new Film("Venom 2", 6, 4));
        ArtUnits.add(new Film("Sonic", 1, 8));
        ArtUnits.add(new Serial("Naruto", 4, 1));
        ArtUnits.add(new Serial("Boruto", 3, 8));
        ArtUnits.add(new Serial("Attack on Titan", 8, 9));
        ArtUnits.add(new Serial("Bakugan", 5, 17));
        ArtUnits.add(new Serial("Brigada", 5, 9));

        ArtUnitStream.setList(ArtUnits);

        List<ArtUnit> matched = new ArrayList<>();
        matched.add(ArtUnitStream.matching(7));

        for (InfoPrinting element : matched) {
            if (element != null) {
                matchedList.append(element.getPartialInfo());
            }
        }

        expected += "Фильм: Spider-Man, рейтинг: 7\n";
        assertEquals(expected, matchedList.toString());
        assertThrows(NullPointerException.class, () -> {
            ArtUnitStream.matching(99);
        });
    }
}