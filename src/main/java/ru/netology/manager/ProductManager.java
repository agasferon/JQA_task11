package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository = new ProductRepository();

    public ProductManager() {
    }

    public Product[] getAll() {
        Product[] products = repository.findAll();
        Product[] result = new Product[products.length];
        for (int i = 0; i < result.length; i++) {
            int index = products.length - i - 1;
            result[i] = products[index];
        }
        return result;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}