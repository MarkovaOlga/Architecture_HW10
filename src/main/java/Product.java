// Создание сущности Product:
//
//Создайте класс Product, который будет представлять собой
// продукт с атрибутами id, name и price.

public class Product {
    private int id;
    private String name;


    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Id: " + id + ", name: " + name + ", price: " + price;
    }
}