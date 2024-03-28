/***
 * Это класс ноутбуков
 */

class Laptop {
    private String brand;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;
    
    /**
     * @param brand Бренд 
     * @param ram Оперативная память
     * @param storageCapacity Основная память
     * @param opertionSystem Операционная система
     * @param color Цвет
     */
    public Laptop(String brand, int ram, int storageCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры для доступа к полям класса

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storageCapacity=" + storageCapacity +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
