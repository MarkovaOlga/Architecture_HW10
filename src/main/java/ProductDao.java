import java.util.List;

public interface ProductDao {
    Product findById(int id);
    List<Product> findAll();
    void add(Product product);
    void delete(int id);
}
