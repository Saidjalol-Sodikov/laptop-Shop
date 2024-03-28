import java.util.*;

public class program {
    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 1024, "Linux", "Silver"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Space Gray"));
        laptops.add(new Laptop("Lenovo", 12, 512, "Windows", "Black"));
        laptops.add(new Laptop("Asus", 8, 256, "Windows", "White"));
        laptops.add(new Laptop("Apple", 2, 512, "macOS", "Gray"));
        laptops.add(new Laptop("Lenovo", 4, 512, "Windows", "Green"));
        laptops.add(new Laptop("Asus", 16, 1024, "Linux", "Yellov"));
        laptops.add(new Laptop("Acer", 8, 512, "Windows", "Blue"));
        laptops.add(new Laptop("MSI", 32, 2048, "Windows", "Black"));

        // Критерии фильтрации и минимальные значения для них
        Map<String, Object> filters = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите критерии фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            System.out.print("Выберите критерий: ");
            int criterion = scanner.nextInt();

            switch (criterion) {
                case 1:
                    System.out.print("Введите минимальный объем ОЗУ: ");
                    int minRam = scanner.nextInt();
                    filters.put("ram", minRam);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ЖД: ");
                    int minStorageCapacity = scanner.nextInt();
                    filters.put("storageCapacity", minStorageCapacity);
                    break;
                case 3:
                    System.out.print("Введите требуемую операционную систему: ");
                    String os = scanner.next();
                    filters.put("operatingSystem", os);
                    break;
                case 4:
                    System.out.print("Введите требуемый цвет: ");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    return;
            }
        }

        // Фильтрация ноутбуков
        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);

        // Вывод результатов
        System.out.println("Найденные ноутбуки:");
        System.out.println("| Марка     | ОЗУ | Объем ЖД | ОС       | Цвет       |");
        System.out.println("|-----------|-----|----------|----------|------------|");
        for (Laptop laptop : filteredLaptops) {
            System.out.printf("| %-10s| %3d | %8d | %-9s| %-11s|%n",
                    laptop.getBrand(), laptop.getRam(), laptop.getStorageCapacity(),
                    laptop.getOperatingSystem(), laptop.getColor());
        }
    }

    // Метод для фильтрации ноутбуков
    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean meetsCriteria = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "ram":
                        if (laptop.getRam() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "storageCapacity":
                        if (laptop.getStorageCapacity() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!laptop.getOperatingSystem().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                }
            }
            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}
