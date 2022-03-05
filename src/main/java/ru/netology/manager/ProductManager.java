package ru.netology.manager;


import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;

    }

    public ProductManager() {
        this.repository = new ProductRepository();
    }

    public void add(Product pr) {
        repository.add(pr);

    }


    public Product[] searchBy(String text) {

        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = result[result.length];
                result = tmp;
            }
        }

        return result;

    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}
