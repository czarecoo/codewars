package org.czareg.codewars.address.book.by.state;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateGrouperTest {

    @Test
    void test1() {
        String input = """
                John Daggett, 341 King Road, Plymouth MA
                Alice Ford, 22 East Broadway, Richmond VA
                Orville Thomas, 11345 Oak Bridge Road, Tulsa OK
                Terry Kalkas, 402 Lans Road, Beaver Falls PA
                Eric Adams, 20 Post Road, Sudbury MA
                Hubert Sims, 328A Brook Road, Roanoke MA
                Amy Wilde, 334 Bayshore Pkwy, Mountain View CA
                Sal Carpenter, 73 6th Street, Boston MA""";
        String expected = """
                California
                ..... Amy Wilde 334 Bayshore Pkwy Mountain View California
                 Massachusetts
                ..... Eric Adams 20 Post Road Sudbury Massachusetts
                ..... Hubert Sims 328A Brook Road Roanoke Massachusetts
                ..... John Daggett 341 King Road Plymouth Massachusetts
                ..... Sal Carpenter 73 6th Street Boston Massachusetts
                 Oklahoma
                ..... Orville Thomas 11345 Oak Bridge Road Tulsa Oklahoma
                 Pennsylvania
                ..... Terry Kalkas 402 Lans Road Beaver Falls Pennsylvania
                 Virginia
                ..... Alice Ford 22 East Broadway Richmond Virginia""";
        assertEquals(expected, StateGrouper.group(input));
    }

    @Test
    void test2() {
        String input = """
                John Daggett, 341 King Road, Plymouth MA
                Alice Ford, 22 East Broadway, Richmond VA
                Orville Thomas, 11345 Oak Bridge Road, Tulsa OK
                Terry Kalkas, 402 Lans Road, Beaver Falls PA
                Eric Adams, 20 Post Road, Sudbury MA
                Hubert Sims, 328A Brook Road, Roanoke VA
                Amy Wilde, 334 Bayshore Pkwy, Mountain View CA
                Sal Carpenter, 73 6th Street, Boston MA""";
        String expected = """
                California
                ..... Amy Wilde 334 Bayshore Pkwy Mountain View California
                 Massachusetts
                ..... Eric Adams 20 Post Road Sudbury Massachusetts
                ..... John Daggett 341 King Road Plymouth Massachusetts
                ..... Sal Carpenter 73 6th Street Boston Massachusetts
                 Oklahoma
                ..... Orville Thomas 11345 Oak Bridge Road Tulsa Oklahoma
                 Pennsylvania
                ..... Terry Kalkas 402 Lans Road Beaver Falls Pennsylvania
                 Virginia
                ..... Alice Ford 22 East Broadway Richmond Virginia
                ..... Hubert Sims 328A Brook Road Roanoke Virginia""";
        assertEquals(expected, StateGrouper.group(input));
    }

    @Test
    void test3() {
        String input = """
                John Pulsett, 321 King Street, Palmouth MA
                Alisa Gord, 22 Prin Broadway, Georges VA
                Oreste Thulas, 11354 East Bridge Road, Pensa OK
                Perry Falpas, 420 Land Road, Beaver Halls PA
                Erica Adamson, 200 Station Road, Westbury MA
                Paulo Sims, 8A River Street, Richmond VA
                Ann Wildon, 334 Shore Parkway, Hill View CA
                Al Carpenter, 730 3rd Street, Boston MA""";
        String expected = """
                California
                ..... Ann Wildon 334 Shore Parkway Hill View California
                 Massachusetts
                ..... Al Carpenter 730 3rd Street Boston Massachusetts
                ..... Erica Adamson 200 Station Road Westbury Massachusetts
                ..... John Pulsett 321 King Street Palmouth Massachusetts
                 Oklahoma
                ..... Oreste Thulas 11354 East Bridge Road Pensa Oklahoma
                 Pennsylvania
                ..... Perry Falpas 420 Land Road Beaver Halls Pennsylvania
                 Virginia
                ..... Alisa Gord 22 Prin Broadway Georges Virginia
                ..... Paulo Sims 8A River Street Richmond Virginia""";
        assertEquals(expected, StateGrouper.group(input));
    }

    @Test
    void test4() {
        String input = """
                John Pulsett, 321 King Street, Palmouth AZ
                Alisa Gord, 22 Prin Broadway, Georges ID
                Oreste Thulas, 11354 East Bridge Road, Pensa AZ
                Perry Falpas, 420 Land Road, Beaver Halls PA
                Erica Adamson, 200 Station Road, Westbury AZ
                Paulo Sims, 8A River Street, Richmond ID
                Ann Wildon, 334 Shore Parkway, Hill View IN
                Al Carpenter, 730 3rd Street, Phoenix AZ""";
        String expected = """
                Arizona
                ..... Al Carpenter 730 3rd Street Phoenix Arizona
                ..... Erica Adamson 200 Station Road Westbury Arizona
                ..... John Pulsett 321 King Street Palmouth Arizona
                ..... Oreste Thulas 11354 East Bridge Road Pensa Arizona
                 Idaho
                ..... Alisa Gord 22 Prin Broadway Georges Idaho
                ..... Paulo Sims 8A River Street Richmond Idaho
                 Indiana
                ..... Ann Wildon 334 Shore Parkway Hill View Indiana
                 Pennsylvania
                ..... Perry Falpas 420 Land Road Beaver Halls Pennsylvania""";
        assertEquals(expected, StateGrouper.group(input));
    }

    @Test
    void test5() {
        String input = """
                John Daggett, 341 King Road, Plymouth MA
                Alice Ford, 22 East Broadway, Richmond VA
                Sal Carpenter, 73 6th Street, Boston MA""";
        String expected = """
                Massachusetts
                ..... John Daggett 341 King Road Plymouth Massachusetts
                ..... Sal Carpenter 73 6th Street Boston Massachusetts
                 Virginia
                ..... Alice Ford 22 East Broadway Richmond Virginia""";
        assertEquals(expected, StateGrouper.group(input));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int k = randInt();
            String input = prepareInput(k);
            String expected = solution(input);
            assertEquals(expected, StateGrouper.group(input));
        }
    }

    private static String solution(String str) {
        class StateFriend {
            String state;
            String name;
            String address;
            String town;
        }
        ;
        class CustomComparator implements Comparator<StateFriend> {
            @Override
            public int compare(StateFriend o1, StateFriend o2) {
                if (o1.state.equals(o2.state)) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.state.compareTo(o2.state);
            }
        }
        String[] sa = new String[]{" MA", " VA", " OK", " PA", " CA", " AZ", " ID", " IN"};
        String[] st = new String[]{", Massachusetts", ", Virginia", ", Oklahoma", ", Pennsylvania", ", California", ", Arizona", ", Idaho", ", Indiana"};
        for (int i = 0; i < sa.length; i++) {
            str = str.replace(sa[i], st[i]);
        }
        String[] arr = str.split("[\\n]+");
        List<StateFriend> narr = new ArrayList<>();
        for (String string : arr) {
            String[] y = string.split(", ");
            StateFriend sf = new StateFriend();
            sf.state = y[3].trim();
            sf.name = y[0];
            sf.address = y[1];
            sf.town = y[2];
            narr.add(sf);
        }
        narr.sort(new CustomComparator());
        StringBuilder result = new StringBuilder();
        String last = "";
        for (StateFriend sf : narr) {
            String e = sf.state;
            if (!e.equals(last)) {
                last = e;
                result.append("\n" + " ").append(e).append("\n..... ").append(sf.name).append(" ").append(sf.address).append(" ").append(sf.town).append(" ").append(sf.state);
            } else {
                result.append("\n..... ").append(sf.name).append(" ").append(sf.address).append(" ").append(sf.town).append(" ").append(sf.state);
            }
        }
        return result.substring(2);
    }

    private static String prepareInput(int k) {
        String[] names = new String[]{"John Deere", "Rafa String", "Paul Pep", "Fitz Buzz", "Laurel Tango", "Mac Bud", "Paul Cartney", "Raf Johnson", "Buf Kid",
                "Ama Zon", "Chris Maker", "Ann Hidalgo", "Bill Joke", "Richard Stall", "Antony None", "Burt Lane", "Fanny Hem", "Louis Tor", "Sim Burton", "Ad Knew"}; // 20
        String[] addr = new String[]{"321 King Street", "22 Prin Broadway", "11354 East Bridge Road", "420 Land Road", "200 Station Road", "8A River Street", "334 Shore Parkway",
                "11345 Oak Bridge Road", "328A Brook Road", "730 3rd Street", "73 Bd Tucs", "402 Bun Road", "12 Loan Alley", "213 Cap Bono", "90 Pen Avenue",
                "45 Bridge Port", "10 Abbe Road", "2134 Clint Street", "5AA Clear Bd", "1C Hilary Main Street"}; // 20
        String[] twns = new String[]{"Plymouth MA", "Westbury AZ", "Hill View IN", "Plymouth MA", "Richmond ID", "Mountain View CA", "Plymouth MA", "Richmond ID", "Westbury AZ",
                "Mount View CA", "Hill View IN", "Mountain View CA", "Beaver Falls PA", "Beaver Falls PA"}; // 14
        shuffle(names);
        shuffle(addr);
        shuffle(twns);
        int q = 0;
        StringBuilder res = new StringBuilder();
        while (q < k) {
            res.append(names[q]).append(", ").append(addr[q]).append(", ").append(twns[q]).append("\n");
            q++;
        }
        return res.substring(0, res.length() - 1);
    }

    private static void shuffle(String[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    private static int randInt() {
        return (int) (5 + Math.random() * 4);
    }
}