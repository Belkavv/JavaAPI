package HomeWork_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("HP", 4, 256, "Windows 10", "Черный"));
        laptops.add(new Laptop("ASUS ROG", 24, 1024, "Windows 10", "Серебро"));
        laptops.add(new Laptop("MacBook AIR", 8, 512, "MacOS", "Серый"));
        laptops.add(new Laptop("Xiaomi Notebook", 16, 256, "Linux", "Белый"));
        laptops.add(new Laptop("Lenovo IdeaPad", 8, 512, "Windows 10", "Черный"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ОЗУ");
        criteria.put(2, "Памяти");

        Map<String, Integer> filterParams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.print("Введите минимальное значение " + entry.getValue() + ": ");
            int value = scanner.nextInt();
            filterParams.put(entry.getValue(), value);
        }

        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getRam() >= filterParams.get("ОЗУ") && laptop.getStorage() >= filterParams.get("Памяти")) {
                filteredLaptops.add(laptop);
            }
        }

        System.out.println("\nУдовлетворяющие критериям ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}