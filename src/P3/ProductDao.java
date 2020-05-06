package P3;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao {
    public Product save(Product product);
    public Product update(Product product);
    public boolean delete(Product product);
}