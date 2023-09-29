import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class PhoneBook{

    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }
    public static void printBook(Map<String, ArrayList<Integer>> map) {
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    public static <K,V> Map<K,V> sortByValues(Map<K, V> map){
        Comparator<K> comparator = new CustomComparator(map);
        Map<K,V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        return sortedMap;
    }
    static class CustomComparator<K,V extends Comparable> implements Comparator<K>{
        private Map<K,V> map;

        public CustomComparator(Map<K,V> map){
            this.map = new HashMap<>(map);
        }

        @Override
        public int compare(K s1,K s2){
            ArrayList<String> arrayList1 = (ArrayList<String>) map.get(s1);
            ArrayList<String> arrayList2 = (ArrayList<String>) map.get(s2);
            return arrayList2.size() - arrayList1.size();
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 57463, bookPhone);
        addNumber("Ivanov", 91736, bookPhone);
        addNumber("Petrov", 74052, bookPhone);
        addNumber("Sidorov", 81537, bookPhone);
        addNumber("Ivanov", 18463, bookPhone);
        addNumber("Petrov", 25901, bookPhone);
        printBook(bookPhone);
        System.out.println("\nОтсортированная телефонная книга:");
        printBook(sortByValues(bookPhone));
    }
}