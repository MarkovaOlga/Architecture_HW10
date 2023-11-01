//Главная программа:
//
//В главной программе создайте несколько продуктов,
// добавьте их с помощью сервиса в рамках одной транзакции.
// Попробуйте отменить транзакцию (используя Unit of Work)
// и проверьте, что изменения не сохраняются.
// Затем завершите транзакцию и
// выведите список всех продуктов с их атрибутами на экран.
public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new InMemoryProductDao();
        Repository<Product> productRepository = new ProductRepository(productDao);
        ProductService productService = new ProductService(productRepository);
        UnitOfWork unitOfWork = new UnitOfWork(productService);

        Product product1 = new Product(1, "Laptop", 20000);
        Product product2 = new Product(2, "Smartphone", 25000);

        unitOfWork.addNewProduct(product1);
        unitOfWork.addNewProduct(product2);

        System.out.println("Products (before commit): " + productRepository.getAll());
        unitOfWork.cancelOperations();

        unitOfWork.commit();

        System.out.println("Products (after commit): " + productRepository.getAll());

        unitOfWork.addNewProduct(product1);
        unitOfWork.addNewProduct(product2);

        unitOfWork.commit();
        System.out.println("Products (after commit): " + productRepository.getAll());
    }
}
