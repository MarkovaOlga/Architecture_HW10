import java.util.ArrayList;
import java.util.List;

//Применение Unit of Work для транзакций:
//
//Создайте класс UnitOfWork, который будет позволять группировать операции с продуктами в рамках транзакции.
//Используйте Unit of Work для обеспечения атомарности изменений во время операций.
public class UnitOfWork {

    private ProductService productService;
    public UnitOfWork(ProductService productService) {
        this.productService = productService;
    }
    private List<Product> newProducts = new ArrayList<>();
    private List<Product> deletedProducts = new ArrayList<>();

    // Метод для добавления продукта в список новых продуктов
    public void addNewProduct(Product product) {
        newProducts.add(product);
    }

    // Метод для удаления продукта из списка продуктов
    public void deleteProduct(Product product) {
        deletedProducts.add(product);
    }

    // Метод для сохранения всех изменений
    public void commit() {
        for (Product product : newProducts) {
            productService.addProductWithLogic(product);
        }
        for (Product product : deletedProducts) {
            productService.deleteProductWithLogic(product.getId());
        }

        newProducts.clear();
        deletedProducts.clear();
    }

    // Метод для получения всех продуктов
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Метод для отмены всех операций
    public void cancelOperations() {
        newProducts.clear();
        deletedProducts.clear();
    }

}
