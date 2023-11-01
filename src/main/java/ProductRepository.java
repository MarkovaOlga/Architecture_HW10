//**Создание Repository для продуктов:
//
// Создайте класс ProductRepository, который будет служить репозиторием для продуктов.
// Он должен использовать DAO для доступа к данным.
// Репозиторий должен иметь методы для добавления, удаления и получения продуктов.
// Он также должен содержать логику, связанную с продуктами (например, проверку на корректность данных).

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {

    private ProductDao productDao;

    public ProductRepository(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getById(int id) {
        return productDao.findById(id);
    }


    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        if (product.getPrice() < 0) {
            System.out.println("Price of product is less then 0");
        }
        productDao.add(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }
}