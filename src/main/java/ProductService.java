import java.util.List;

//Создание Service Layer для продуктов:
//
//Создайте сервисный слой ProductService, который будет использовать репозиторий для выполнения операций с продуктами.
//Добавьте бизнес-логику в сервисе (например, проверку цены продукта).
//Сервис должен быть абстрагирован от сложностей доступа к данным и предоставлять интерфейс для работы с продуктами.
public class ProductService {
    private Repository <Product> productRepository;
    public ProductService(Repository<Product> productRepository) {
        this.productRepository = productRepository;
    }
    // Метод для добавления продукта с бизнес-логикой
    public void addProductWithLogic(Product product) {
        if (product.getName() != null && !product.getName().isEmpty()) {
            productRepository.add(product);
        }
    }

    public void deleteProductWithLogic(int id) {
        productRepository.delete(id);
    }

    // Метод для получения всех продуктов через репозиторий
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }
}
