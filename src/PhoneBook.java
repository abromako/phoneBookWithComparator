import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> phone = phoneBook.getOrDefault(name, new ArrayList<>());
        if (phone.contains(phoneNum)) {
            System.out.println("This entry already exists");
            return;
        }
        phone.add(phoneNum);
        phoneBook.put(name, phone);
    }

    public ArrayList<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public void sortByValue() {

        List<Map.Entry<String, ArrayList<Integer>>> list = new LinkedList<>(phoneBook.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<Integer>>>() {

            public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {

                int size1 = o1.getValue().size();
                int size2 = o2.getValue().size();
                return Integer.compare(size2, size1);
            }
        });

        LinkedHashMap<String, ArrayList<Integer>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        phoneBook = sortedMap;
    }
}

class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Berkov";

            phone1 = 123456;
            phone2 = 654321;
            phone3 = 765432;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
            phone3 = Integer.parseInt(args[4]);

        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name3, phone2);
        myPhoneBook.add(name3, phone1);

        System.out.println(myPhoneBook.find(name1));
        HashMap<String, ArrayList<Integer>> unsortedPhoneBook = myPhoneBook.getPhoneBook();
        System.out.println(unsortedPhoneBook);

        myPhoneBook.sortByValue();

        HashMap<String, ArrayList<Integer>> sortedPhoneBook = myPhoneBook.getPhoneBook();
        for (Map.Entry<String, ArrayList<Integer>> entry : sortedPhoneBook.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());

        }

    }

}
