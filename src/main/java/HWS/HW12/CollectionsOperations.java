package HWS.HW12;

import java.util.*;

public class CollectionsOperations {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(0);
        numbers.add(2);
        numbers.add(3);
        numbers.add(14);
        numbers.add(23);
        numbers.add(23);
        numbers.add(-223);
        numbers.removeIf(i -> i % 2 != 0);
        System.out.println(numbers);
        HashSet<String> strings1 = new HashSet<>();
        strings1.add("A");
        strings1.add("B");
        HashSet<String> strings2 = new HashSet<>();
        strings2.add("B");
        strings2.add("C");
        HashSet<String> stringsConcat = new HashSet<>();
        stringsConcat.addAll(strings1);
        stringsConcat.addAll(strings2);
        System.out.println(stringsConcat);
        HashMap<String, Cow> cows = new HashMap<>();
        Cow cow1 = new Cow("Burenka");
        Cow cow2 = new Cow("Murka");
        Cow cow3 = new Cow("Tel");
        Cow cow4 = new Cow("Mymy");
        Cow cow5 = new Cow("Larka");
        Cow cow6 = new Cow("Zoyka");
        Cow cow7 = new Cow("Galks");
        Cow cow8 = new Cow("Milka");
        Cow cow9 = new Cow("Rijka");
        Cow cow10 = new Cow("Snejka");
        cows.put(cow1.getName(), cow1);
        cows.put(cow2.getName(), cow2);
        cows.put(cow3.getName(), cow3);
        cows.put(cow4.getName(), cow4);
        cows.put(cow5.getName(), cow5);
        cows.put(cow6.getName(), cow6);
        cows.put(cow7.getName(), cow7);
        cows.put(cow8.getName(), cow8);
        cows.put(cow9.getName(), cow9);
        cows.put(cow10.getName(), cow10);
        for (Map.Entry<String, Cow> entry : cows.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
