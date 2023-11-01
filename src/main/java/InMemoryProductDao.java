//Создание Data Access Object (DAO) для продуктов:
//
// Создайте класс ProductDAO, который будет содержать методы для добавления,
// удаления и получения продуктов из базы данных (или списка).
// Используйте этот класс для взаимодействия с данными о продуктах.

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}