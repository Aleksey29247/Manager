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
        int i = 0;
        Product[] result = new Product[repository.getItemsLength()];// тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result[i] = product;
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        Product[] result1 = new Product[i];
        for (int a = 0; a <= i - 1; a++) {
            result1[a] = result[a];
        }
        return result1;

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
